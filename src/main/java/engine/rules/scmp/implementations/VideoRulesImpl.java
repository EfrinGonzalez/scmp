package engine.rules.scmp.implementations;

import engine.rules.scmp.interfaces.IVideoRules;
import engine.rules.scmp.models.Order;
import engine.rules.scmp.models.Payment;

public class VideoRulesImpl implements IVideoRules {
    @Override
    public boolean addFirstAidVideoToPackingSlip(Payment payment) {
        System.out.println("Video Learning to Ski is added to package slip");
        return true;
    }
}
