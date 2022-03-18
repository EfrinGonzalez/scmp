package engine.rules.scmp.Services;

import engine.rules.scmp.interfaces.IEmailRules;
import engine.rules.scmp.interfaces.IMembershipRules;
import engine.rules.scmp.models.Payment;

public class MembershipService {

    private static IMembershipRules membershipDistributor;
    private static IEmailRules notificator;

    public MembershipService(IMembershipRules membershipDistributor, IEmailRules notificator) {
       this.membershipDistributor = membershipDistributor;
       this.notificator = notificator;
    }
       public boolean executeCreationRules(Payment payment) {
        System.out.println("Executing rules for Activation of Membership");
        this.membershipDistributor.activateMembership(payment);
        this.notificator.notifyOwnerViaEmail("Membership activation", "You are notified that your membership is active from now on.");

        return true;
    }

    public boolean executeUpgradeRules(Payment payment) {
        System.out.println("Executing rules for Upgrading of Membership");
        this.membershipDistributor.upgradeMembership(payment);
        this.notificator.notifyOwnerViaEmail("Membership upgrade", "You are notified that your upgraded is active from now on.");

        return true;
    }

}
