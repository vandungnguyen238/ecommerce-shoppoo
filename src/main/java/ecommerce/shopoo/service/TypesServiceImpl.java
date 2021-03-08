package ecommerce.shopoo.service;

import ecommerce.shopoo.entity.Types;
import ecommerce.shopoo.repository.TypesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypesServiceImpl implements TypesService{
    @Autowired
    private TypesRepository typesRepository;

    @Override
    public Types getTypesById(long typesId) {
        //return typesRepository.findById(typesId).get();
        Optional<Types> optional = typesRepository.findById(typesId);
        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public List<Types> getAllTypes() {
        return (List<Types>) typesRepository.findAll();
    }

    @Override
    public void addTypes(Types types) {
        typesRepository.save(types);
    }

    @Override
    public void updateTypes(Types types) {
        typesRepository.save(types);
    }

    @Override
    public void deleteTypes(long typesId) {
        typesRepository.deleteById(typesId);
    }
}
