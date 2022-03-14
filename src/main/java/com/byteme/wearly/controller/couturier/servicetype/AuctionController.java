package com.byteme.wearly.controller.couturier.servicetype;

import com.byteme.wearly.model.couturier.servicetype.Auction;
import com.byteme.wearly.service.couturier.ClotheImageService;
import com.byteme.wearly.service.couturier.servicetype.AuctionService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 24, 2022 4:11 PM
 */

@RestController
@RequestMapping("/auction")
@RequiredArgsConstructor
public class AuctionController {

    private final AuctionService auctionService;
    private final ClotheImageService clotheImageService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Auction> createClotheForAuction(@RequestBody Auction auction) {
        return new ResponseEntity<>(auctionService.create(auction), HttpStatus.CREATED);
    }

    @Transactional
    @PostMapping(value = "/image")
    public ResponseEntity<String> uploadImage(@RequestParam("id") Long id, @RequestParam("files") MultipartFile[] files) throws IOException {
        clotheImageService.createClotheImage(id, files);
        return new ResponseEntity<>("Images uploaded.", HttpStatus.CREATED);
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<List<String>> getAllAuctionImages(@PathVariable("id") Long id) {
        return new ResponseEntity<>(clotheImageService.getList(id), HttpStatus.OK);
    }

    @GetMapping(value = "/image/{id}/{filename}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> loadClotheImage(@PathVariable("id") Long id, @PathVariable("filename") String filename) throws IOException {
        FileSystemResource fileSystemResource = new FileSystemResource("src/main/resources/images/clothe/" + id + "/" + filename);
        InputStream inputStream = fileSystemResource.getInputStream();
        return new ResponseEntity<>(IOUtils.toByteArray(inputStream), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Auction> getClotheForAuctionById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(auctionService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Auction>> getAllClotheForAuction() {
        return new ResponseEntity<>(auctionService.getList(), HttpStatus.OK);
    }

    @GetMapping("/couturier/{id}")
    public ResponseEntity<List<Auction>> getAllClotheForAuctionByCouturierId(@PathVariable("id") Long couturierId) {
       return new ResponseEntity<>(auctionService.getListByCouturierId(couturierId), HttpStatus.OK);
    }

    // TODO: 3/11/2022 put mapping
    // TODO: 3/11/2022 delete mapping
}
