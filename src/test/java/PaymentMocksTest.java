import engine.rules.scmp.Services.BookService;
import engine.rules.scmp.Services.MembershipService;
import engine.rules.scmp.Services.PhysicalProductService;
import engine.rules.scmp.Services.VideoService;
import engine.rules.scmp.enums.ProductType;
import engine.rules.scmp.interfaces.*;
import engine.rules.scmp.models.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;


public class PaymentMocksTest {

    private static IPhysicalRules physicalRulesMock;
    private static IBookRules bookRulesMock;
    static IMembershipRules membershipRulesMock;
    static IEmailRules notificatorMock;
    static IVideoRules videoRulesMock;

    static Payment paymentBook;
    static Payment paymentPhysical;
    static Payment paymentMembershipActivation;
    static Payment paymentMembershipUpdate;
    static Payment paymentVideoLearningToSki;

    @BeforeClass
    public static void init() {

        /*Note: As there is no specification for handling specific cases for orders,
        then new objects are passed on each test.*/

        paymentPhysical = new Payment(1, ProductType.PHYSICAL_PRODUCT, new Order());
        paymentBook = new Payment(2, ProductType.BOOK, new Order());
        paymentMembershipActivation = new Payment(3, ProductType.MEMBERSHIP_ACTIVATION, new Order());
        paymentMembershipUpdate = new Payment(4, ProductType.MEMBERSHIP_UPGRADE, new Order());
        paymentVideoLearningToSki = new Payment(5, ProductType.VIDEO_LEARNING_TO_SKI, new Order());


        physicalRulesMock = Mockito.mock(IPhysicalRules.class);
        Mockito.when(physicalRulesMock.packingSlipForShipping(paymentPhysical))
                .thenReturn(true);

       Mockito.when(physicalRulesMock.giveCommissionPaymentToAgent(paymentPhysical))
               .thenReturn(true);

        bookRulesMock = Mockito.mock(IBookRules.class);
        Mockito.when(bookRulesMock.duplicatePackingSlipForRoyalDepartment(paymentBook))
                .thenReturn(true);

        membershipRulesMock = Mockito.mock(IMembershipRules.class);
        Mockito.when(membershipRulesMock.activateMembership(paymentMembershipActivation))
                .thenReturn(true);

        membershipRulesMock = Mockito.mock(IMembershipRules.class);
        Mockito.when(membershipRulesMock.upgradeMembership(paymentMembershipUpdate))
                .thenReturn(true);

        notificatorMock = Mockito.mock(IEmailRules.class);
        Mockito.when((notificatorMock.notifyOwnerViaEmail("notification", "owner")))
                .thenReturn(true);

        videoRulesMock = Mockito.mock(IVideoRules.class);
        Mockito.when(videoRulesMock.addFirstAidVideoToPackingSlip(paymentVideoLearningToSki))
                .thenReturn(true);
    }


    /*Note: The tested flow goes like the following:
    * // arrange the creation of the service via Dependency Injection
        PhysicalProductService service = new PhysicalProductService(this.physicalRulesMock);
        // act on the rules executing by passing the payment containing the order.
        boolean result = service.executeRules(paymentPhysical);
        // assert that the mocked behavior is as expected.
        assertEquals(true, result);*/

    @Test
    public void testCreationOfPayment_MockPhysicalProduct() {
        PhysicalProductService service = new PhysicalProductService(this.physicalRulesMock);
        boolean result = service.executePhysicalRules(paymentPhysical);
        assertEquals(true, result);
    }

    @Test
    public void testCreationOfPayment_MockBook() {
        BookService service = new BookService(this.physicalRulesMock,this.bookRulesMock);
        boolean result = service.executeBookRules(paymentBook);
        assertEquals(true, result);
    }

    @Test
    public void testCreationOfPayment_MockMembershipActivation() {
        MembershipService service = new MembershipService(this.membershipRulesMock, this.notificatorMock);
        boolean result = service.executeCreationRules(paymentMembershipActivation);
        assertEquals(true, result);
    }

    @Test
    public void testCreationOfPayment_MockMembershipUpgrade() {
        MembershipService service = new MembershipService(this.membershipRulesMock, this.notificatorMock);
        boolean result = service.executeUpgradeRules(paymentMembershipUpdate);
        assertEquals(true, result);
    }

    @Test
    public void testPayment_MockVideoLearningToSki() {
        VideoService service = new VideoService(this.videoRulesMock);
        boolean result = service.executeVideoRules(paymentVideoLearningToSki);
        assertEquals(true, result);
    }
}
