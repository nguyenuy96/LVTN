package com.app.service.impl;

import java.util.List;

import com.app.dao.*;
import com.app.utils.Constants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.exception.ExceptionHandle;
import com.app.exception.ExceptionThrower;
import com.app.model.Account;
import com.app.model.Role;
import com.app.model.CusProfDTO;
import com.app.model.Customer;
import com.app.model.Employee;
import com.app.model.ModifiedPassword;
import com.app.model.EmpProfDTO;
import com.app.service.AccountService;

@Service
//@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDao accountDao;

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private RoleDao roleDao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void addNewUser(Object userObj) {
		Account account = new Account();
		modelMapper.map(userObj, account);
		checkUserBeforeSave(account);
		Role role = roleDao.findById(account.getRole().getRoleId())
				.orElseThrow(() -> new IllegalArgumentException("Role not found"));
		if (Constants.CUSTOMER.equals(role.getRoleName())) {
			checkCusProf(account.getCustomer());
		} else {
			checkEmpProf(account.getEmployee());
		}
		accountDao.save(account);
	}

	@Override
	public void changePassword(ModifiedPassword modifiedPassword) {
		Account modifiedAccount = accountDao.findByUserName(modifiedPassword.getUsername())
				.orElseThrow(() -> new IllegalArgumentException("Invalid user"));
		if (!bCryptPasswordEncoder.matches(modifiedPassword.getOldPassword(), modifiedAccount.getPassword())) {
			throw new IllegalArgumentException("Incorrect old password");
		}

		if (!modifiedPassword.getNewPassword().equals(modifiedPassword.getRetypePassword())) {
			throw new IllegalArgumentException("New password and re-type are not matched");
		}
		modifiedAccount.setPassword(bCryptPasswordEncoder.encode(modifiedPassword.getNewPassword()));
		accountDao.save(modifiedAccount);
	}

	@Override
	public Account getAccountByUsername(String userName) {
		return accountDao.findByUserName(userName)
				.orElseThrow(() -> new IllegalArgumentException(String.format("Not found user [%s]", userName)));
	}

	public void checkCusProf(Customer customer) {
		if (customer.getName() == null || customer.getAddress() == null || customer.getPhoneNumber() == null) {
			throw new IllegalArgumentException(
					"Customer profile required fields {name: String, phoneNumber: String, address:String}");
		}
	}

	public void checkEmpProf(Employee employee){
		String identification = employee.getIdentification();
		//todo throw conflict exception
		employeeDao.findByIdentification(identification)
				.orElseThrow(() -> new IllegalArgumentException("Identification is used!"));
		if (employee.getName() == null || employee.getGender() == null ||
				employee.getPhoneNumber() == null || employee.getNationality() == null
				|| identification == null || employee.getAddress() == null) {
			throw new IllegalArgumentException("Employee profile required fields {name: String," +
					" gender: String, phoneNumber: String, nationality: String," +
					" identification: String, address:String}");
		}
	}

	public Role validateRole(Role role) {
		String roleName = role.getRoleName();
		if (roleName == null) {
			throw new IllegalArgumentException("Role is required!");
		}
		return roleDao.findByRoleName(roleName).orElseThrow(() -> new IllegalArgumentException(
				String.format("%s does't match one of role types: Manager; Employee; Customer", roleName)));
	}

	public void checkUserBeforeSave(Account account) {
		String userName = account.getUserName();
		if(userName == null) {
			throw new IllegalArgumentException("Username is required");
		}

		String password = account.getPassword();
		if(password == null) {
			throw new IllegalArgumentException("Password is required");
		}

		Role role = account.getRole();
		if (role == null) {
			throw new IllegalArgumentException("Role is required");
		}

		accountDao.findByUserName(userName).ifPresent(e -> {
			throw new IllegalArgumentException("Existed user");
		});
		account.setPassword(bCryptPasswordEncoder.encode(password));
		account.setRole(validateRole(role));
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
//		boolean validIdentification = userDao.checkIdentification(identification) ? false : true;
		boolean validIdentification = true;
		if (!validIdentification)
			new ExceptionThrower().throwException(HttpStatus.CONFLICT, "Identification is used!");
//		Employee modifyEmp = userDao.getEmpProfile(accId);
		Employee modifyEmp = null;
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
//		Customer modifyCus = userDao.getCusProfile(accId);
		Customer modifyCus = null;
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

}
