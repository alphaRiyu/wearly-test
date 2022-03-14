package com.byteme.wearly.repo.wearlier;

import com.byteme.wearly.model.wearlier.Favorite;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 18, 2022 3:42 PM
 */

@Repository
public interface FavoriteRepo extends JpaRepository<Favorite, Long> {

    @Modifying
    @Query(value = "INSERT INTO favorite(owner_user_id, added_clothe_id) VALUES (:userId, :clotheId)", nativeQuery = true)
    void addClotheToFavorite(@Param("userId") Long userId, @Param("clotheId") Long clotheId);
    List<Favorite> findAllByUserId(Long userId, Sort sort);
    @Modifying
    @Query(value = "DELETE " +
            "FROM favorite " +
            "WHERE owner_user_id = :userId " +
            "AND added_clothe_id = :clotheId", nativeQuery = true)
    void deleteFavoriteClothe(@Param("userId") Long userId, @Param("clotheId") Long clotheId);
}
