package engine.rules.scmp.Services;


import engine.rules.scmp.interfaces.IPhysicalRules;
import engine.rules.scmp.models.Order;

public class PhysicalProductService {

    private static IPhysicalRules physicalDistributor;

    public static IPhysicalRules getPhysicalDistributor() {
        return physicalDistributor;
    }

    public static void setPhysicalDistributor(IPhysicalRules physicalDistributor) {
        PhysicalProductService.physicalDistributor = physicalDistributor;
    }

    public PhysicalProductService() {
    }

    public PhysicalProductService(IPhysicalRules physicalDistributor) {
        this.physicalDistributor = physicalDistributor;

    }


    public boolean executeRules(Order order) {
        System.out.println("Executing rules for physical");
        boolean result =  this.physicalDistributor.packingSlipForShipping(order);
        boolean result2 =  this.physicalDistributor.giveCommissionPaymentToAgent();
        System.out.println("Result for packing: "+ result);
        System.out.println("Result for comission: "+ result2);
        if(result==true && result2==true) return true;
        else return false;
    }

}
