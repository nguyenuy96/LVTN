package com.app.dao.impl.user;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.impl.HibernateResult;
import com.app.dao.user.CustomerDao;
import com.app.model.Customer;
@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private HibernateResult hibernate;

	@Override
	public void updateCusProfile(Customer customer) {
		hibernate.getSession().saveOrUpdate(customer);
	}

	@Override
	public List<Customer> getCustomerAccount() {
		List<Customer> listCustomer = hibernate.getResultList(Customer.class);
		return listCustomer;
	}

	@Override
	public Customer getCusProfile(int accId) {
		Query<Customer> query = hibernate.inputIntQuery(Customer.class, "accountId", accId);
		return (query.list().size() == 1) ? query.getSingleResult() : null;
	}

}
