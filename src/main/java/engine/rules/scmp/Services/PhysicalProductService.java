package engine.rules.scmp.Services;


import engine.rules.scmp.interfaces.IPhysicalRules;
import engine.rules.scmp.models.Order;

public class PhysicalProductService {

    private static IPhysicalRules physicalRules;

    public PhysicalProductService(IPhysicalRules physicalRules) {
        this.physicalRules = physicalRules;
    }

    public boolean executeRules(Order order) {
        System.out.println("Executing rules for physical");
        this.physicalRules.packingSlipForShipping(order);
        this.physicalRules.giveCommissionPaymentToAgent();

        return true;
    }

}
