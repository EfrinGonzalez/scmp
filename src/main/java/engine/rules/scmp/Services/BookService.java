package engine.rules.scmp.Services;

import engine.rules.scmp.interfaces.IBookRules;
import engine.rules.scmp.interfaces.IPhysicalRules;
import engine.rules.scmp.models.Payment;

public class BookService {


    private static IPhysicalRules physicalDistributor;
    private static IBookRules bookDistributor;

    public BookService(IPhysicalRules physicalDistributor, IBookRules bookDistributor) {
        this.physicalDistributor = physicalDistributor;
        this.bookDistributor = bookDistributor;
    }


   public boolean executeBookRules(Payment payment) {
       System.out.println("Executing rules for book");
       this.bookDistributor.duplicatePackingSlipForRoyalDepartment(payment);
       this.physicalDistributor.giveCommissionPaymentToAgent(payment);
        return true;
    }


}
