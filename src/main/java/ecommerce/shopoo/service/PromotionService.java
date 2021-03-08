package ecommerce.shopoo.service;

import ecommerce.shopoo.entity.Promotion;
import java.util.List;


public interface PromotionService {
    Promotion getPromotionById(long promotionId);

    List<Promotion> getAllPromotion();

    void addPromotion(Promotion promotion);

    void updatePromotion(Promotion promotion);

    void deletePromotion(long promotionId);
    
    List<Promotion> getPromotionByKeyword(String keywords);
}
