package engine.rules.scmp.interfaces;

import engine.rules.scmp.models.Order;
import engine.rules.scmp.models.Payment;

public interface IVideoRules {
    boolean addFirstAidVideoToPackingSlip(Payment payment);
}
