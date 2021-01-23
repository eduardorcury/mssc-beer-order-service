package guru.sfg.beer.order.service.services.testcomponents;

import guru.sfg.beer.order.service.config.JmsConfig;
import guru.sfg.beer.order.service.web.model.events.ValidateOrderRequest;
import guru.sfg.beer.order.service.web.model.events.ValidateOrderResult;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class BeerOrderValidationListener {

    private final JmsTemplate jmsTemplate;

    public BeerOrderValidationListener(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @JmsListener(destination = JmsConfig.VALIDATE_ORDER_QUEUE)
    public void listen(Message message) {

        ValidateOrderRequest request = (ValidateOrderRequest) message.getPayload();

        jmsTemplate.convertAndSend(JmsConfig.VALIDATE_ORDER_RESPONSE_QUEUE,
                new ValidateOrderResult(request.getBeerOrder().getId(), true));

    }

}
