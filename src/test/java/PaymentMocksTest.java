import engine.rules.scmp.Services.BookService;
import engine.rules.scmp.Services.MembershipService;
import engine.rules.scmp.Services.PhysicalProductService;
import engine.rules.scmp.Services.VideoService;
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


    @BeforeClass
    public static void init() {

        physicalRulesMock = Mockito.mock(IPhysicalRules.class);
        Mockito.when(physicalRulesMock.packingSlipForShipping(new Order()))
                .thenReturn(true);

       Mockito.when(physicalRulesMock.giveCommissionPaymentToAgent())
               .thenReturn(true);

        bookRulesMock = Mockito.mock(IBookRules.class);
        Mockito.when(bookRulesMock.duplicatePackingSlipForRoyalDepartment(new Order()))
                .thenReturn(true);

        membershipRulesMock = Mockito.mock(IMembershipRules.class);
        Mockito.when((membershipRulesMock.activateMembership(new Order())))
                .thenReturn(true);

        membershipRulesMock = Mockito.mock(IMembershipRules.class);
        Mockito.when((membershipRulesMock.upgradeMembership(new Order())))
                .thenReturn(true);

        notificatorMock = Mockito.mock(IEmailRules.class);
        Mockito.when((notificatorMock.notifyOwnerViaEmail("notification", "owner")))
                .thenReturn(true);

        videoRulesMock = Mockito.mock(IVideoRules.class);
        Mockito.when(videoRulesMock.addFirstAidVideoToPackingSlip(new Order()))
                .thenReturn(true);
    }

    @Test
    public void testCreationOfPayment_MockPhysicalProduct() {
        // arrange
        PhysicalProductService service = new PhysicalProductService(this.physicalRulesMock);
        // act
        boolean result = service.executeRules(new Order());
        // assert
        assertEquals(true, result);
    }

    @Test
    public void testCreationOfPayment_MockBook() {
        BookService service = new BookService(this.physicalRulesMock,this.bookRulesMock);
        boolean result = service.executeRules(new Order());
        assertEquals(true, result);
    }

    @Test
    public void testCreationOfPayment_MockMembershipActivation() {
        MembershipService service = new MembershipService(this.membershipRulesMock, this.notificatorMock);
        boolean result = service.executeCreationRules(new Order());
        assertEquals(true, result);
    }

    @Test
    public void testCreationOfPayment_MockMembershipUpgrade() {
        MembershipService service = new MembershipService(this.membershipRulesMock, this.notificatorMock);
        boolean result = service.executeUpgradeRules(new Order());
        assertEquals(true, result);
    }

    @Test
    public void testPayment_MockVideoLearningToSki() {
        VideoService service = new VideoService(this.videoRulesMock);
        boolean result = service.executeRules(new Order());
        assertEquals(true, result);
    }
}
