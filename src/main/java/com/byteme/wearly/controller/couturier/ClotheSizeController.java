package com.byteme.wearly.controller.couturier;

import com.byteme.wearly.model.couturier.ClotheSize;
import com.byteme.wearly.service.couturier.ClotheSizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 28, 2022 5:47 PM
 */

@RestController
@RequestMapping("/size")
@RequiredArgsConstructor
public class ClotheSizeController {

    private final ClotheSizeService clotheSizeService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClotheSize> saveClotheSize(@RequestBody ClotheSize size) {
        return new ResponseEntity<>(clotheSizeService.create(size), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ClotheSize>> getAllClotheSize(@PathVariable("id") Long id) {
        return new ResponseEntity<>(clotheSizeService.getListByClotheId(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClotheSize(@PathVariable("id") Long id) {
        clotheSizeService.delete(id);
        return new ResponseEntity<>("Clothe size deleted.", HttpStatus.OK);
    }
}
