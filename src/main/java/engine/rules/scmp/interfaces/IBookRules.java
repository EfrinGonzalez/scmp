package engine.rules.scmp.interfaces;

import engine.rules.scmp.models.Order;

public interface IBookRules {
    boolean duplicatePackingSlipForRoyalDepartment(Order order);
}
