package com.app.service.impl;

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
import com.app.model.Customer;
import com.app.model.Employee;
import com.app.service.AccountService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;

	@Transactional
	@Override
	public Account registerAccountSrvc(Account account) throws ExceptionHandle {
		if (accountDao.checkAccount(account)) {
			new ExceptionThrower().throwException(HttpStatus.CONFLICT, "Existed account!");
		}
		if (account.getPermission() == null || account.getUsername() == null || account.getPassword() == null) {
			new ExceptionThrower().throwException(HttpStatus.BAD_REQUEST, "Please fill in all required fields!");
		}
		AccountPermission accountPermission = accountDao.getPermissionType(account.getPermission().getPermissionType());
		if (accountPermission == null) {
			new ExceptionThrower().throwException(HttpStatus.BAD_REQUEST, "Permission type is incorrect!");
		}
		account.setPermission(accountPermission);
		return accountDao.registerAccountDao(account);
	}

	@Override
	public Account accountDetailSrvc(Account account) throws ExceptionHandle {
		Account retAccount = accountDao.accountDetailDao(account);
		return retAccount;
	}

	@Override
	public Account findAccountByPhoneNumSrvc(String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public void updatePasswordSrvc(int accountId, Account account) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkUsername(String username) throws ExceptionHandle {
		boolean isValidUsername = accountDao.checkUsername(username);
		if (!isValidUsername) {
			new ExceptionThrower().throwException(HttpStatus.CONFLICT, "Username is invalid");
		}
		return isValidUsername;
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

	@Transactional
	@Override
	public void createUser(List<Object> lstUserProp) throws ExceptionHandle {
		Account account = convertToAccount(lstUserProp.get(0));
		AccountPermission accountPermission = accountDao.getPermissionType(account.getPermission().getPermissionType());
		account.setPermission(accountPermission);
		accountDao.saveOrUpdateAccount(account);
		if (account.getPermission().getPermissionType() == "Customer") {
			Customer customer = convertToCustomer(lstUserProp.get(1));
			customer.setAccount(account);
			accountDao.saveOrUpdateCusProf(customer);
		} else {
			Employee employee= convertToEmployee(lstUserProp.get(1));
			employee.setAccount(account);
			accountDao.saveOrUpdateEmpProf(employee);
		}
	}

}
