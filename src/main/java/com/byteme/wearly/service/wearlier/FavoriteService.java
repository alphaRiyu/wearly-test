package com.byteme.wearly.service.wearlier;

import com.byteme.wearly.model.wearlier.Favorite;
import com.byteme.wearly.repo.wearlier.FavoriteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 *
 * @project wearly
 * @created Feb 18, 2022 3:44 PM
 */

@Service
@RequiredArgsConstructor
public class FavoriteService {

    private final FavoriteRepo favoriteRepo;

    @Transactional
    public void create(Long userId, Long clotheId) {
        favoriteRepo.addClotheToFavorite(userId, clotheId);
    }

    public List<Favorite> getList(Long userId) {
        return favoriteRepo.findAllByUserId(userId, Sort.by("createdAt"));
    }

    public void delete(Long userId, Long clotheId) {
        favoriteRepo.deleteFavoriteClothe(userId, clotheId);
    }
}
