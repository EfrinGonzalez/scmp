package engine.rules.scmp.interfaces;

import engine.rules.scmp.models.Order;

public interface IVideoDistributor {
    boolean addFirstAidVideoToPackingSlip(Order order);
}
