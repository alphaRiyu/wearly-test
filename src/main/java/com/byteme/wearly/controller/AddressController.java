package com.byteme.wearly.controller;

import com.byteme.wearly.model.Address;
import com.byteme.wearly.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 17, 2022 10:32 AM
 */

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        return new ResponseEntity<>(addressService.create(address), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressByWearlierId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(addressService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable("id") Long id) {
        addressService.delete(id);
        return new ResponseEntity<>("Address deleted", HttpStatus.NO_CONTENT);
    }
}
