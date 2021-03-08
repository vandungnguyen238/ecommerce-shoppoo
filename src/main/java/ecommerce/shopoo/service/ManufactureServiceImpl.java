package ecommerce.shopoo.service;

import ecommerce.shopoo.entity.Manufacture;
import ecommerce.shopoo.repository.ManufactureRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManufactureServiceImpl implements ManufactureService{
    @Autowired
    private ManufactureRepository manufactureRepository;

    @Override
    public Manufacture getManufactureById(long manufactureId) {
        //return manufactureRepository.findById(manufactureId).get();
        Optional<Manufacture> optional = manufactureRepository.findById(manufactureId);
        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public List<Manufacture> getAllManufacture() {
        return (List<Manufacture>) manufactureRepository.findAll();
    }

    @Override
    public void addManufacture(Manufacture manufacture) {
        manufactureRepository.save(manufacture);
    }

    @Override
    public void updateManufacture(Manufacture manufacture) {
        manufactureRepository.save(manufacture);
    }

    @Override
    public void deleteManufacture(long manufactureId) {
        manufactureRepository.deleteById(manufactureId);
    }
}
