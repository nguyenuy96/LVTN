package com.app.dao.product;

import java.util.List;

import com.app.model.Warehouse;

public interface WarehouseDao {
	
	void saveOrUpdateWarehouse(Warehouse warehouse);

	List<Warehouse> listWarehouse();

	Warehouse getWarehouse(int warehouseId);

}
