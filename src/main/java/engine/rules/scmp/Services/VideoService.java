package engine.rules.scmp.Services;

import engine.rules.scmp.interfaces.IVideoDistributor;
import engine.rules.scmp.models.Order;

public class VideoService {

    private static IVideoDistributor videoDistributor;

    public VideoService(IVideoDistributor videoDistributor) {
        this.videoDistributor = videoDistributor;
    }

    public static IVideoDistributor getVideoDistributor() {
        return videoDistributor;
    }

    public static void setVideoDistributor(IVideoDistributor videoDistributor) {
        VideoService.videoDistributor = videoDistributor;
    }

    public boolean executeRules(Order order) {
        System.out.println("Executing rules for Video");
       this.videoDistributor.addFirstAidVideoToPackingSlip(order);

        return true;
    }
}
