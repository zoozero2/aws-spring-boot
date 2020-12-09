package com.awsspringboot.zoo.springboot.web;

import com.awsspringboot.zoo.springboot.service.posts.PostService;
import com.awsspringboot.zoo.springboot.web.dto.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostService postService;

    @PostMapping("api/v1/posts")
    public Long save(@RequestBody PostSaveRequestDto requestDto) {

        return postService.save(requestDto);
    }
}
