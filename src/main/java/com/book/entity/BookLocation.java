package com.book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * @CreateBy: SeongTae
 * @Date: 2023/09/12
 */
@ToString
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@Getter
@Entity
public class BookLocation extends BaseTimeEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long booklocationId;

    @Column (nullable = false)
    private String categoryName;

    @Column (nullable = false)
    private String locationCode;

    @Builder
    public BookLocation ( String categoryName, String locationCode ) {
        this.categoryName = categoryName;
        this.locationCode = locationCode;
    }

    public String getLocationInfo () {
        return categoryName + " - " + locationCode;
    }

}