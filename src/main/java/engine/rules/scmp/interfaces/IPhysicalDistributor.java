package engine.rules.scmp.interfaces;

import engine.rules.scmp.models.Order;

public interface IPhysicalDistributor {
    boolean packingSlipForShipping(Order order);
    boolean giveCommissionPaymentToAgent();
}
