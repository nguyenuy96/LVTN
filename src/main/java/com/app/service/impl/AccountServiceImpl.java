package com.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AccountDao;
import com.app.exception.ExceptionHandle;
import com.app.exception.ExceptionThrower;
import com.app.model.Account;
import com.app.model.AccountPermission;
import com.app.model.CusProfDTO;
import com.app.model.Customer;
import com.app.model.Employee;
import com.app.model.EmpProfDTO;
import com.app.model.AccountDTO;
import com.app.service.AccountService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;

	@Override
	public Account accountDetailSrvc(Account account) throws ExceptionHandle {
		Account retAccount = accountDao.checkAccountDao(account.getUsername());
		return retAccount;
	}

	@Override
	public Account findAccountByPhoneNumSrvc(String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public void updatePasswordSrvc(Account account) throws ExceptionHandle {
		Account modifiedAccount = accountDao.checkAccountDao(account.getUsername());
		if (modifiedAccount == null) {
			new ExceptionThrower().throwException(HttpStatus.NOT_FOUND, "Not found user");
		} else {
			modifiedAccount.setPassword(account.getPassword());
			accountDao.updatePasswordDao(modifiedAccount);
		}
	}

	@Transactional
	@Override
	public void updateAccountInfSrvc(int accountId, Account account) {
		// TODO Auto-generated method stub

	}

	@Transactional
	@Override
	public void deleteAccountSrvc(int accountId) {
		// TODO Auto-generated method stub

	}

	@Override
	public AccountPermission savePermissionSrvc(AccountPermission permission) throws ExceptionHandle {
		AccountPermission retPermission = accountDao.getPermissionType(permission.getPermissionType());
		if (retPermission != null) {
			new ExceptionThrower().throwException(HttpStatus.CONFLICT, "Existed permission!");
		}
		if (permission.getPermissionType() == null) {
			new ExceptionThrower().throwException(HttpStatus.BAD_REQUEST, "Permisstion type is required");
		}
		return accountDao.savePermissionDao(permission);
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
			new ExceptionThrower().throwException(HttpStatus.CONFLICT, "Username is invalid");
		}
		return isValidUsername;
	}

	@Transactional
	@Override
	public void createUserSrvc(List<Object> lstUserProp) throws ExceptionHandle {
		Account account = convertToAccount(lstUserProp.get(0));
		AccountPermission accountPermission = accountDao.getPermissionType(account.getPermission().getPermissionType());
		account.setPermission(accountPermission);
		accountDao.saveOrUpdateAccount(account);
		if (account.getPermission().getPermissionType().equals("Customer")) {
			Customer customer = convertToCustomer(lstUserProp.get(1));
			customer.setAccount(account);
			accountDao.saveOrUpdateCusProf(customer);
		} else {
			Employee employee = convertToEmployee(lstUserProp.get(1));
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

	public Employee saveEmpProf(EmpProfDTO empProfDTO, int accId) {
		String address = empProfDTO.getAddress();
		String gender = empProfDTO.getGender();
		String identification = empProfDTO.getIdentification();
		String name = empProfDTO.getFullname();
		String nationality = empProfDTO.getNationality();
		String phone = empProfDTO.getPhone();
		Employee modifyEmp = accountDao.getEmpProfile(accId);
		if (address != null || address != "") {
			empProfDTO.setAddress(address);
		}
		if (gender != null || gender != "") {
			empProfDTO.setGender(gender);
		}
		if (identification != null || identification != "") {
			empProfDTO.setIdentification(identification);
		}
		if (name != null || name != "") {
			empProfDTO.setFullname(name);
		}
		if (nationality != null || nationality != "") {
			empProfDTO.setNationality(nationality);
		}
		if (phone != null || phone != "") {
			empProfDTO.setPhone(phone);
		}
		return modifyEmp;
	}

	public Customer saveCusProf(CusProfDTO cusProfDTO, int accId) {
		Customer modifyCus = accountDao.getCusProfile(accId);
		String address = cusProfDTO.getAddress();
		String name = cusProfDTO.getFullname();
		String phone = cusProfDTO.getPhone();
		if (!address.equals(null) || !address.equals("")) {
			modifyCus.setAddress(address);
		}
		if (name != null || name != "") {
			modifyCus.setName(name);
		}
		if (phone != null || phone != "") {
			modifyCus.setPhoneNumber(phone);
		}
		return modifyCus;
	}

	@Override
	public Object updateProfile(Object listObj) {
		AccountDTO accDTO = new AccountDTO();
		modelMapper.map(listObj, accDTO);
		Account account = accountDao.checkAccountDao(accDTO.getAccount().getUsername());
		int accId = accountDao.checkAccountDao(account.getUsername()).getAccountId();
		if (account.getPermission().getPermissionType().equals("Customer")) {
			CusProfDTO cusProfDTO = new CusProfDTO();
			modelMapper.map(listObj, cusProfDTO);
			accountDao.saveOrUpdateCusProf(saveCusProf(cusProfDTO, accId));
		} else {
			EmpProfDTO empProfDTO = new EmpProfDTO();
			modelMapper.map(listObj, empProfDTO);
			accountDao.saveOrUpdateEmpProf(saveEmpProf(empProfDTO, accId));
		}
		return true;
	}

	@Override
	public Customer getCusProfile(Account account) {
		Account cusAcc = accountDao.checkAccountDao(account.getUsername());
		return accountDao.getCusProfile(cusAcc.getAccountId());
	}

}
