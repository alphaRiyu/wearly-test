package com.byteme.wearly.repo.wearlier;

import com.byteme.wearly.model.wearlier.BookAppointment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 25, 2022 1:15 PM
 */

@Repository
public interface BookAppointmentRepo extends JpaRepository<BookAppointment, Long> {

    BookAppointment findByCustomizeId(Long clotheId);
    List<BookAppointment> findAllByReceiverId(@Param("id") Long id, Sort sort);

}
