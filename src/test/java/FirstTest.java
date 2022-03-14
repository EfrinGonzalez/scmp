import engine.rules.scmp.Distributors.PhysicalDistributor;
import engine.rules.scmp.PaymentFactory;
import engine.rules.scmp.enums.ProductType;
import engine.rules.scmp.enums.RuleAction;
import engine.rules.scmp.models.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FirstTest {
    static Payment paymentPhysical;
    @BeforeClass
    public static void init() {
        List<RuleAction> actionList = new ArrayList<RuleAction>();
        actionList.add(RuleAction.GENERATE_PACKING_SLIP_FOR_SHIPPING);
        actionList.add(RuleAction.GENERATE_COMMISSION_PAYMENT_TO_AGENT);
        Rule rule1 = new Rule(1, "rule uno", "rule number one", actionList);


        List<RuleAction> actionList2 = new ArrayList<RuleAction>();
        actionList2.add(RuleAction.GENERATE_PACKING_SLIP_FOR_SHIPPING);
        actionList2.add(RuleAction.GENERATE_COMMISSION_PAYMENT_TO_AGENT);
        Rule rule2 = new Rule(2, "rule dos", "rule number dos", actionList2);

        List<Product> productList = new ArrayList<Product>();
        /*Product product = new Product(1, "Uno", "Product number one", 12.00, 45, ProductType.PHYSICAL_PRODUCT, rule1);
        Product product2 = new Product(2, "Dos", "Product number two", 15.00, 12, ProductType.BOOK, rule2);*/

        Product product = new Product(1, "Uno", "Product number one", 12.00, 45, rule1);

        Product product2 = new Product(2, "Dos", "Product number two", 15.00, 12, rule2);

        productList.add(product);
        //  productList.add(product2);

        Order order = new Order(1, productList);

        paymentPhysical = new Payment(1, ProductType.PHYSICAL_PRODUCT, order);
        //System.out.println(payment.toString());
    }


    @Test
    public void testCreationOfPayment_PhysicalProduct() {
        boolean packingSentForShipping = false;
        boolean commisionPaid = false;
        Object paymentFactory = PaymentFactory.PaymentFactoryDistribution(paymentPhysical);
        if (paymentFactory instanceof PhysicalDistributor) {
            System.out.println("We are good");
            packingSentForShipping = ((PhysicalDistributor) paymentFactory).packingSlipForShipping(paymentPhysical.getOrder());
            commisionPaid = ((PhysicalDistributor) paymentFactory).giveCommissionPaymentToAgent();
        }

        assertEquals(true, packingSentForShipping);
        assertEquals(true, commisionPaid);

    }

}
