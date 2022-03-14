package engine.rules.scmp;

import engine.rules.scmp.Distributors.BookDistributor;
import engine.rules.scmp.Distributors.MembershipDistributor;
import engine.rules.scmp.Distributors.PhysicalDistributor;
import engine.rules.scmp.Distributors.VideoDistributor;
import engine.rules.scmp.models.Payment;

public class PaymentFactory {
    public static Object PaymentFactoryDistribution(Payment payment){
        switch (payment.getType()) {
            case PHYSICAL_PRODUCT:
                System.out.println("PHYSICAL_PRODUCT");
                return new PhysicalDistributor();

            case BOOK:
                System.out.println("BOOK");
                return new BookDistributor();

            case MEMBERSHIP_ACTIVATION:
            case MEMBERSHIP_UPGRADE:
                System.out.println("MEMBERSHIP");
                return new MembershipDistributor();

            case VIDEO_LEARNING_TO_SKI:
                System.out.println("VIDEO_LEARNING_TO_SKI");
                return new VideoDistributor();

            default:
                System.out.println("Bad luck...!");
                return null;

        }
    }
}
