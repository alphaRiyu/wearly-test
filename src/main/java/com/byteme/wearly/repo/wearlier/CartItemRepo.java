package com.byteme.wearly.repo.wearlier;

import com.byteme.wearly.model.wearlier.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 15, 2022 10:53 AM
 */

@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Long> {

    List<CartItem> findByWearlierId(Long id);
}
