package engine.rules.scmp.interfaces;

import engine.rules.scmp.models.Order;

public interface IPhysicalRules {
    boolean packingSlipForShipping(Order order);
    boolean giveCommissionPaymentToAgent();
}
