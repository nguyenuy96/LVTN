package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.model.ProductionImage;
import com.app.service.ProductImageService;

@CrossOrigin
@RestController
@RequestMapping(path = "/image")
public class ImageController {
	@Value("${upload.file.directory}")
	private String uploadDirectory;

	@Autowired
	private ProductImageService productImageSrvc;

	@RequestMapping(method = RequestMethod.POST, consumes = "multipart/form-data")
	public ResponseEntity<ProductionImage> addImage(@RequestParam(value = "file") MultipartFile file) {
		return new ResponseEntity<>(productImageSrvc.saveImage(file, uploadDirectory), HttpStatus.OK);
	}
}