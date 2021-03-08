package ecommerce.shopoo.service;

import ecommerce.shopoo.entity.Types;
import java.util.List;


public interface TypesService {
    Types getTypesById(long typesId);

    List<Types> getAllTypes();

    void addTypes(Types types);

    void updateTypes(Types types);

    void deleteTypes(long typesId);
}
