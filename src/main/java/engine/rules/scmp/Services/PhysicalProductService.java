package engine.rules.scmp.Services;


import engine.rules.scmp.interfaces.IPhysicalDistributor;
import engine.rules.scmp.models.Order;

public class PhysicalProductService {

    private static IPhysicalDistributor physicalDistributor;

    public static IPhysicalDistributor getPhysicalDistributor() {
        return physicalDistributor;
    }

    public static void setPhysicalDistributor(IPhysicalDistributor physicalDistributor) {
        PhysicalProductService.physicalDistributor = physicalDistributor;
    }

    public PhysicalProductService() {
    }

    public PhysicalProductService(IPhysicalDistributor physicalDistributor) {
        this.physicalDistributor = physicalDistributor;

    }


    public boolean executeRules(Order order) {
        System.out.println("Executing rules for physical");
        boolean result =  this.physicalDistributor.packingSlipForShipping(new Order());
        boolean result2 =  this.physicalDistributor.giveCommissionPaymentToAgent();
        System.out.println("Resutl"+ result);;
        return true;
    }

}
