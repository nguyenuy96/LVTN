package com.app.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.ExportReceipt;
import com.app.service.product.ProductExportRecSrvc;

@CrossOrigin
@RestController
@RequestMapping(path = "/export")
public class ExportRecController {

	@Autowired
	private ProductExportRecSrvc productExportRecSrvc;

	@RequestMapping(path = "/{orderId}", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> saveExportRec(@PathVariable(value = "orderId") int orderId,
			@RequestBody ExportReceipt exportReceipt) {
		productExportRecSrvc.saveExportRecDetail(orderId, exportReceipt);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(path = "/{productId}", method = RequestMethod.GET)
	public ResponseEntity<List<ExportReceipt>> getExportRecByProduct(@PathVariable(value = "productId") int productId) {
		List<ExportReceipt> list = productExportRecSrvc.listProductExportRec(productId);
		return new ResponseEntity<List<ExportReceipt>>(list, HttpStatus.OK);
	}
}
