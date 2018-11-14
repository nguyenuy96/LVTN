package com.app.dao.impl.product;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.hibernate.query.Query;
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
		String imageName = multipartFile.getOriginalFilename();
		ProductImage image = getImage(imageName);
		Path path = Paths.get(uploadDirectory, imageName);
		boolean isExistedImage = image.getImageId() != null ? true : false;
		if (!isExistedImage) {
			try {
				image.setImageName(imageName);
				Files.copy(multipartFile.getInputStream(), path);
				hibernate.getSession().saveOrUpdate(image);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return image;
	}

	@Override
	public void deleteImage(ProductImage productImage) {
		File file = new File(productImage.getImageName());
		if (file.exists()) {
			if (file.delete()) {
				hibernate.getSession().delete(productImage);
			}
		}
	}

	public ProductImage getImage(String imageName) {
		Query<ProductImage> query = hibernate.inputStringQuery(ProductImage.class, "imageName", imageName);
		ProductImage productImage = query.getResultList().size() != 0 ? query.getSingleResult() : new ProductImage();
		return productImage;
	}

}
