package com.app.service.impl.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.ImageDao;
import com.app.model.ProductionImage;
import com.app.service.product.ProductImageService;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class ProductImageServiceImpl implements ProductImageService {

	@Autowired
	private ImageDao imageDao;

	@Override
	public ProductionImage saveImage(MultipartFile multipartFile, String uploadDirectory) {
		String imageName = multipartFile.getOriginalFilename();
		Optional<ProductionImage> productionImage = imageDao.findByImageName(imageName);
		Path path = Paths.get(uploadDirectory, imageName);

		File imageFile = new File(uploadDirectory + "\\" + imageName);
		boolean isExistedImage = productionImage.isPresent();
		ProductionImage image = isExistedImage ? productionImage.get() : new ProductionImage();
		if (!isExistedImage && !imageFile.exists()) {
			try {
				Files.copy(multipartFile.getInputStream(), path);
				image.setImageName(imageName);
				imageDao.save(image);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			if (!imageFile.exists()){
				try {
					Files.copy(multipartFile.getInputStream(), path);
					image.setImageName(imageName);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			imageDao.save(image);
		}
		return image; 
	}
}
