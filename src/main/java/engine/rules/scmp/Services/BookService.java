package engine.rules.scmp.Services;

import engine.rules.scmp.interfaces.IBookDistributor;
import engine.rules.scmp.interfaces.IPhysicalDistributor;
import engine.rules.scmp.models.Order;

public class BookService {


    private static IPhysicalDistributor physicalDistributor;
    private static IBookDistributor bookDistributor;

    public BookService(IPhysicalDistributor physicalDistributor, IBookDistributor bookDistributor) {
        this.physicalDistributor = physicalDistributor;
        this.bookDistributor = bookDistributor;
    }

    public BookService() {
    }

    public  IPhysicalDistributor getPhysicalDistributor() {
        return physicalDistributor;
    }

    public void setPhysicalDistributor(IPhysicalDistributor physicalDistributor) {
        BookService.physicalDistributor = physicalDistributor;
    }

    public IBookDistributor getBookDistributor() {
        return bookDistributor;
    }

    public  void setBookDistributor(IBookDistributor bookDistributor) {
        BookService.bookDistributor = bookDistributor;
    }


   public boolean executeRules(Order order) {
      // this.physicalDistributor.giveCommissionPaymentToAgent();
       System.out.println("Executing rules for book");
       this.bookDistributor.duplicatePackingSlipForRoyalDepartment(new Order());
       this.physicalDistributor.giveCommissionPaymentToAgent();
       //System.out.println("Resutl"+ result);;
       return true;
    }


}
