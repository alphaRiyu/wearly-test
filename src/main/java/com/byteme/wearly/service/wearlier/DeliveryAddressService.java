package com.byteme.wearly.service.wearlier;

import com.byteme.wearly.model.wearlier.DeliveryAddress;
import com.byteme.wearly.repo.wearlier.DeliveryAddressRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 17, 2022 10:59 AM
 */

@Service
@RequiredArgsConstructor
public class DeliveryAddressService {

    private final DeliveryAddressRepo deliveryAddressRepo;

    public DeliveryAddress create(DeliveryAddress deliveryAddress) {
        return deliveryAddressRepo.save(deliveryAddress);
    }

    public DeliveryAddress getById(Long id) {
        if (deliveryAddressRepo.findById(id).isPresent()) {
            return deliveryAddressRepo.findById(id).get();
        }
        throw new IllegalStateException("Delivery address not found.");
    }

    public List<DeliveryAddress> getList(Long wearlierId) {
        return deliveryAddressRepo.findByUserId(wearlierId);
    }

    // TODO: 2/17/2022 add method to delete multiple delivery address
    public void delete(Long id) {
        deliveryAddressRepo.deleteById(id);
    }
}
