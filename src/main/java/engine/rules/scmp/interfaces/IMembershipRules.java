package engine.rules.scmp.interfaces;

import engine.rules.scmp.models.Payment;

public interface IMembershipRules {
    boolean activateMembership(Payment payment);
    boolean upgradeMembership(Payment payment);
}
