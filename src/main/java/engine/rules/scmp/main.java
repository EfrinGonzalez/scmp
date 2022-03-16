package engine.rules.scmp;

import engine.rules.scmp.Services.BookService;
import engine.rules.scmp.Services.PhysicalProductService;
import engine.rules.scmp.implementations.BookRulesImpl;
import engine.rules.scmp.interfaces.IBookRules;
import engine.rules.scmp.interfaces.IPhysicalRules;
import engine.rules.scmp.implementations.PhysicalRulesImpl;
import engine.rules.scmp.models.Order;

public class main
{
    private static IPhysicalRules physicalDistributor;
    private static IBookRules bookDistributor;

    public static void main(String[] args) {
        IBookRules bookDistributor = new BookRulesImpl();
        IPhysicalRules physicalDistributor = new PhysicalRulesImpl();

        BookService a_processor = new BookService(physicalDistributor, bookDistributor);
        a_processor.executeRules(new Order());

        PhysicalProductService b_processor = new PhysicalProductService(physicalDistributor);
        b_processor.executeRules(new Order());


    }
}
