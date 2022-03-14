package com.byteme.wearly.controller.couturier.servicetype;

import com.byteme.wearly.model.couturier.servicetype.Sale;
import com.byteme.wearly.service.couturier.servicetype.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 14, 2022 11:12 PM
 */

@RestController
@RequestMapping("/sale")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Sale> createClotheForSale(@RequestBody Sale sale) {
        return new ResponseEntity<>(saleService.create(sale), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> getClotheForSaleById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(saleService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Sale>> getAllClotheForSale() {
        return new ResponseEntity<>(saleService.getList(), HttpStatus.OK);
    }

    // TODO: 2/25/2022 method to get all clothes for sale owned by couturier
    @GetMapping("/couturier/{id}")
    public ResponseEntity<List<Sale>> getAllClotheForSaleByCouturierId(@PathVariable("id") Long couturierId) {
        return new ResponseEntity<>(saleService.getListByCouturierId(couturierId), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sale> updateClotheForSale(@PathVariable("id") Long id, @RequestBody Sale sale) {
        return new ResponseEntity<>(saleService.update(id, sale), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClotheForSale(@PathVariable("id") Long id) {
        saleService.delete(id);
        return new ResponseEntity<>("Clothe for sale deleted.", HttpStatus.OK);
    }
}
