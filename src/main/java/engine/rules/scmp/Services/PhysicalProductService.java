package engine.rules.scmp.Services;


import engine.rules.scmp.interfaces.IPhysicalRules;
import engine.rules.scmp.models.Payment;

public class PhysicalProductService {

    private static IPhysicalRules physicalRules;

    public PhysicalProductService(IPhysicalRules physicalRules) {
        this.physicalRules = physicalRules;
    }

    public boolean executePhysicalRules(Payment payment) {
        System.out.println("Executing rules for physical");
        this.physicalRules.packingSlipForShipping(payment);
        this.physicalRules.giveCommissionPaymentToAgent(payment);

        return true;
    }

}
