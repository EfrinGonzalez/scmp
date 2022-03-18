package engine.rules.scmp.Services;

import engine.rules.scmp.interfaces.IVideoRules;
import engine.rules.scmp.models.Payment;

public class VideoService {

    private static IVideoRules videoDistributor;

    public VideoService(IVideoRules videoDistributor) {
        this.videoDistributor = videoDistributor;
    }


    public boolean executeRules(Payment payment) {
        System.out.println("Executing rules for Video");
       this.videoDistributor.addFirstAidVideoToPackingSlip(payment);

        return true;
    }
}
