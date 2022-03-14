package com.byteme.wearly.service.couturier.servicetype;

import com.byteme.wearly.model.couturier.servicetype.Rent;
import com.byteme.wearly.repo.couturier.servicetype.RentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 24, 2022 3:25 PM
 */

@Service
@RequiredArgsConstructor
public class RentService {

    private final RentRepo rentRepo;

    public Rent create(Rent rent) {
        return rentRepo.save(rent);
    }

    public Rent getById(Long id) {
        if (rentRepo.findById(id).isPresent()) {
            return rentRepo.findById(id).get();
        }
        throw new IllegalStateException("Id not found");
    }

    public List<Rent> getList() {
        return rentRepo.findAll();
    }

    public List<Rent> getListByCouturierId(Long couturierId) {
        return rentRepo.findAllByCouturierId(couturierId, Sort.by("createdAt"));
    }
}
