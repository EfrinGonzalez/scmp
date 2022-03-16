package engine.rules.scmp.Services;

import engine.rules.scmp.interfaces.IEmailRules;
import engine.rules.scmp.interfaces.IMembershipRules;
import engine.rules.scmp.models.Order;

public class MembershipService {

    private static IMembershipRules membershipDistributor;
    private static IEmailRules notificator;

    public MembershipService(IMembershipRules membershipDistributor, IEmailRules notificator) {
       this.membershipDistributor = membershipDistributor;
       this.notificator = notificator;
    }

    public static IMembershipRules getMembershipDistributor() {
        return membershipDistributor;
    }

    public static void setMembershipDistributor(IMembershipRules membershipDistributor) {
        MembershipService.membershipDistributor = membershipDistributor;
    }

    public static IEmailRules getNotificator() {
        return notificator;
    }

    public static void setNotificator(IEmailRules notificator) {
        MembershipService.notificator = notificator;
    }

    public boolean executeCreationRules(Order order) {
        // this.physicalDistributor.giveCommissionPaymentToAgent();
        System.out.println("Executing rules for Activation of Membership");
        this.membershipDistributor.activateMembership(new Order());
        this.notificator.notifyOwnerViaEmail("Membership activation", "You are notified that your membership is active from now on.");

        //System.out.println("Resutl"+ result);;
        return true;
    }

    public boolean executeUpgradeRules(Order order) {
        // this.physicalDistributor.giveCommissionPaymentToAgent();
        System.out.println("Executing rules for Upgrading of Membership");
        this.membershipDistributor.upgradeMembership(new Order());
        this.notificator.notifyOwnerViaEmail("Membership upgrade", "You are notified that your upgraded is active from now on.");

        //System.out.println("Resutl"+ result);;
        return true;
    }

}
