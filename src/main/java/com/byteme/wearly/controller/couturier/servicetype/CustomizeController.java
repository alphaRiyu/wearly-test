package com.byteme.wearly.controller.couturier.servicetype;

import com.byteme.wearly.model.couturier.servicetype.Customize;
import com.byteme.wearly.service.couturier.servicetype.CustomizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 25, 2022 12:57 PM
 */

@RestController
@RequestMapping("/customize")
@RequiredArgsConstructor
public class CustomizeController {

    private final CustomizeService customizeService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customize> createClotheForCustomize(@RequestBody Customize customize) {
        return new ResponseEntity<>(customizeService.create(customize), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customize> getClotheForCustomizeById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(customizeService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Customize>> getAllClotheForCustomize() {
        return new ResponseEntity<>(customizeService.getList(), HttpStatus.OK);
    }

    @GetMapping("/couturier/{id}")
    public ResponseEntity<List<Customize>> getAllClotheForCustomizeByCouturierId(@PathVariable("id") Long couturierId) {
        return new ResponseEntity<>(customizeService.getListByCouturierId(couturierId), HttpStatus.OK);
    }

    // TODO: 3/11/2022 put mapping
    // TODO: 3/11/2022 delete mapping
}
