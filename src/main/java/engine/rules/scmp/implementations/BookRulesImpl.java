package engine.rules.scmp.implementations;

import engine.rules.scmp.interfaces.IBookRules;
import engine.rules.scmp.models.Payment;

public class BookRulesImpl implements IBookRules {

    @Override
    public boolean duplicatePackingSlipForRoyalDepartment(Payment payment) {
        /*Note:
        *  Packing slip contains all what the payment contains.
        *  The duplication of packing slip is a copy of the original Packing slip
        *   with the payment information.*/
        System.out.println("Duplication of packing slip with payment for royal dept.");
        return true;
    }
}
