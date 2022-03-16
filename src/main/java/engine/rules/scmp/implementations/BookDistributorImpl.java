package engine.rules.scmp.implementations;

import engine.rules.scmp.interfaces.IBookDistributor;
import engine.rules.scmp.models.Order;

public class BookDistributorImpl implements IBookDistributor {

    @Override
    public boolean duplicatePackingSlipForRoyalDepartment(Order order) {
        System.out.println("Inside the duplicate order for royal dept.");
        return true;
    }
}
