package engine.rules.scmp.interfaces;

import engine.rules.scmp.models.Payment;

public interface IBookRules {
    boolean duplicatePackingSlipForRoyalDepartment(Payment payment);
}
