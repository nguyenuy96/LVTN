package com.app.service.product;

import java.util.List;

import com.app.model.Warehouse;

public interface WarehouseService {
	void saveWarehouse(Warehouse warehouse);

	List<Warehouse> getWarehouses();
}
