package com.book.dto.request;

import com.book.entity.Category;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor (access = AccessLevel.PRIVATE)
@Getter
public class CategorySaveRequest {

    private String categoryCode;
    private String categoryName;

    @Builder
    public CategorySaveRequest ( String categoryCode, String categoryName ) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
    }

    public Category toEntity () {
        return Category.builder()
            .categoryCode(categoryCode)
            .categoryName(categoryName)
            .categoryStatus(CategoryStatus.REGISTER)
            .build();
    }
}
