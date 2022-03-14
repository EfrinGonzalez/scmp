package engine.rules.scmp.interfaces;

import engine.rules.scmp.models.Order;

public interface IMembershipDistributor {
    boolean activateMembership(Order order);
    boolean upgradeMembership(Order order);
}
