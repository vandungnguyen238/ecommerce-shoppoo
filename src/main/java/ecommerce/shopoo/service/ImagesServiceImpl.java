package ecommerce.shopoo.service;

import ecommerce.shopoo.entity.Images;
import ecommerce.shopoo.repository.ImagesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagesServiceImpl implements ImagesService{
    @Autowired
    private ImagesRepository imagesRepository;

    @Override
    public Images getImagesById(long imagesId) {
        //return imagesRepository.findById(imagesId).get();
        Optional<Images> optional = imagesRepository.findById(imagesId);
        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public List<Images> getAllImages() {
        return (List<Images>) imagesRepository.findAll();
    }

    @Override
    public void addImages(Images images) {
        imagesRepository.save(images);
    }

    @Override
    public void updateImages(Images images) {
        imagesRepository.save(images);
    }

    @Override
    public void deleteImages(long imagesId) {
        imagesRepository.deleteById(imagesId);
    }
}
