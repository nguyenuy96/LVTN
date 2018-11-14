package com.app.service.product;

import org.springframework.web.multipart.MultipartFile;

import com.app.model.ProductImage;

public interface ProductImageService {
	ProductImage saveImage(MultipartFile multipartFile, String uploadDirectory);
}
