package engine.rules.scmp;

import engine.rules.scmp.Services.BookService;
import engine.rules.scmp.Services.PhysicalProductService;
import engine.rules.scmp.implementations.BookDistributorImpl;
import engine.rules.scmp.interfaces.IBookDistributor;
import engine.rules.scmp.interfaces.IPhysicalDistributor;
import engine.rules.scmp.implementations.PhysicalDistributorImpl;
import engine.rules.scmp.models.Order;

public class main
{
    private static IPhysicalDistributor physicalDistributor;
    private static IBookDistributor bookDistributor;

    public static void main(String[] args) {
        IBookDistributor bookDistributor = new BookDistributorImpl();
        IPhysicalDistributor physicalDistributor = new PhysicalDistributorImpl();



        BookService a_processor = new BookService(physicalDistributor, bookDistributor);
        a_processor.executeRules(new Order());

        PhysicalProductService b_processor = new PhysicalProductService(physicalDistributor);
        b_processor.executeRules(new Order());


    }
}
