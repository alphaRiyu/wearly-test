package com.byteme.wearly.repo;

import com.byteme.wearly.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 17, 2022 10:11 AM
 */

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {

    Optional<Address> findByUserId(Long userId);

}
