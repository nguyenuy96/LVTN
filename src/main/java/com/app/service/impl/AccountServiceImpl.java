package com.app.service.impl;


import com.app.dao.*;
import com.app.utils.Constants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
//		if (Constants.CUSTOMER.equals(role.getRoleName())) {
//			checkCusProf(account.getCustomer());
//		} else {
//			checkEmpProf(account.getEmployee());
//		}
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

	private final ModelMapper modelMapper = new ModelMapper();

}
