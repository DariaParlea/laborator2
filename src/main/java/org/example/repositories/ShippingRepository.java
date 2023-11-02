package org.example.repositories;
import org.example.model.Shipping;
import java.util.ArrayList;
import java.util.List;

public class ShippingRepository {

    private List<Shipping> shippings = new ArrayList<>();

    public Shipping findById(int targetShippingId) {
        for (Shipping shipping : shippings) {
            if (shipping.getShipping_id() == targetShippingId) {
                return shipping;
            }
        }
        return null;
    }

    public List<Shipping> findAll() {
        return shippings;
    }

    public void save(Shipping shipping) {
        shippings.add(shipping);
    }

    public void update(Shipping updatedShipping) {
        for (Shipping shipping : shippings) {
            if (shipping.getShipping_id() == updatedShipping.getShipping_id()) {
                shipping.setAddress(updatedShipping.getAddress());
                shipping.setShipping_method(updatedShipping.getShipping_method());
                break;
            }
        }
    }

    public void delete(int targetShippingId) {
        Shipping shippingToRemove = null;
        for (Shipping shipping : shippings) {
            if (shipping.getShipping_id() == targetShippingId) {
                shippingToRemove = shipping;
                break;
            }
        }
        if (shippingToRemove != null) {
            shippings.remove(shippingToRemove);
        }
    }
}
