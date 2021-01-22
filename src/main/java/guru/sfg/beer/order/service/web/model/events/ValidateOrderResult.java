package guru.sfg.beer.order.service.web.model.events;

import java.util.Objects;
import java.util.UUID;

public class ValidateOrderResult {

    private UUID orderId;
    private Boolean isValid;

    public ValidateOrderResult() {

    }

    public ValidateOrderResult(UUID orderId, Boolean isValid) {
        this.orderId = orderId;
        this.isValid = isValid;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValidateOrderResult that = (ValidateOrderResult) o;
        return Objects.equals(orderId, that.orderId) &&
                Objects.equals(isValid, that.isValid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, isValid);
    }

    @Override
    public String toString() {
        return "ValidateOrderResult{" +
                "orderId=" + orderId +
                ", isValid=" + isValid +
                '}';
    }
}
