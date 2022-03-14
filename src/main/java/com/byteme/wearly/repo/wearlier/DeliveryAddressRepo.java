package com.byteme.wearly.repo.wearlier;

import com.byteme.wearly.model.wearlier.DeliveryAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 17, 2022 10:59 AM
 */

@Repository
public interface DeliveryAddressRepo extends JpaRepository<DeliveryAddress, Long> {

    List<DeliveryAddress> findByUserId(Long wearlierId);
}
