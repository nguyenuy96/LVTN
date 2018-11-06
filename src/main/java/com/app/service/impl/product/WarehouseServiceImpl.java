package com.app.service.impl.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.product.WarehouseDao;
import com.app.model.Warehouse;
import com.app.service.product.WarehouseService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class WarehouseServiceImpl implements WarehouseService {

	@Autowired
	private WarehouseDao warehouseDao;

	@Override
	public void saveWarehouse(Warehouse warehouse) {
		warehouseDao.saveOrUpdateWarehouse(warehouse);
	}

	@Override
	public List<Warehouse> getWarehouses() {
		List<Warehouse> listWarehouse = warehouseDao.listWarehouse();
		return listWarehouse;
	}
}
