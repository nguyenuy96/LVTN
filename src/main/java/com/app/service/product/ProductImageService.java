package com.app.service.product;


import org.springframework.web.multipart.MultipartFile;

import com.app.model.ProductionImage;

public interface ProductImageService {
	ProductionImage saveImage(MultipartFile multipartFile, String uploadDirectory);
	
}
