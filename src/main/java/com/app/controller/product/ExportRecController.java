package com.app.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.model.ExportReceipt;
import com.app.service.product.ProductExportRecService;

@CrossOrigin
@RestController
@RequestMapping(path = "/export")
public class ExportRecController {

	@Autowired
	private ProductExportRecService productExportRecService;

	@PostMapping(path = "/{orderId}")
	public ResponseEntity<HttpStatus> saveExportRec(@PathVariable(value = "orderId") Long orderId,
			@RequestBody ExportReceipt exportReceipt) {
		productExportRecService.saveExportRecDetail(orderId, exportReceipt);
		return new ResponseEntity<>(HttpStatus.OK);
	}

//	@GetMapping(path = "/{productId}")
//	public ResponseEntity<List<ExportReceipt>> getExportRecByProduct(@PathVariable(value = "productId") int productId) {
//		return new ResponseEntity<>(productExportRecService.listProductExportRec(productId), HttpStatus.OK);
//	}
}
