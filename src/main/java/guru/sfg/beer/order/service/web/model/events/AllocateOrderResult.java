package guru.sfg.beer.order.service.web.model.events;

import guru.sfg.beer.order.service.web.model.BeerOrderDto;

import java.util.Objects;

public class AllocateOrderResult {

    private BeerOrderDto beerOrderDto;
    private Boolean allocationError = false;
    private Boolean pendingInventory = false;

    public AllocateOrderResult() {

    }

    public AllocateOrderResult(BeerOrderDto beerOrderDto, Boolean allocationError, Boolean pendingInventory) {
        this.beerOrderDto = beerOrderDto;
        this.allocationError = allocationError;
        this.pendingInventory = pendingInventory;
    }

    public BeerOrderDto getBeerOrderDto() {
        return beerOrderDto;
    }

    public void setBeerOrderDto(BeerOrderDto beerOrderDto) {
        this.beerOrderDto = beerOrderDto;
    }

    public Boolean getAllocationError() {
        return allocationError;
    }

    public void setAllocationError(Boolean allocationError) {
        this.allocationError = allocationError;
    }

    public Boolean getPendingInventory() {
        return pendingInventory;
    }

    public void setPendingInventory(Boolean pendingInventory) {
        this.pendingInventory = pendingInventory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllocateOrderResult that = (AllocateOrderResult) o;
        return Objects.equals(beerOrderDto, that.beerOrderDto) &&
                Objects.equals(allocationError, that.allocationError) &&
                Objects.equals(pendingInventory, that.pendingInventory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beerOrderDto, allocationError, pendingInventory);
    }

    @Override
    public String toString() {
        return "AllocateOrderResult{" +
                "beerOrderDto=" + beerOrderDto +
                ", allocationError=" + allocationError +
                ", pendingInventory=" + pendingInventory +
                '}';
    }
}
