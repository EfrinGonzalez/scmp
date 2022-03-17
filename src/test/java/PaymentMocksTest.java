import engine.rules.scmp.Services.PhysicalProductService;
import engine.rules.scmp.implementations.*;
import engine.rules.scmp.interfaces.*;
import engine.rules.scmp.models.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PaymentMocksTest {
    static Payment paymentPhysical;
    static Payment paymentBook;
    static Payment paymentMembershipActivation;
    static Payment paymentMembershipUpdate;
    static Payment paymentVideoLearningToSki;

    static IPhysicalRules physicalDistributorMock;
    static IBookRules bookDistributor;
    static IMembershipRules membershipDistributor;
    static IEmailRules notificator;
    static IVideoRules videoDistributor;
    static boolean rulesExecuted = false;
    static boolean packingSent = false;
    static boolean commissionGiven = false;


    @BeforeClass
    public static void init() {

        packingSent = true;
        commissionGiven = true;
        rulesExecuted = true;
        physicalDistributorMock = Mockito.mock(IPhysicalRules.class);
        Mockito.when(physicalDistributorMock.packingSlipForShipping(new Order())).thenReturn(packingSent);
        Mockito.when(physicalDistributorMock.giveCommissionPaymentToAgent()).thenReturn(commissionGiven);

        bookDistributor = new BookRulesImpl();
        membershipDistributor = new MembershipRulesImpl();
        notificator = new EmailRulesImpl();
        videoDistributor = new VideoRulesImpl();
    }

        @Test
        public void testCreationOfPayment_PhysicalProduct() {
            PhysicalProductService service = new PhysicalProductService(this.physicalDistributorMock);

            boolean result = service.executeRules(new Order());
            System.out.println("REsult of executing the rules in service: "+result);
            assertEquals(rulesExecuted, result);

        }

}
