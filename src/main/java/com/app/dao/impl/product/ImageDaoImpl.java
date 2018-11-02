package com.app.dao.impl.product;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.impl.HibernateResult;
import com.app.dao.product.ImageDao;
import com.app.model.ProductImage;

@Repository
public class ImageDaoImpl implements ImageDao {

	@Autowired
	private HibernateResult hibernate;

	@Override
	public ProductImage saveImage(MultipartFile multipartFile, String uploadDirectory) {
		ProductImage image = new ProductImage();
		try {
			String imageName = multipartFile.getOriginalFilename();
			Path path = Paths.get(uploadDirectory, imageName);
			Files.copy(multipartFile.getInputStream(), path);
			image.setImageName(imageName);
			hibernate.getSession().saveOrUpdate(image);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return image;
	}

}
