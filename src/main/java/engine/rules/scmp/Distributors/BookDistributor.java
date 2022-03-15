package engine.rules.scmp.Distributors;

import engine.rules.scmp.interfaces.IBookDistributor;
import engine.rules.scmp.interfaces.IPhysicalDistributor;
import engine.rules.scmp.models.Order;

public class BookDistributor implements IPhysicalDistributor, IBookDistributor {

    @Override
    public boolean duplicatePackingSlipForRoyalDepartment(Order order) {
        System.out.println("Duplicate Packing slip for royalty..");
        return true;
    }

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
