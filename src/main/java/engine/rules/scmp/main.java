package engine.rules.scmp;

import engine.rules.scmp.Services.BookService;
import engine.rules.scmp.Services.PhysicalProductService;
import engine.rules.scmp.enums.ProductType;
import engine.rules.scmp.factory.PaymentFactory;
import engine.rules.scmp.implementations.BookRulesImpl;
import engine.rules.scmp.interfaces.IBookRules;
import engine.rules.scmp.interfaces.IPhysicalRules;
import engine.rules.scmp.implementations.PhysicalRulesImpl;
import engine.rules.scmp.models.Order;
import engine.rules.scmp.models.Payment;

public class main
{
    private static IPhysicalRules physicalDistributor;
    private static IBookRules bookDistributor;

    public static void main(String[] args) {
        IBookRules bookDistributor = new BookRulesImpl();
        IPhysicalRules physicalDistributor = new PhysicalRulesImpl();
        Payment  paymentPhysical = new Payment(1, ProductType.PHYSICAL_PRODUCT, new Order());
       // Payment paymentBook = new Payment(2, ProductType.BOOK, new Order());


        Object paymentFactory = PaymentFactory.PaymentFactoryDistribution(paymentPhysical);


       if (paymentFactory instanceof PhysicalRulesImpl) {
            PhysicalProductService service = new PhysicalProductService(physicalDistributor);
            service.executeRules(paymentPhysical.getOrder());
        }
         /*
        if (paymentFactory instanceof BookRulesImpl) {
            BookService service = new BookService(physicalDistributor, bookDistributor);
        }*/


           /* BookService a_processor = new BookService(physicalDistributor, bookDistributor);
        a_processor.executeRules(new Order());

        PhysicalProductService b_processor = new PhysicalProductService(physicalDistributor);
        b_processor.executeRules(new Order());*/


    }
}
