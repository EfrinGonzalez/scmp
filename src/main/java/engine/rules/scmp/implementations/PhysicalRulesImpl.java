package engine.rules.scmp.implementations;

import engine.rules.scmp.interfaces.IPhysicalRules;
import engine.rules.scmp.models.Order;

public class PhysicalRulesImpl implements IPhysicalRules {


    @Override
    public boolean packingSlipForShipping(Order order) {
        System.out.println("Packing slip for shipping has been created...");
        return true;
    }

    @Override
    public boolean giveCommissionPaymentToAgent() {
        System.out.println("Commission payment is sent to agent...");
        return true;
    }
}
