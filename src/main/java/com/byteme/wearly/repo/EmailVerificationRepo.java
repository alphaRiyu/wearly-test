package com.byteme.wearly.repo;

import com.byteme.wearly.model.EmailVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Mar 08, 2022 12:11 PM
 */

@Repository
public interface EmailVerificationRepo extends JpaRepository<EmailVerification, Long> {

    EmailVerification findByUserIdAndCode(Long id, int verificationCode);
    void deleteByUserId(Long id);

}
