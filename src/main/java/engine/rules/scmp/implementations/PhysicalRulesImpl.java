package engine.rules.scmp.implementations;

import engine.rules.scmp.interfaces.IPhysicalRules;
import engine.rules.scmp.models.Payment;

public class PhysicalRulesImpl implements IPhysicalRules {


    @Override
    public boolean packingSlipForShipping(Payment payment) {
        /*Note:
         *  Packing slip contains all what the payment contains.
        */
        System.out.println("Packing slip for shipping has been created...");
        return true;
    }

    @Override
    public boolean giveCommissionPaymentToAgent(Payment payment) {
        /*Note: Probably calculate % commission
           based on the sum of prices contained in the order.
        */
        System.out.println("Commission payment is sent to agent...");
        return true;
    }
}
