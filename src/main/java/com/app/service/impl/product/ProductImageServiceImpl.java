package com.app.service.impl.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.product.ImageDao;
import com.app.model.ProductImage;
import com.app.service.product.ProductImageService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductImageServiceImpl implements ProductImageService {

	@Autowired
	private ImageDao imageDao;

	@Transactional
	@Override
	public ProductImage saveImage(MultipartFile multipartFile, String uploadDirectory) {
		ProductImage image = imageDao.saveImage(multipartFile, uploadDirectory);
		return image; 
	}

}
