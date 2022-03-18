package engine.rules.scmp.implementations;

import engine.rules.scmp.interfaces.IMembershipRules;
import engine.rules.scmp.models.Payment;

public class MembershipRulesImpl implements IMembershipRules {
    @Override
    public boolean activateMembership(Payment payment) {
        System.out.println("Membership activated.");
        return true;
    }

    @Override
    public boolean upgradeMembership(Payment payment) {
        System.out.println("Membership upgraded.");
        return true;
    }

}
