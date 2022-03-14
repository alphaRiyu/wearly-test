package com.byteme.wearly.service.couturier.servicetype;

import com.byteme.wearly.model.couturier.servicetype.Customize;
import com.byteme.wearly.repo.couturier.servicetype.CustomizeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 25, 2022 12:54 PM
 */

@Service
@RequiredArgsConstructor
public class CustomizeService {

    private final CustomizeRepo customizeRepo;

    public Customize create(Customize customize) {
        return customizeRepo.save(customize);
    }

    public Customize getById(Long id) {
        if (customizeRepo.findById(id).isPresent()) {
            return customizeRepo.findById(id).get();
        }
        throw new IllegalStateException("Id not found");
    }

    public List<Customize> getList() {
        return customizeRepo.findAll();
    }

    public List<Customize> getListByCouturierId(Long id) {
        return customizeRepo.findAllByCouturierId(id, Sort.by("createdAt"));
    }
}
