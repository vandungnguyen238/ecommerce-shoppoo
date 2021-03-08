package ecommerce.shopoo.service;

import ecommerce.shopoo.entity.Orders;
import ecommerce.shopoo.entity.Promotion;
import ecommerce.shopoo.repository.OrdersRepository;
import ecommerce.shopoo.repository.PromotionRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionServiceImpl implements PromotionService{
    @Autowired
    private PromotionRepository promotionRepository;
    
    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public Promotion getPromotionById(long promotionId) {
        //return promotionRepository.findById(promotionId).get();
        Optional<Promotion> optional = promotionRepository.findById(promotionId);
        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public List<Promotion> getAllPromotion() {
        return (List<Promotion>) promotionRepository.findAll();
    }

    @Override
    public void addPromotion(Promotion promotion) {
        promotionRepository.save(promotion);
    }

    @Override
    public void updatePromotion(Promotion promotion) {
        promotionRepository.save(promotion);
    }

    @Override
    public void deletePromotion(long promotionId) {
        promotionRepository.deleteById(promotionId);
    }
    
    @Override
    public List<Promotion> getPromotionByKeyword(String keywords) {
        return promotionRepository.findByKeyword(keywords);
    }
}
