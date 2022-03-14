package engine.rules.scmp.Distributors;

import engine.rules.scmp.interfaces.IBookDistributor;
import engine.rules.scmp.interfaces.IPhysicalDistributor;
import engine.rules.scmp.models.Order;

public class BookDistributor implements IPhysicalDistributor, IBookDistributor {

    @Override
    public boolean duplicatePackingSlipForRoyalDepartment(Order order) {
        return false;
    }

    @Override
    public boolean packingSlipForShipping(Order order) {
        return false;
    }

    @Override
    public boolean giveCommissionPaymentToAgent() {
        return false;
    }
}
