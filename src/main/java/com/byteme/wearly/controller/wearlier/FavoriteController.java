package com.byteme.wearly.controller.wearlier;

import com.byteme.wearly.model.wearlier.Favorite;
import com.byteme.wearly.service.wearlier.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 18, 2022 4:01 PM
 */

@RestController
@RequestMapping("/favorite")
@RequiredArgsConstructor
public class FavoriteController {

    private final FavoriteService favoriteService;

    @PostMapping("/{userId}/{clotheId}")
    public ResponseEntity<String> addClotheToFavorite(@PathVariable("userId") Long userId, @PathVariable("clotheId") Long clotheId) {
        favoriteService.create(userId, clotheId);
        return new ResponseEntity<>("Clothe added to favorites", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Favorite>> getAllFavorite(@PathVariable("id") Long userId) {
        return new ResponseEntity<>(favoriteService.getList(userId), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/{userId}/{clotheId}")
    public ResponseEntity<String> deleteFavoriteClothe(@PathVariable("userId") Long userId, @PathVariable("clotheId") Long clotheId) {
        favoriteService.delete(userId, clotheId);
        return new ResponseEntity<>("Deleted clothe from favorites.", HttpStatus.OK);
    }
}
