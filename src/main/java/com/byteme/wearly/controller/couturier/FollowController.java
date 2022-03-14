package com.byteme.wearly.controller.couturier;

import com.byteme.wearly.model.couturier.Follow;
import com.byteme.wearly.service.couturier.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 28, 2022 11:20 AM
 */

@RestController
@RequestMapping("/follow")
@RequiredArgsConstructor
public class FollowController {

    private final FollowService followService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Follow> followWearlyUser(@RequestBody Follow follow) {
        return new ResponseEntity<>(followService.create(follow), HttpStatus.CREATED);
    }

    @GetMapping("/followers/{id}")
    public ResponseEntity<List<Follow>> getAllFollowers(@PathVariable("id") Long id) {
        return new ResponseEntity<>(followService.getFollowerList(id), HttpStatus.OK);
    }

    @GetMapping("/following/{id}")
    public ResponseEntity<List<Follow>> getAllFollowing(@PathVariable("id") Long id) {
        return new ResponseEntity<>(followService.getFollowingList(id), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/{followerId}/{followingId}")
    public ResponseEntity<String> unfollowWearlyUser(@PathVariable("followerId") Long followerId,
                                                     @PathVariable("followingId") Long followingId) {
        followService.delete(followerId, followingId);
        return new ResponseEntity<>("Wearly user unfollowed!", HttpStatus.OK);
    }
}
