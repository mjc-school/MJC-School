package demo.service;

import demo.model.Discount;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Random;

@Service
@RefreshScope
public class DiscountService {

    private final Random random = new SecureRandom();

    public Discount getDiscount() {
        return new Discount().setAmount(random.nextInt(50));
    }
}
