package com.byteme.wearly.repo.wearlier;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 13, 2022 7:12 PM
 */

import com.byteme.wearly.model.wearlier.Wearlier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WearlierRepo extends JpaRepository<Wearlier, Long> {

    Optional<Wearlier> findWearlierByEmail(String email);

}
