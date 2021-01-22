package guru.sfg.beer.order.service.web.model.events;

import guru.sfg.beer.order.service.web.model.BeerOrderDto;

import java.util.Objects;

public class AllocateOrderRequest {

    private BeerOrderDto beerOrderDto;

    public AllocateOrderRequest() {

    }

    public AllocateOrderRequest(BeerOrderDto beerOrderDto) {
        this.beerOrderDto = beerOrderDto;
    }

    public BeerOrderDto getBeerOrderDto() {
        return beerOrderDto;
    }

    public void setBeerOrderDto(BeerOrderDto beerOrderDto) {
        this.beerOrderDto = beerOrderDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllocateOrderRequest that = (AllocateOrderRequest) o;
        return Objects.equals(beerOrderDto, that.beerOrderDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beerOrderDto);
    }

    @Override
    public String toString() {
        return "AllocateOrderRequest{" +
                "beerOrderDto=" + beerOrderDto +
                '}';
    }
}
