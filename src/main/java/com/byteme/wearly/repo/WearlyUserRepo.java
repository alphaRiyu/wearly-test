package com.byteme.wearly.repo;

import com.byteme.wearly.model.WearlyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 14, 2022 12:49 PM
 */

@Repository
public interface WearlyUserRepo extends JpaRepository<WearlyUser, Long> {
}
