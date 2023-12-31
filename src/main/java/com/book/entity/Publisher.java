package com.book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import org.hibernate.annotations.Where;

import com.book.enumclass.status.PublisherStatus;

/**
 * @CreateBy: SeongTae
 * @Date: 2023/09/13
 */

@Where(clause = "publisherStatus = REGISTER")
@ToString
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Publisher extends BaseTimeEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long publisherId;

    @NonNull
    @Column (nullable = false)
    private String businessNumber;

    @NonNull
    @Column (nullable = false)
    private String telNumber;               // 대표 전화번호

    @NonNull
    @Column (nullable = false)
    private String name;

    @NonNull
    @Column (nullable = false)
    private String address;

    @NonNull
    @Column (nullable = false)
    @Enumerated (value = EnumType.STRING)
    private PublisherStatus publisherStatus;

    @Builder
    public Publisher ( @NonNull String businessNumber, @NonNull String telNumber,
        @NonNull String name, @NonNull String address,
        @NonNull PublisherStatus publisherStatus ) {
        this.businessNumber = businessNumber;
        this.telNumber = telNumber;
        this.name = name;
        this.address = address;
        this.publisherStatus = publisherStatus;
    }

    public void terminate() {
        this.publisherStatus = PublisherStatus.UNREGISTER;
    }
}