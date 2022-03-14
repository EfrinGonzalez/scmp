package engine.rules.scmp.models;


import engine.rules.scmp.enums.ProductType;

public class Payment {
    private int paymentId;
    private ProductType type;
    private Order order;

    public Payment(int paymentId, ProductType type, Order order) {
        this.paymentId = paymentId;
        this.type = type;
        this.order = order;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", order=" + order.toString() +
                '}';
    }
}
