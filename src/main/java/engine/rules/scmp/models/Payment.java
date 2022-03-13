package engine.rules.scmp.models;


public class Payment {
    private int paymentId;
    private Order order;

    public Payment(int paymentId, Order order) {
        this.paymentId = paymentId;
        this.order = order;
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
}
