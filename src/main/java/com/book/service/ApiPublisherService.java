package com.book.service;

import com.book.dto.request.PublisherSaveRequest;
import com.book.exception.AlreadyExistPublisherException;
import com.book.exception.PublisherNotFoundException;
import com.book.entity.Publisher;
import com.book.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @CreateBy: SeongTae
 * @Date: 2023/09/14
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ApiPublisherService {

    private final PublisherRepository publisherRepository;

    @Transactional
    public Publisher saveNewPublisher ( PublisherSaveRequest request ) {
        String businessNumber = request.getBusinessNumber();
        isDuplicatedBusinessNumber(businessNumber);
        return publisherRepository.save(request.toEntity());
    }

    @Transactional
    public void terminatePublisher ( Long publisherId ) {
        findPublisherById(publisherId).terminate();
    }

    private void isDuplicatedBusinessNumber ( String businessNumber ) {
        if ( publisherRepository.findByBusinessNumber(businessNumber).isPresent() ) {
            throw new AlreadyExistPublisherException(businessNumber);
        }
    }

    private Publisher findPublisherById ( Long publisherId ) {
        return publisherRepository.findById(publisherId)
            .orElseThrow(PublisherNotFoundException::new);
    }
}
