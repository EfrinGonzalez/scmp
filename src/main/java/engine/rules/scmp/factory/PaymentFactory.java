package engine.rules.scmp.factory;

import engine.rules.scmp.implementations.MembershipRulesImpl;
import engine.rules.scmp.implementations.BookRulesImpl;
import engine.rules.scmp.implementations.PhysicalRulesImpl;
import engine.rules.scmp.implementations.VideoRulesImpl;
import engine.rules.scmp.models.Payment;


public class PaymentFactory {

    public static Object create(Payment payment){
        switch (payment.getType()) {

            case PHYSICAL_PRODUCT:
                System.out.println("---CREATION OF PHYSICAL_PRODUCT PAYMENT TYPE---");
                return new PhysicalRulesImpl();

            case BOOK:
                System.out.println("---CREATION OF BOOK PAYMENT TYPE---");
                return new BookRulesImpl();

            case MEMBERSHIP_ACTIVATION:
            case MEMBERSHIP_UPGRADE:
                System.out.println("---CREATION OF MEMBERSHIP ACTIVATION/UPGRADE PAYMENT TYPE---");
                return new MembershipRulesImpl();

            case VIDEO_LEARNING_TO_SKI:
                System.out.println("---CREATION OF VIDEO_LEARNING_TO_SKI PAYMENT TYPE---");
                return new VideoRulesImpl();

            default:
                System.out.println("TYPE CREATED. NOTHING TO RETURN!");
                return null;

        }
    }
}
