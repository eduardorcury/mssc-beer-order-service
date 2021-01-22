package guru.sfg.beer.order.service.web.model.events;

import guru.sfg.beer.order.service.web.model.BeerOrderDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

public class ValidateOrderRequest {

    private BeerOrderDto beerOrder;

    public ValidateOrderRequest() {

    }

    public ValidateOrderRequest(BeerOrderDto beerOrder) {
        this.beerOrder = beerOrder;
    }

    public BeerOrderDto getBeerOrder() {
        return beerOrder;
    }

    public void setBeerOrder(BeerOrderDto beerOrder) {
        this.beerOrder = beerOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValidateOrderRequest that = (ValidateOrderRequest) o;
        return Objects.equals(beerOrder, that.beerOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beerOrder);
    }

    @Override
    public String toString() {
        return "ValidateOrderRequest{" +
                "beerOrder=" + beerOrder +
                '}';
    }
}
