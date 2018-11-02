package com.app.dao.impl.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.impl.HibernateResult;
import com.app.dao.product.WarehouseDao;
import com.app.model.Warehouse;

@Repository
public class WarehousrDaoImpl implements WarehouseDao {

	@Autowired
	private HibernateResult hibernate;

	@Override
	public void saveOrUpdateWarehouse(Warehouse warehouse) {
		hibernate.getSession().saveOrUpdate(warehouse);
	}

	@Override
	public List<Warehouse> listWarehouse() {
		List<Warehouse> listWarehouse = hibernate.getResultList(Warehouse.class);
		return listWarehouse;
	}

	@Override
	public Warehouse getWarehouse(int warehouseId) {
		Warehouse warehouse = hibernate.getById(Warehouse.class, warehouseId);
		return warehouse;
	}

}
