package com.awsspringboot.zoo.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity  // 테이블과 링크될 클래스
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성규칙, IDENTITY 옵션 지정되어야 auto increment 됨
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }


    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
