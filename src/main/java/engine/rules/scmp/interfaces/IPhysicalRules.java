package engine.rules.scmp.interfaces;

import engine.rules.scmp.models.Order;
import engine.rules.scmp.models.Payment;

public interface IPhysicalRules {
    boolean packingSlipForShipping(Payment payment);
    boolean giveCommissionPaymentToAgent(Payment payment);
}
