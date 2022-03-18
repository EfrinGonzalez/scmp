import engine.rules.scmp.Services.BookService;
import engine.rules.scmp.Services.MembershipService;
import engine.rules.scmp.Services.VideoService;
import engine.rules.scmp.implementations.*;
import engine.rules.scmp.interfaces.*;
import engine.rules.scmp.Services.PhysicalProductService;
import engine.rules.scmp.factory.PaymentFactory;
import engine.rules.scmp.enums.ProductType;
import engine.rules.scmp.models.*;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentFactoryTest {
    static Payment paymentPhysical;
    static Payment paymentBook;
    static Payment paymentMembershipActivation;
    static Payment paymentMembershipUpdate;
    static Payment paymentVideoLearningToSki;

    static IPhysicalRules physicalDistributor;
    static IBookRules bookDistributor;
    static IMembershipRules membershipDistributor;
    static IEmailRules notificator;
    static IVideoRules videoDistributor;


    @BeforeClass
    public static void init() {
        paymentPhysical = new Payment(1, ProductType.PHYSICAL_PRODUCT, new Order());
        paymentBook = new Payment(2, ProductType.BOOK, new Order());
        paymentMembershipActivation = new Payment(3, ProductType.MEMBERSHIP_ACTIVATION, new Order());
        paymentMembershipUpdate = new Payment(4, ProductType.MEMBERSHIP_UPGRADE, new Order());
        paymentVideoLearningToSki = new Payment(5, ProductType.VIDEO_LEARNING_TO_SKI, new Order());

        physicalDistributor = new PhysicalRulesImpl();
        bookDistributor = new BookRulesImpl();
        membershipDistributor = new MembershipRulesImpl();
        notificator = new EmailRulesImpl();
        videoDistributor = new VideoRulesImpl();

    }

    @Test
    public void testCreationOfPayment_PhysicalProduct() {
         Object paymentFactory = PaymentFactory.PaymentFactoryDistribution(paymentPhysical);
         boolean result = false;
         if (paymentFactory instanceof PhysicalRulesImpl) {
            PhysicalProductService service = new PhysicalProductService(physicalDistributor);
            result = service.executePhysicalRules(paymentPhysical);
             }
        assertTrue(result);
    }

    @Test
    public void testCreationOfPayment_Book() {
        Object paymentFactory = PaymentFactory.PaymentFactoryDistribution(paymentBook);
        boolean result = false;
        if (paymentFactory instanceof BookRulesImpl) {
            BookService service = new BookService(physicalDistributor, bookDistributor);
           result =  service.executeBookRules(paymentBook);
        }
        assertTrue(result);
    }

    @Test
    public void testPayment_MembershipActivation() {
        boolean result = false;
        Object paymentFactory = PaymentFactory.PaymentFactoryDistribution(paymentMembershipActivation);
        if (paymentFactory instanceof MembershipRulesImpl) {
            MembershipService service = new MembershipService(membershipDistributor, notificator);
           result =  service.executeCreationRules(paymentMembershipActivation);
        }
        assertTrue(result);
    }

    @Test
    public void testPayment_MembershipUpgrade() {
        boolean result = false;
        Object paymentFactory = PaymentFactory.PaymentFactoryDistribution(paymentMembershipActivation);
        if (paymentFactory instanceof MembershipRulesImpl) {
            MembershipService service = new MembershipService(membershipDistributor, notificator);
            result =  service.executeUpgradeRules(paymentMembershipActivation);
        }
        assertTrue(result);
    }

    @Test
    public void testPayment_VideoLearningToSki() {
         boolean result = false;
        Object paymentFactory = PaymentFactory.PaymentFactoryDistribution(paymentVideoLearningToSki);
        if (paymentFactory instanceof VideoRulesImpl) {
            VideoService service = new VideoService(videoDistributor);
            result = service.executeVideoRules(paymentVideoLearningToSki);
        }
        assertTrue(result);
    }
}
