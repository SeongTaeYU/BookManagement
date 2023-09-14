package com.book.service;

import com.book.dto.request.CategorySaveRequest;
import com.book.exception.AlreadyExistCategoryException;
import com.book.entity.Category;
import com.book.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @CreateBy: Bloo
 * @Date: 2021/05/09
 */

@RequiredArgsConstructor
@Service
public class ApiCategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    public Category saveNewCategory ( CategorySaveRequest request ) {
        String categoryName = request.getCategoryName();
        isDuplicatedName(categoryName);
        return categoryRepository.save(request.toEntity());
    }

    private void isDuplicatedName ( String categoryName ) {
        if ( categoryRepository.findByCategoryName(categoryName).isPresent() ) {
            throw new AlreadyExistCategoryException(categoryName);
        }
    }
}
