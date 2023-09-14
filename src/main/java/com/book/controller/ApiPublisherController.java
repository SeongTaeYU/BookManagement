package com.book.controller;

import com.book.dto.request.PublisherSaveRequest;
import com.book.service.ApiPublisherService;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * [ 구현 기능 ] - 신규 등록 (구현) - 출판사 정보 수정 - 출판사 정보 조회 - 등록 해제
 *
/**
 * @CreateBy: SeongTae
 * @Date: 2023/09/14
 */

@Slf4j
@RequestMapping ("/api/publisher")
@RequiredArgsConstructor
@RestController
public class ApiPublisherController {

    private final ApiPublisherService publisherService;

    @PostMapping
    public ResponseEntity<Void> saveNewPublisher ( @RequestBody PublisherSaveRequest request ) {
        publisherService.saveNewPublisher(request);
        return ResponseEntity.created(URI.create("/api/publisher")).build();
    }

    @PutMapping("/{publisherId}")
    public ResponseEntity<Void> terminatePublisher ( @PathVariable Long publisherId ) {
        publisherService.terminatePublisher(publisherId);
        return ResponseEntity.ok().build();
    }
}
