package com.app.dao.product;

import org.springframework.web.multipart.MultipartFile;

import com.app.model.ProductImage;

public interface ImageDao {
	ProductImage saveImage(MultipartFile multipartFile, String uploadDirectory);
}
