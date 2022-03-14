package com.byteme.wearly.service.wearlier;

import com.byteme.wearly.model.wearlier.BookAppointment;
import com.byteme.wearly.repo.wearlier.BookAppointmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 25, 2022 1:16 PM
 */

@Service
@RequiredArgsConstructor
public class BookAppointmentService {

    private final BookAppointmentRepo bookAppointmentRepo;

    public BookAppointment create(BookAppointment bookAppointment) {
        return bookAppointmentRepo.save(bookAppointment);
    }

    public BookAppointment getClotheById(Long clotheId) {
        return bookAppointmentRepo.findByCustomizeId(clotheId);
    }

    public List<BookAppointment> getList(Long id) {
        return bookAppointmentRepo.findAllByReceiverId(id, Sort.by("createdAt"));
    }
}
