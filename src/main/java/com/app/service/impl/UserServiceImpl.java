package com.app.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserDao;
import com.app.exception.ExceptionHandle;
import com.app.exception.ExceptionThrower;
import com.app.model.Account;
import com.app.model.Role;
import com.app.model.CusProfDTO;
import com.app.model.Customer;
import com.app.model.Employee;
import com.app.model.EmpProfDTO;
import com.app.model.AccountDTO;
import com.app.service.UserService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao accountDao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Account accountDetailSrvc(Account account) throws ExceptionHandle {
		Account retAccount = accountDao.checkAccountDao(account.getUsername());
		if (retAccount == null)
			new ExceptionThrower().throwException(HttpStatus.NOT_FOUND, "Invalid user");
		return retAccount;
	}

	@Override
	public Account findAccountByPhoneNumSrvc(String phoneNumber) {
		return null;
	}

	@Transactional
	@Override
	public void updatePasswordSrvc(Account account) throws ExceptionHandle {
		Account modifiedAccount = accountDao.checkAccountDao(account.getUsername());
		if (modifiedAccount == null) {
			new ExceptionThrower().throwException(HttpStatus.NOT_FOUND, "Invalid user");
		} else {
			modifiedAccount.setPassword(account.getPassword());
			accountDao.updatePasswordDao(modifiedAccount);
		}
	}

	@Transactional
	@Override
	public void deleteAccountSrvc(int accountId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Role saveOrUpdateRoleSrvc(Role role) throws ExceptionHandle {
		Role retPermission = accountDao.getRole(role.getRole());
		if (retPermission != null) {
			new ExceptionThrower().throwException(HttpStatus.CONFLICT, "Existed role!");
		}
		if (role.getRole() == null) {
			new ExceptionThrower().throwException(HttpStatus.BAD_REQUEST, "Role is required");
		}
		return accountDao.savePermissionDao(role);
	}

	@Override
	public List<Account> getCustomerAccount(int customerRole) {
		return accountDao.getCustomerAccount(customerRole);
	}

	@Override
	public List<Account> getEmployeeAccount(int employeeRole) {
		return accountDao.getEmployeeAccount(employeeRole);
	}

	@Override
	public boolean checkUsername(String username) throws ExceptionHandle {
		boolean isValidUsername = accountDao.checkAccountDao(username) == null ? false : true;
		if (!isValidUsername) {
			new ExceptionThrower().throwException(HttpStatus.NOT_FOUND, "Invalid user");
		}
		return isValidUsername;
	}

	public boolean isInvalidCusProf(Customer customer) {
		String name = customer.getName();
		String address = customer.getAddress();
		String phone = customer.getPhoneNumber();
		return (name == null || address == null || phone == null);
	}

	public boolean isInvalidEmpProf(Employee employee) throws ExceptionHandle {
		String name = employee.getName();
		String gender = employee.getGender();
		String phone = employee.getPhoneNumber();
		String nationality = employee.getNationality();
		String identification = employee.getIdentification();
		String address = employee.getAddress();
		boolean validIdentification = accountDao.checkIdentification(identification) ? false : true;
		if (!validIdentification)
			new ExceptionThrower().throwException(HttpStatus.CONFLICT, "Identification is used!");
		return (name == null || gender == null || phone == null || nationality == null || identification == null
				|| address == null);
	}

	public Role checkRoleBeforeSave(Role role) throws ExceptionHandle {
		String roleName = role.getRole();
		if (roleName == null)
			new ExceptionThrower().throwException(HttpStatus.BAD_REQUEST, "Role is required!");
		Role getRole = accountDao.getRole(roleName);
		if (getRole == null) {
			new ExceptionThrower().throwException(HttpStatus.NOT_FOUND,
					roleName + " does't match one of role types: Manager; Employee; Customer");
		}
		return getRole;
	}

	public Account checkUserBeforeSave(Account account) throws ExceptionHandle {
		String username = account.getUsername();
		String password = account.getPassword();
		Role role = account.getAccountRole();
		if (username == null || password == null)
			new ExceptionThrower().throwException(HttpStatus.BAD_REQUEST, "Username and password are required!");
		if (accountDao.checkAccountDao(account.getUsername()) != null)
			new ExceptionThrower().throwException(HttpStatus.CONFLICT, "Existed user!");
		if (role == null)
			new ExceptionThrower().throwException(HttpStatus.BAD_REQUEST, "Role cant be null");
		String salt_password = bCryptPasswordEncoder.encode(password);
		account.setPassword(salt_password);
		account.setAccountRole(checkRoleBeforeSave(role));
		return account;
	}

	@Transactional
	@Override
	public void saveUserSrvc(List<Object> listUserProp) throws ExceptionHandle {
		if (listUserProp.size() != 2)
			new ExceptionThrower().throwException(HttpStatus.BAD_REQUEST,
					"Account information and Profile cant be null!");
		Account account = convertToAccount(listUserProp.get(0));
		checkUserBeforeSave(account);
		if (account.getAccountRole().getRole().equals("Customer")) {
			Customer customer = convertToCustomer(listUserProp.get(1));
			if (isInvalidCusProf(customer))
				new ExceptionThrower().throwException(HttpStatus.BAD_REQUEST,
						"Customer profile requried fields {name: String, phoneNumber: String, address:String}");
			customer.setAccount(account);
			accountDao.saveOrUpdateCusProf(customer);
		} else {
			Employee employee = convertToEmployee(listUserProp.get(1));
			if (isInvalidEmpProf(employee))
				new ExceptionThrower().throwException(HttpStatus.BAD_REQUEST,
						"Employee profile requried fields {name: String, "
								+ "gender: String, phoneNumber: String, nationality: String, identification: String, address:String}");
			employee.setAccount(account);
			accountDao.saveOrUpdateEmpProf(employee);
		}
	}

	private ModelMapper modelMapper = new ModelMapper();

	public Account convertToAccount(Object obj) {
		Account account = new Account();
		modelMapper.map(obj, account);
		return account;
	}

	public Customer convertToCustomer(Object obj) {
		Customer customer = new Customer();
		modelMapper.map(obj, customer);
		return customer;
	}

	public Employee convertToEmployee(Object obj) {
		Employee employee = new Employee();
		modelMapper.map(obj, employee);
		return employee;
	}

	public Employee saveEmpProf(EmpProfDTO empProfDTO, int accId) throws ExceptionHandle {
		String address = empProfDTO.getAddress();
		String gender = empProfDTO.getGender();
		String identification = empProfDTO.getIdentification();
		String name = empProfDTO.getFullname();
		String nationality = empProfDTO.getNationality();
		String phone = empProfDTO.getPhone();
		boolean validIdentification = accountDao.checkIdentification(identification) ? false : true;
		if (!validIdentification)
			new ExceptionThrower().throwException(HttpStatus.CONFLICT, "Identification is used!");
		Employee modifyEmp = accountDao.getEmpProfile(accId);
		if (address != null) {
			modifyEmp.setAddress(address);
		}
		if (gender != null) {
			modifyEmp.setGender(gender);
		}
		if (identification != null) {
			modifyEmp.setIdentification(identification);
		}
		if (name != null) {
			modifyEmp.setName(name);
		}
		if (nationality != null) {
			modifyEmp.setNationality(nationality);
		}
		if (phone != null) {
			modifyEmp.setPhoneNumber(phone);
		}
		return modifyEmp;
	}

	public Customer saveCusProf(CusProfDTO cusProfDTO, int accId) {
		Customer modifyCus = accountDao.getCusProfile(accId);
		String address = cusProfDTO.getAddress();
		String name = cusProfDTO.getFullname();
		String phone = cusProfDTO.getPhone();
		if (address != null) {
			modifyCus.setAddress(address);
		}
		if (name != null) {
			modifyCus.setName(name);
		}
		if (phone != null) {
			modifyCus.setPhoneNumber(phone);
		}
		return modifyCus;
	}

	@Transactional
	@Override
	public void updateProfile(Object obj) throws ExceptionHandle {
		AccountDTO accDTO = new AccountDTO();
		modelMapper.map(obj, accDTO);
		Account account = accountDao.checkAccountDao(accDTO.getAccount().getUsername());
		if (account == null)
			new ExceptionThrower().throwException(HttpStatus.NOT_FOUND, "Cant find user!");
		int accId = accountDao.checkAccountDao(account.getUsername()).getAccountId();
		if (account.getAccountRole().getRole().equals("Customer")) {
			CusProfDTO cusProfDTO = new CusProfDTO();
			modelMapper.map(obj, cusProfDTO);
			accountDao.saveOrUpdateCusProf(saveCusProf(cusProfDTO, accId));
		} else {
			EmpProfDTO empProfDTO = new EmpProfDTO();
			modelMapper.map(obj, empProfDTO);
			accountDao.saveOrUpdateEmpProf(saveEmpProf(empProfDTO, accId));
		}
	}

	@Override
	public Customer getCusProfile(Account account) {
		Account cusAcc = accountDao.checkAccountDao(account.getUsername());
		Customer customerProf = accountDao.getCusProfile(cusAcc.getAccountId());
		return customerProf;
	}

}
