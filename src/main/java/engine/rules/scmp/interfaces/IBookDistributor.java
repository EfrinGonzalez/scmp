package engine.rules.scmp.interfaces;

import engine.rules.scmp.models.Order;

public interface IBookDistributor {
    boolean duplicatePackingSlipForRoyalDepartment(Order order);
}
