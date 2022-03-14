package com.byteme.wearly.service.wearlier;

import com.byteme.wearly.model.wearlier.CartItem;
import com.byteme.wearly.repo.wearlier.CartItemRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 15, 2022 10:54 AM
 */

@Service
@RequiredArgsConstructor
public class CartItemService {

    private final CartItemRepo cartItemRepo;

    // TODO: 2/15/2022 validate entry
    public CartItem create(CartItem cartItem) {
        return cartItemRepo.save(cartItem);
    }

    public List<CartItem> getList(Long wearlierId) {
        return cartItemRepo.findByWearlierId(wearlierId);
    }

    // TODO: 2/15/2022 create method that deletes all cart item
    // TODO: 2/17/2022 verify if cart item belongs to specific wearlier
    public void delete(Long id) {
        cartItemRepo.deleteById(id);
    }
}
