package com.byteme.wearly.service.wearlier;

import com.byteme.wearly.model.wearlier.Review;
import com.byteme.wearly.repo.wearlier.ReviewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 24, 2022 4:59 PM
 */

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepo reviewRepo;

    // TODO: 2/24/2022 validation required
    public Review create(Review review) {
        return reviewRepo.save(review);
    }

    public List<Review> getListByClotheId(Long id) {
        return reviewRepo.findAllByClotheId(id, Sort.by("dateReviewed"));
    }

    // TODO: 2/24/2022 update and delete method 
}
