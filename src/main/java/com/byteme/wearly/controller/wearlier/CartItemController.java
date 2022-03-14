package com.byteme.wearly.controller.wearlier;

import com.byteme.wearly.model.wearlier.CartItem;
import com.byteme.wearly.service.wearlier.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 15, 2022 11:01 AM
 */

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartItemController {

    private final CartItemService cartItemService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartItem> createCartItem(@RequestBody CartItem cartItem) {
        return new ResponseEntity<>(cartItemService.create(cartItem), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<CartItem>> getAllCartItem(@PathVariable("id") Long wearlierId) {
        return new ResponseEntity<>(cartItemService.getList(wearlierId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCartItem(@PathVariable("id") Long id) {
        cartItemService.delete(id);
        return new ResponseEntity<>("Cart item deleted.", HttpStatus.NO_CONTENT);
    }
}
