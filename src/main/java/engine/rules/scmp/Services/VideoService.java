package engine.rules.scmp.Services;

import engine.rules.scmp.interfaces.IVideoRules;
import engine.rules.scmp.models.Order;

public class VideoService {

    private static IVideoRules videoDistributor;

    public VideoService(IVideoRules videoDistributor) {
        this.videoDistributor = videoDistributor;
    }

    public static IVideoRules getVideoDistributor() {
        return videoDistributor;
    }

    public static void setVideoDistributor(IVideoRules videoDistributor) {
        VideoService.videoDistributor = videoDistributor;
    }

    public boolean executeRules(Order order) {
        System.out.println("Executing rules for Video");
       this.videoDistributor.addFirstAidVideoToPackingSlip(order);

        return true;
    }
}
