package ecommerce.shopoo.service;

import ecommerce.shopoo.entity.Manufacture;
import java.util.List;


public interface ManufactureService {
    Manufacture getManufactureById(long manufactureId);

    List<Manufacture> getAllManufacture();

    void addManufacture(Manufacture manufacture);

    void updateManufacture(Manufacture manufacture);

    void deleteManufacture(long manufactureId);
}
