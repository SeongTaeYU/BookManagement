package com.book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.book.enumclass.status.UserStatus;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @CreateBy: SeongTae
 * @Date: 2023/09/12
 */
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long userId;

    @NonNull
    @Column (nullable = false)
    private String email;

    @NonNull
    @Column (nullable = false)
    private String password;

    @NonNull
    @Column (nullable = false)
    private String phoneNumber;

    @Column (nullable = false)
    private int totalRentalBookCount;

    @Enumerated (value = EnumType.STRING)
    private UserStatus userStatus;

    @Builder
    public User ( @NonNull String email, @NonNull String password, @NonNull String phoneNumber) {
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.totalRentalBookCount = 0;
        this.userStatus = UserStatus.REGISTER;
    }

    /**
     * 도서 등록 시 대여 카운트를 증가 시킨다.
     */
    public void increaseBookRentalCount () {
        this.totalRentalBookCount += 1;
    }

}