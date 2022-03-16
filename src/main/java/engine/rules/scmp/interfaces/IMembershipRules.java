package engine.rules.scmp.interfaces;

import engine.rules.scmp.models.Order;

public interface IMembershipRules {
    boolean activateMembership(Order order);
    boolean upgradeMembership(Order order);
}
