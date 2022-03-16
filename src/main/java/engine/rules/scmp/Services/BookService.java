package engine.rules.scmp.Services;

import engine.rules.scmp.interfaces.IBookRules;
import engine.rules.scmp.interfaces.IPhysicalRules;
import engine.rules.scmp.models.Order;

public class BookService {


    private static IPhysicalRules physicalDistributor;
    private static IBookRules bookDistributor;

    public BookService(IPhysicalRules physicalDistributor, IBookRules bookDistributor) {
        this.physicalDistributor = physicalDistributor;
        this.bookDistributor = bookDistributor;
    }

    public BookService() {
    }

    public IPhysicalRules getPhysicalDistributor() {
        return physicalDistributor;
    }

    public void setPhysicalDistributor(IPhysicalRules physicalDistributor) {
        BookService.physicalDistributor = physicalDistributor;
    }

    public IBookRules getBookDistributor() {
        return bookDistributor;
    }

    public  void setBookDistributor(IBookRules bookDistributor) {
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
