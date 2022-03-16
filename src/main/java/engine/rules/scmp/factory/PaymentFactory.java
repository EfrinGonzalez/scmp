package engine.rules.scmp.factory;

import engine.rules.scmp.implementations.MembershipRulesImpl;
import engine.rules.scmp.implementations.BookRulesImpl;
import engine.rules.scmp.implementations.PhysicalRulesImpl;
import engine.rules.scmp.implementations.VideoRulesImpl;
import engine.rules.scmp.interfaces.IBookRules;
import engine.rules.scmp.interfaces.IPhysicalRules;
import engine.rules.scmp.models.Payment;


public class PaymentFactory {

    private static IPhysicalRules physicalDistributor;
    private static IBookRules bookDistributor;

    public static Object PaymentFactoryDistribution(Payment payment){
        switch (payment.getType()) {
            case PHYSICAL_PRODUCT:
                System.out.println("---PHYSICAL_PRODUCT---");
                return new PhysicalRulesImpl();

            case BOOK:
                System.out.println("---BOOK---");
                //return new BookProcessor(physicalDistributor,bookDistributor);
                return new BookRulesImpl();

            case MEMBERSHIP_ACTIVATION:
            case MEMBERSHIP_UPGRADE:
                System.out.println("---MEMBERSHIP ACTIVATION/UPGRADE---");
                return new MembershipRulesImpl();

            case VIDEO_LEARNING_TO_SKI:
                System.out.println("---VIDEO_LEARNING_TO_SKI---");
                return new VideoRulesImpl();

            default:
                System.out.println("NO TYPE TO RETURN");
                return null;

        }
    }
}
