package com.byteme.wearly.service.couturier;

import com.byteme.wearly.model.WearlyUser;
import com.byteme.wearly.model.couturier.Couturier;
import com.byteme.wearly.repo.WearlyUserRepo;
import com.byteme.wearly.repo.couturier.CouturierRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 14, 2022 12:58 PM
 */

@Service
@RequiredArgsConstructor
public class CouturierService {

    private final WearlyUserRepo wearlyUserRepo;
    private final CouturierRepo couturierRepo;

    // TODO: 2/15/2022 validate if necessary 
    @Transactional
    // when the admin approves the request of wearlier to become couturier
    public void create(Long id) {
        // must be validated first by admin before approval
        WearlyUser wearlyUser = wearlyUserRepo
                .findById(id)
                .orElseThrow(() -> new IllegalStateException("User not found"));
        wearlyUser.setIsCouturier(1);
        couturierRepo.addCouturierById(id);
    }

    public Couturier getById(Long id) {
        if (couturierRepo.findById(id).isPresent()) {
            return couturierRepo.findById(id).get();
        }
        throw new IllegalStateException("Id does not exist");
    }

    public List<Couturier> getList() {
        return couturierRepo.findAll();
    }

    // TODO: 2/15/2022 update or delete couturier account

}
