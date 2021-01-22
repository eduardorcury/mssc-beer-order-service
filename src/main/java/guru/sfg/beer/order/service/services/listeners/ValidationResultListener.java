package guru.sfg.beer.order.service.services.listeners;

import guru.sfg.beer.order.service.config.JmsConfig;
import guru.sfg.beer.order.service.services.BeerOrderManager;
import guru.sfg.beer.order.service.web.model.events.ValidateOrderResult;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ValidationResultListener {

    private final BeerOrderManager beerOrderManager;

    public ValidationResultListener(BeerOrderManager beerOrderManager) {
        this.beerOrderManager = beerOrderManager;
    }

    @JmsListener(destination = JmsConfig.VALIDATE_ORDER_RESPONSE_QUEUE)
    public void listen(ValidateOrderResult validateOrderResult) {

        final UUID orderId = validateOrderResult.getOrderId();
        beerOrderManager.processValidationResult(orderId, validateOrderResult.getValid());

    }

}
