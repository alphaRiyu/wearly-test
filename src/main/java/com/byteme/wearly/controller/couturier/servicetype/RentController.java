package com.byteme.wearly.controller.couturier.servicetype;

import com.byteme.wearly.model.couturier.servicetype.Rent;
import com.byteme.wearly.service.couturier.servicetype.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 24, 2022 3:37 PM
 */

@RestController
@RequestMapping("/rent")
@RequiredArgsConstructor
public class RentController {

    private final RentService rentService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rent> createClotheForRent(@RequestBody Rent rent) {
        return new ResponseEntity<>(rentService.create(rent), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rent> getClotheForRentById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(rentService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Rent>> getAllClotheForRent() {
        return new ResponseEntity<>(rentService.getList(), HttpStatus.OK);
    }

    @GetMapping("/couturier/{id}")
    public ResponseEntity<List<Rent>> getAllClotheForRentByCouturierId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(rentService.getListByCouturierId(id), HttpStatus.OK);
    }

    // TODO: 3/11/2022 put mapping
    // TODO: 3/11/2022 delete mapping

}
