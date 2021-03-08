package ecommerce.shopoo.service;

import ecommerce.shopoo.entity.Images;
import java.util.List;

public interface ImagesService {

    Images getImagesById(long imagesId);

    List<Images> getAllImages();

    void addImages(Images images);

    void updateImages(Images images);

    void deleteImages(long imagesId);
}
