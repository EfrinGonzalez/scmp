package engine.rules.scmp.implementations;

import engine.rules.scmp.interfaces.IEmailNotificator;
import engine.rules.scmp.interfaces.IMembershipDistributor;
import engine.rules.scmp.models.Order;

public class MembershipDistributorImpl implements IMembershipDistributor{
    @Override
    public boolean activateMembership(Order order) {
        return true;
    }

    @Override
    public boolean upgradeMembership(Order order) {
        return true;
    }

}
