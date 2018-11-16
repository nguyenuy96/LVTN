package com.app.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.exception.ExceptionHandle;
import com.app.model.Country;
import com.app.model.ListObject;
import com.app.model.Product;
import com.app.model.ProductExportReceipt;
import com.app.model.ProductImage;
import com.app.model.ProductStorageReceipt;
import com.app.model.ProductType;
import com.app.model.Promotion;
import com.app.model.TradeMark;
import com.app.model.Warehouse;
import com.app.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping(path = "/product")
public class ProductController {

	@Value("${upload.file.directory}")
	private String uploadDirectory;

	@Autowired
	private ProductService productService;

	@RequestMapping(path = "/save/country", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> addCountry(@RequestBody Country country) {
		productService.saveOrUpdateCounrty(country);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(path = "/save/trademark", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> addTradeMark(@RequestBody TradeMark tradeMark) throws ExceptionHandle {
		productService.saveOrUpdateTradeMark(tradeMark);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(path = "/save/image", method = RequestMethod.POST, consumes = "multipart/form-data")
	public ResponseEntity<ProductImage> addImage(@RequestParam(value = "multipartFile") MultipartFile multipartFile) {
		ProductImage image = productService.saveImage(multipartFile, uploadDirectory);
		return new ResponseEntity<ProductImage>(image, HttpStatus.OK);
	}

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> addProduct(@RequestBody Product product) {
		productService.saveProduct(product);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(path = "/modify", method = RequestMethod.PATCH)
	public ResponseEntity<HttpStatus> modifyProduct(@RequestBody Object object) {
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(path = "/save/product-type", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> addProductType(@RequestBody ProductType productType) {
		productService.saveProductType(productType);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(path = "/save/promotion", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> addPromotion(@RequestBody Promotion promotion) {
		productService.savePromotion(promotion);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(path = "/save/warehouse", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> addWarehouse(@RequestBody Warehouse warehouse) {
		productService.saveWarehouse(warehouse);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(path = "/save/storage-receipt", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> saveProductStorage(@RequestBody ProductStorageReceipt productStorage) {
		productService.saveProductStorage(productStorage);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(path = "/list/storage-receipt", method = RequestMethod.GET)
	public ResponseEntity<List<ProductStorageReceipt>> getProductImport() {
		return new ResponseEntity<List<ProductStorageReceipt>>(productService.getStorageReceipt(), HttpStatus.OK);
	}

	@RequestMapping(path = "/list/product", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> listItem = productService.getAllProducts();
		return new ResponseEntity<List<Product>>(listItem, HttpStatus.OK);
	}

	@RequestMapping(path = "/listobject", method = RequestMethod.GET)
	public ResponseEntity<ListObject> getListObject() {
		return new ResponseEntity<ListObject>(productService.listObject(), HttpStatus.OK);
	}

	@RequestMapping(path = "/save/export-receipt", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> addProductExport(@RequestBody ProductExportReceipt productExportReceipt) {
		productService.saveProdcutExport(productExportReceipt);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(path = "/list/export-receipt", method = RequestMethod.GET)
	public ResponseEntity<List<ProductExportReceipt>> getListProductExportReceipt() {
		return new ResponseEntity<List<ProductExportReceipt>>(productService.getProductExportReceipt(), HttpStatus.OK);
	}

}
