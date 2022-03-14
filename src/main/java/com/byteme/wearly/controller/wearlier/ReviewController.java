package com.byteme.wearly.controller.wearlier;

import com.byteme.wearly.model.wearlier.Review;
import com.byteme.wearly.service.wearlier.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 24, 2022 5:03 PM
 */

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createReview(@RequestBody Review review) {
        reviewService.create(review);
        return new ResponseEntity<>("Clothe successfully reviewed!", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Review>> getAllReviewsByClotheId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(reviewService.getListByClotheId(id), HttpStatus.OK);
    }
}
