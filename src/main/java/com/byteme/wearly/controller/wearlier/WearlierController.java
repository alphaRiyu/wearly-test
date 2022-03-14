package com.byteme.wearly.controller.wearlier;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 13, 2022 7:19 PM
 */

import com.byteme.wearly.model.WearlyUser;
import com.byteme.wearly.model.wearlier.Wearlier;
import com.byteme.wearly.service.wearlier.WearlierService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/wearlier")
@RequiredArgsConstructor
public class WearlierController {
    private final WearlierService wearlierService;

    // TODO: 2/24/2022 handle exception
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Wearlier> createWearlier(@RequestBody Wearlier wearlier) {
        return new ResponseEntity<>(wearlierService.create(wearlier), HttpStatus.CREATED);
    }

    // TODO: 2/24/2022 handle exception
    @PostMapping("/profile")
    public ResponseEntity<String> uploadProfileImage(@RequestParam("id") Long id, @RequestParam("file") MultipartFile file) throws IOException {
        wearlierService.createProfileImage(id, file);
        return new ResponseEntity<>("Image uploaded", HttpStatus.CREATED);
    }

    @GetMapping(value = "/image/{id}/{filename}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> loadProfileImage(@PathVariable("id") Long id, @PathVariable("filename") String filename) throws IOException {
        FileSystemResource fileSystemResource = new FileSystemResource("src/main/resources/images/profile/" + id + "/" + filename);
        InputStream inputStream = fileSystemResource.getInputStream();
        return new ResponseEntity<>(IOUtils.toByteArray(inputStream), HttpStatus.OK);
    }

    @Transactional
    @GetMapping("/verify/{id}/{code}")
    public ResponseEntity<String> verifyEmail(@PathVariable("id") Long id, @PathVariable("code") int code) {
        String message = "Invalid code, try again.";
        if (wearlierService.isVerified(id, code)) {
            message = "Email successfully verified!";
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WearlyUser> getWearlierById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(wearlierService.getById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WearlyUser> loginUser(@RequestBody WearlyUser wearlyUser) {
        return new ResponseEntity<>(wearlierService.loginUser(wearlyUser.getEmail(), wearlyUser.getPassword()), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Wearlier>> getAllWearlier() {
        return new ResponseEntity<>(wearlierService.getList(), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WearlyUser> updateWearlier(@PathVariable("id") Long id, @RequestBody Wearlier wearlier) {
        return new ResponseEntity<>(wearlierService.update(id, wearlier), HttpStatus.OK);
    }

    // only an authorized personnel can use this method
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWearlier(@PathVariable("id") Long id) {
        wearlierService.delete(id);
        return new ResponseEntity<>("Wearlier deleted.", HttpStatus.NO_CONTENT);
    }

}
