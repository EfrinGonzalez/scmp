package engine.rules.scmp.implementations;

import engine.rules.scmp.interfaces.IPhysicalDistributor;
import engine.rules.scmp.models.Order;

public class PhysicalDistributorImpl implements IPhysicalDistributor {


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
