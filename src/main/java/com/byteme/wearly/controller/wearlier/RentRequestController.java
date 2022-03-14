package com.byteme.wearly.controller.wearlier;

import com.byteme.wearly.model.wearlier.RentRequest;
import com.byteme.wearly.service.wearlier.RentRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 25, 2022 12:00 PM
 */

@RestController
@RequestMapping("/request")
@RequiredArgsConstructor
public class RentRequestController {

    private final RentRequestService rentRequestService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RentRequest> submitRequest(@RequestBody RentRequest rentRequest) {
        return new ResponseEntity<>(rentRequestService.create(rentRequest), HttpStatus.CREATED);
    }

    // this is when opening specific notification details
    @GetMapping("/{id}")
    public ResponseEntity<RentRequest> getRentRequestByClotheId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(rentRequestService.getByClotheId(id), HttpStatus.OK);
    }

    // this is for notifications on all rent requests
    @GetMapping("/receiver/{id}")
    public ResponseEntity<List<RentRequest>> getAllRentRequestByReceiverId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(rentRequestService.getList(id), HttpStatus.OK);
    }
}
