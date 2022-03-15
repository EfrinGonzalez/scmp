import com.sun.org.apache.xpath.internal.operations.Or;
import engine.rules.scmp.Distributors.BookDistributor;
import engine.rules.scmp.Distributors.MembershipDistributor;
import engine.rules.scmp.Distributors.PhysicalDistributor;
import engine.rules.scmp.Distributors.VideoDistributor;
import engine.rules.scmp.factory.PaymentFactory;
import engine.rules.scmp.enums.ProductType;
import engine.rules.scmp.enums.RuleAction;
import engine.rules.scmp.models.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PaymentFactoryTest {
    static Payment paymentPhysical;
    static Payment paymentBook;
    static Payment paymentMembershipActivation;
    static Payment paymentMembershipUpdate;
    static Payment paymentVideoLearningToSki;
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
        boolean packingSentForShipping = false;
        boolean commisionPaid = false;
        Object paymentFactory = PaymentFactory.PaymentFactoryDistribution(paymentPhysical);
        if (paymentFactory instanceof PhysicalDistributor) {
            packingSentForShipping = ((PhysicalDistributor) paymentFactory).packingSlipForShipping(paymentPhysical.getOrder());
            commisionPaid = ((PhysicalDistributor) paymentFactory).giveCommissionPaymentToAgent();
        }
        assertEquals(true, packingSentForShipping);
        assertEquals(true, commisionPaid);

    }


    @Test
    public void testCreationOfPayment_Book() {
        boolean packingSentForShipping = false;
        boolean duplicatePackingforRoyalty = false;
        boolean commisionPaid = false;
        Object paymentFactory = PaymentFactory.PaymentFactoryDistribution(paymentBook);
        if (paymentFactory instanceof BookDistributor) {
            packingSentForShipping = ((BookDistributor) paymentFactory).packingSlipForShipping(paymentBook.getOrder());
            duplicatePackingforRoyalty = ((BookDistributor) paymentFactory).duplicatePackingSlipForRoyalDepartment(paymentBook.getOrder());
            commisionPaid = ((BookDistributor) paymentFactory).giveCommissionPaymentToAgent();
        }
        assertEquals(true, packingSentForShipping);
        assertEquals(true, duplicatePackingforRoyalty);
        assertEquals(true, commisionPaid);

    }

    @Test
    public void testPayment_MembershipActivation() {
        boolean activationApplied = false;
        boolean notificationEmailSent = false;

        Object paymentFactory = PaymentFactory.PaymentFactoryDistribution(paymentMembershipActivation);
        if (paymentFactory instanceof MembershipDistributor) {
            activationApplied = ((MembershipDistributor) paymentFactory).activateMembership(paymentMembershipActivation.getOrder());
            notificationEmailSent = ((MembershipDistributor) paymentFactory).notifyOwnerViaEmail("Membership Activation", "Your membership is active from now on...");
             }
        assertEquals(true, activationApplied);
        assertEquals(true, notificationEmailSent);


    }

    @Test
    public void testPayment_MembershipUpgrade() {
        boolean isUpgradeApplied = false;
        boolean isNotificationEmailSent = false;

        Object paymentFactory = PaymentFactory.PaymentFactoryDistribution(paymentMembershipActivation);
        if (paymentFactory instanceof MembershipDistributor) {
            isUpgradeApplied = ((MembershipDistributor) paymentFactory).upgradeMembership(paymentMembershipActivation.getOrder());
            isNotificationEmailSent = ((MembershipDistributor) paymentFactory).notifyOwnerViaEmail("Membership Upgrade", "Your membership is upgraded from now on...");
        }
        assertEquals(true, isUpgradeApplied);
        assertEquals(true, isNotificationEmailSent);
    }

    @Test
    public void testPayment_VideoLearningToSki() {
        boolean isVideoAddeToSlip = false;
        Object paymentFactory = PaymentFactory.PaymentFactoryDistribution(paymentVideoLearningToSki);
        if (paymentFactory instanceof VideoDistributor) {
            isVideoAddeToSlip = ((VideoDistributor) paymentFactory).addFirstAidVideoToPackingSlip(new Order());

        }
        assertEquals(true, isVideoAddeToSlip);
    }
}
