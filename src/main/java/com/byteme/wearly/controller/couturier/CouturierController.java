package com.byteme.wearly.controller.couturier;

import com.byteme.wearly.model.couturier.Couturier;
import com.byteme.wearly.service.couturier.CouturierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 14, 2022 1:34 PM
 */

@RestController
@RequestMapping("/couturier")
@RequiredArgsConstructor
public class CouturierController {

    private final CouturierService couturierService;

    @PostMapping("/{id}")
    public ResponseEntity<String> createCouturier(@PathVariable("id")  Long id) {
        couturierService.create(id);
        return new ResponseEntity<>("Request approved!", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Couturier> getCouturierById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(couturierService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Couturier>> getAllCouturier() {
        return new ResponseEntity<>(couturierService.getList(), HttpStatus.OK);
    }
}
