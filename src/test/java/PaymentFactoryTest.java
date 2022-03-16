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

    private IPhysicalDistributor physicalDistributor;
    private IBookDistributor bookDistributor;

    @BeforeClass
    public static void init() {
        paymentPhysical = new Payment(1, ProductType.PHYSICAL_PRODUCT, new Order());
        paymentBook = new Payment(2, ProductType.BOOK, new Order());
        paymentMembershipActivation = new Payment(3, ProductType.MEMBERSHIP_ACTIVATION, new Order());
        paymentMembershipUpdate = new Payment(4, ProductType.MEMBERSHIP_ACTIVATION, new Order());
        paymentVideoLearningToSki = new Payment(5, ProductType.VIDEO_LEARNING_TO_SKI, new Order());



    }

    @Test
    public void testCreationOfPayment_PhysicalProduct() {
        IPhysicalDistributor physicalDistributor = new PhysicalDistributorImpl();
        Object paymentFactory = PaymentFactory.PaymentFactoryDistribution(paymentPhysical);
         boolean result = false;
       /* Object paymentFactory = PaymentFactory.PaymentFactoryDistribution(paymentPhysical);*/
        if (paymentFactory instanceof PhysicalDistributorImpl) {
            PhysicalProductService processor = new PhysicalProductService(physicalDistributor);
            result = processor.executeRules(paymentPhysical.getOrder());

             }
        assertTrue(result);

    }

    @Test
    public void testCreationOfPayment_Book() {
         IBookDistributor bookDistributor = new BookDistributorImpl();
        IPhysicalDistributor physicalDistributor = new PhysicalDistributorImpl();

        Object paymentFactory = PaymentFactory.PaymentFactoryDistribution(paymentBook);
        boolean result = false;
        if (paymentFactory instanceof BookDistributorImpl) {
            BookService processor = new BookService(physicalDistributor, bookDistributor);
           result =  processor.executeRules(new Order());
        }

        assertTrue(result);

    }


    @Test
    public void testPayment_MembershipActivation() {
        IMembershipDistributor membershipDistributor = new MembershipDistributorImpl();
        IEmailNotificator notificator = new EmailNotificatorImpl();
        boolean result = false;
        Object paymentFactory = PaymentFactory.PaymentFactoryDistribution(paymentMembershipActivation);
        if (paymentFactory instanceof MembershipDistributorImpl) {
            MembershipService processorService = new MembershipService(membershipDistributor, notificator);
           result =  processorService.executeCreationRules(paymentMembershipActivation.getOrder());

        }
        assertTrue(result);


    }


    @Test
    public void testPayment_MembershipUpgrade() {
        IMembershipDistributor membershipDistributor = new MembershipDistributorImpl();
        IEmailNotificator notificator = new EmailNotificatorImpl();
        boolean result = false;
        Object paymentFactory = PaymentFactory.PaymentFactoryDistribution(paymentMembershipActivation);
        if (paymentFactory instanceof MembershipDistributorImpl) {
            MembershipService processorService = new MembershipService(membershipDistributor, notificator);
            result =  processorService.executeUpgradeRules(paymentMembershipActivation.getOrder());

        }
        assertTrue(result);


    }


    @Test
    public void testPayment_VideoLearningToSki() {
        IVideoDistributor videoDistributor = new VideoDistributorImpl();
        boolean result = false;

        Object paymentFactory = PaymentFactory.PaymentFactoryDistribution(paymentVideoLearningToSki);
        if (paymentFactory instanceof VideoDistributorImpl) {
            VideoService service = new VideoService(videoDistributor);
            result = service.executeRules(paymentVideoLearningToSki.getOrder());
        }
        assertTrue(result);
    }

}
