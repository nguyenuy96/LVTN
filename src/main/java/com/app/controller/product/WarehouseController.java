package com.app.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Warehouse;
import com.app.service.product.WarehouseService;

@CrossOrigin
@RestController
@RequestMapping(path = "/warehouse")
public class WarehouseController {
	@Autowired
	private WarehouseService warehouseService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> addWarehouse(@RequestBody Warehouse warehouse) {
		warehouseService.saveWarehouse(warehouse);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Warehouse>> getWarehouses() {
		List<Warehouse> listWarehouse = warehouseService.getWarehouses();
		return new ResponseEntity<List<Warehouse>>(listWarehouse, HttpStatus.OK);
	}
}
