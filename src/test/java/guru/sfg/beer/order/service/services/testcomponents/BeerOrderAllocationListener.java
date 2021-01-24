package guru.sfg.beer.order.service.services.testcomponents;

import guru.sfg.beer.order.service.config.JmsConfig;
import guru.sfg.beer.order.service.web.model.events.AllocateOrderRequest;
import guru.sfg.beer.order.service.web.model.events.AllocateOrderResult;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class BeerOrderAllocationListener {

    private final JmsTemplate jmsTemplate;

    public BeerOrderAllocationListener(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @JmsListener(destination = JmsConfig.ALLOCATE_ORDER_QUEUE)
    public void listen(Message message) {

        boolean pendingInventory = false;
        boolean allocationError = false;

        AllocateOrderRequest request = (AllocateOrderRequest) message.getPayload();

        if (request.getBeerOrderDto().getCustomerRef() != null &
                request.getBeerOrderDto().getCustomerRef().equals("partial-allocation")) {
            pendingInventory = true;
        }

        if (request.getBeerOrderDto().getCustomerRef() != null &
                request.getBeerOrderDto().getCustomerRef().equals("fail-allocation")) {
            allocationError = true;
        }

        boolean finalPendingInventory = pendingInventory;
        request.getBeerOrderDto().getBeerOrderLines().forEach(beerOrderLineDto -> {
            if (finalPendingInventory) {
                beerOrderLineDto.setQuantityAllocated(beerOrderLineDto.getOrderQuantity() - 1);
            } else {
                beerOrderLineDto.setQuantityAllocated(beerOrderLineDto.getOrderQuantity());
            }
            beerOrderLineDto.setQuantityAllocated(beerOrderLineDto.getOrderQuantity());
        });

        jmsTemplate.convertAndSend(JmsConfig.ALLOCATE_ORDER_RESPONSE_QUEUE,
                new AllocateOrderResult(request.getBeerOrderDto(), allocationError, pendingInventory));

    }

}
