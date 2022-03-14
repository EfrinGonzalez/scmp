package engine.rules.scmp.Distributors;

import engine.rules.scmp.interfaces.IVideoDistributor;
import engine.rules.scmp.models.Order;

public class VideoDistributor implements IVideoDistributor {
    @Override
    public boolean addFirstAidVideoToPackingSlip(Order order) {
        return false;
    }
}
