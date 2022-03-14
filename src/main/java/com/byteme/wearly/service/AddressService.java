package com.byteme.wearly.service;

import com.byteme.wearly.model.Address;
import com.byteme.wearly.repo.AddressRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 17, 2022 10:12 AM
 */

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepo addressRepo;

    public Address create(Address address) {
//        if (addressRepo.findByUserId(address.getUser().getId())) {
//            throw new IllegalStateException("Address already exist.");
//        }
        if (addressRepo.findByUserId(address.getUser().getId()).isPresent()) {
            throw new IllegalStateException("Address already exist.");
        }
        return addressRepo.save(address);
    }

    // TODO: 2/17/2022 check if user exists
    public Address getById(Long wearlierId) {
        return addressRepo.findByUserId(wearlierId).get();
    }

    public void delete(Long id) {
        addressRepo.deleteById(id);
    }

}
