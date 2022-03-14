package com.byteme.wearly.controller.wearlier;

import com.byteme.wearly.model.wearlier.DeliveryAddress;
import com.byteme.wearly.service.wearlier.DeliveryAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 17, 2022 12:22 PM
 */

@RestController
@RequestMapping("/delivery")
@RequiredArgsConstructor
public class DeliveryAddressController {

    private final DeliveryAddressService deliveryAddressService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeliveryAddress> createDeliveryAddress(@RequestBody DeliveryAddress deliveryAddress) {
        deliveryAddressService.create(deliveryAddress);
        return new ResponseEntity<>(deliveryAddress, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryAddress> getDeliveryAddressById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(deliveryAddressService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<List<DeliveryAddress>> getAllDeliveryAddress(@PathVariable("id") Long wearlierId) {
        return new ResponseEntity<>(deliveryAddressService.getList(wearlierId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDeliveryAddress(@PathVariable("id") Long id) {
        deliveryAddressService.delete(id);
        return new ResponseEntity<>("Delivery Address deleted.", HttpStatus.NO_CONTENT);
    }
}
