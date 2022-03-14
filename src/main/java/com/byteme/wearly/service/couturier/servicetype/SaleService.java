package com.byteme.wearly.service.couturier.servicetype;

import com.byteme.wearly.model.couturier.servicetype.Sale;
import com.byteme.wearly.repo.couturier.servicetype.SaleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 14, 2022 10:51 PM
 */

@Service
@RequiredArgsConstructor
public class SaleService {

    private final SaleRepo saleRepo;

    // TODO: 2/15/2022 validate entry
    public Sale create(Sale sale) {
        return saleRepo.save(sale);
    }

    public Sale getById(Long id) {
        if (saleRepo.findById(id).isPresent()) {
            return saleRepo.findById(id).get();
        }
        throw new IllegalStateException("Id does not exist");
    }

    // TODO: 2/24/2022 improve
    public List<Sale> getListByCouturierId(Long id) {
        return saleRepo.findAllByCouturierId(id, Sort.by("createdAt"));
    }

    public List<Sale> getList() {
        return saleRepo.findAll();
    }

    // TODO: 2/14/2022 add content to update and validate entry
    @Transactional
    public Sale update(Long id, Sale sale) {
        return null;
    }

    public void delete(Long id) {
        saleRepo.deleteById(id);
    }
}
