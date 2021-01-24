package guru.sfg.beer.order.service.web.model.events;

import java.util.Objects;
import java.util.UUID;

public class AllocationFailureEvent {

    private UUID orderId;

    public AllocationFailureEvent() {

    }

    public AllocationFailureEvent(UUID orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllocationFailureEvent that = (AllocationFailureEvent) o;
        return Objects.equals(orderId, that.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "AllocationFailureEvent{" +
                "orderId=" + orderId +
                '}';
    }
}
