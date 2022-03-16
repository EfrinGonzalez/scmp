package engine.rules.scmp.implementations;

import engine.rules.scmp.interfaces.IBookRules;
import engine.rules.scmp.models.Order;

public class BookRulesImpl implements IBookRules {

    @Override
    public boolean duplicatePackingSlipForRoyalDepartment(Order order) {
        System.out.println("Inside the duplicate order for royal dept.");
        return true;
    }
}
