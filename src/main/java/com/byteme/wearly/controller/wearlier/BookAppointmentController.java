package com.byteme.wearly.controller.wearlier;

import com.byteme.wearly.model.wearlier.BookAppointment;
import com.byteme.wearly.service.wearlier.BookAppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 25, 2022 1:20 PM
 */

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookAppointmentController {

    private final BookAppointmentService bookAppointmentService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> bookAnAppointment(@RequestBody BookAppointment bookAppointment) {
        bookAppointmentService.create(bookAppointment);
        return new ResponseEntity<>("Booking appointment submitted.", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookAppointment> getBookAppointmentByClotheId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(bookAppointmentService.getClotheById(id), HttpStatus.OK);
    }

    @GetMapping("/receiver/{id}")
    public ResponseEntity<List<BookAppointment>> getAllBookAppointmentByReceiverId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(bookAppointmentService.getList(id), HttpStatus.OK);
    }
}
