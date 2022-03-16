package engine.rules.scmp.factory;

import engine.rules.scmp.implementations.MembershipDistributorImpl;
import engine.rules.scmp.implementations.BookDistributorImpl;
import engine.rules.scmp.implementations.PhysicalDistributorImpl;
import engine.rules.scmp.implementations.VideoDistributorImpl;
import engine.rules.scmp.interfaces.IBookDistributor;
import engine.rules.scmp.interfaces.IPhysicalDistributor;
import engine.rules.scmp.models.Payment;


public class PaymentFactory {

    private static IPhysicalDistributor physicalDistributor;
    private static IBookDistributor bookDistributor;

    public static Object PaymentFactoryDistribution(Payment payment){
        switch (payment.getType()) {
            case PHYSICAL_PRODUCT:
                System.out.println("---PHYSICAL_PRODUCT---");
                return new PhysicalDistributorImpl();

            case BOOK:
                System.out.println("---BOOK---");
                //return new BookProcessor(physicalDistributor,bookDistributor);
                return new BookDistributorImpl();

            case MEMBERSHIP_ACTIVATION:
            case MEMBERSHIP_UPGRADE:
                System.out.println("---MEMBERSHIP ACTIVATION/UPGRADE---");
                return new MembershipDistributorImpl();

            case VIDEO_LEARNING_TO_SKI:
                System.out.println("---VIDEO_LEARNING_TO_SKI---");
                return new VideoDistributorImpl();

            default:
                System.out.println("NO TYPE TO RETURN");
                return null;

        }
    }
}
