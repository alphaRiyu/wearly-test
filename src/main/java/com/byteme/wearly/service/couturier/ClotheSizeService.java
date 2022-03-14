package com.byteme.wearly.service.couturier;

import com.byteme.wearly.model.couturier.ClotheSize;
import com.byteme.wearly.repo.couturier.ClotheSizeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 28, 2022 5:43 PM
 */

@Service
@RequiredArgsConstructor
public class ClotheSizeService {

    private final ClotheSizeRepo clotheSizeRepo;

    public ClotheSize create(ClotheSize size) {
        return clotheSizeRepo.save(size);
    }

    public List<ClotheSize> getListByClotheId(Long id) {
        return clotheSizeRepo.findAllByClotheId(id);
    }

    public void delete(Long id) {
        clotheSizeRepo.deleteById(id);
    }
}
