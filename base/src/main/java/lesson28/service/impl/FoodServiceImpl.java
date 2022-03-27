package lesson28.service.impl;

import lesson28.service.FoodService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "app.foodService.enabled", havingValue = "1", matchIfMissing = true)
public class FoodServiceImpl implements FoodService {

    @Override
    public void feed() {
        System.out.println("Здесь Вас накормят");
    }
}
