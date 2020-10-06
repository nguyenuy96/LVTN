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
import com.app.dao.ImageDao;
import com.app.model.ProductionImage;

@Repository
public class ImageDaoImpl implements ImageDao {

	@Autowired
	private HibernateResult hibernate;

	@Override
	public ProductionImage saveImage(MultipartFile multipartFile, String uploadDirectory) {
		String imageName = multipartFile.getOriginalFilename();
		ProductionImage image = getImage(imageName);
		Path path = Paths.get(uploadDirectory, imageName);

		File imageFile = new File(uploadDirectory + "\\" + imageName);
		boolean isExistedImage = image.getImageId() != null ? true : false;
		if (!isExistedImage && !imageFile.exists()) {
			try {
				Files.copy(multipartFile.getInputStream(), path);
				image.setImageName(imageName);
				hibernate.getSession().saveOrUpdate(image);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			if (!isExistedImage) {
				hibernate.getSession().saveOrUpdate(image);
			}
			if (!imageFile.exists()){
				try {
					Files.copy(multipartFile.getInputStream(), path);
					image.setImageName(imageName);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		return image;
	}

	@Override
	public void deleteImage(ProductionImage productionImage) {
		File file = new File(productionImage.getImageName());
		if (file.exists()) {
			if (file.delete()) {
				hibernate.getSession().delete(productionImage);
			}
		}
	}

	public ProductionImage getImage(String imageName) {
		Query<ProductionImage> query = hibernate.inputStringQuery(ProductionImage.class, "imageName", imageName);
		ProductionImage productionImage = query.getResultList().size() != 0 ? query.getSingleResult() : new ProductionImage();
		return productionImage;
	}

}
