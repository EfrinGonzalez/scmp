package engine.rules.scmp.implementations;

import engine.rules.scmp.interfaces.IMembershipRules;
import engine.rules.scmp.models.Order;

public class MembershipRulesImpl implements IMembershipRules {
    @Override
    public boolean activateMembership(Order order) {
        System.out.println("Membership activated.");

        return true;
    }

    @Override
    public boolean upgradeMembership(Order order) {
        System.out.println("Membership upgraded.");

        return true;
    }

}
