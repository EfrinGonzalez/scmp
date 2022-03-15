package engine.rules.scmp.Distributors;

import engine.rules.scmp.interfaces.IEmailNotificator;
import engine.rules.scmp.interfaces.IMembershipDistributor;
import engine.rules.scmp.models.Order;

public class MembershipDistributor implements IMembershipDistributor, IEmailNotificator {
    @Override
    public boolean activateMembership(Order order) {
        return true;
    }

    @Override
    public boolean upgradeMembership(Order order) {
        return true;
    }

    @Override
    public boolean notifyOwnerViaEmail(String notificationTitle, String NotificationDescription) {
        System.out.println(notificationTitle + ":" +NotificationDescription);
        return true;
    }
}
