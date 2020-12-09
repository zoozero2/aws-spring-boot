package com.awsspringboot.zoo.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostsRepository postRepository;

    @After // 단위테스트가 끝날때
    public void cleanup() {
        postRepository.deleteAll();
    }

    @Test
    public void loadSavingBoard() {
        //given
        String title = "테스트게시물";
        String content = "테스트게시물 본문";

        postRepository.save(Posts.builder()
                            .title(title)
                            .content(content)
                            .author("zoozero2")
                            .build());

        //when
        List<Posts> postsList = postRepository.findAll(); // 전체조회

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
