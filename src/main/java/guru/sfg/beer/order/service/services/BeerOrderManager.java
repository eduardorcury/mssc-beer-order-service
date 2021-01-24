package guru.sfg.beer.order.service.services;

import guru.sfg.beer.order.service.domain.BeerOrder;
import guru.sfg.beer.order.service.web.model.BeerOrderDto;

import java.util.UUID;

public interface BeerOrderManager {

    BeerOrder newBeerOrder(BeerOrder beerOrder);

    void processValidationResult(UUID orderId, Boolean valid);

    void beerOrderAllocationPassed(BeerOrderDto beerOrder);

    void beerOrderAllocationPendingInventory(BeerOrderDto beerOrder);

    void beerOrderAllocationFailed(BeerOrderDto beerOrder);

    void beerOrderPickedUp(UUID id);
}
