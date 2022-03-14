package com.byteme.wearly.controller.wearlier;

import com.byteme.wearly.model.wearlier.BidStatus;
import com.byteme.wearly.service.wearlier.BidStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 25, 2022 9:53 AM
 */

@RestController
@RequestMapping("/bid")
@RequiredArgsConstructor
public class BidStatusController {

    private final BidStatusService bidStatusService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BidStatus> placeBid(@RequestBody BidStatus bidStatus) {
        return new ResponseEntity<>(bidStatusService.create(bidStatus), HttpStatus.CREATED);
    }

    // TODO: 3/14/2022 method for getting clothe from notification details

    // this is for showing all bid status of specific clothe when user wants to see all bidders
    @GetMapping("/{id}")
    public ResponseEntity<List<BidStatus>> getAllBidByClotheId(@PathVariable("id") Long clotheId) {
        return new ResponseEntity<>(bidStatusService.getListByAuctionId(clotheId), HttpStatus.OK);
    }

    // this is for notification about all bidding related things
    @GetMapping("/receiver/{id}")
    public ResponseEntity<List<BidStatus>> getAllBidStatusByReceiverId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(bidStatusService.getList(id), HttpStatus.OK);
    }

}
