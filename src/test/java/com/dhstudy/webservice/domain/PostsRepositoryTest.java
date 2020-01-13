package com.dhstudy.webservice.domain;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup(){
        // 이후 테스트 코드에 영향을 끼치지 않기 위해
        // 테스트 메소드가 끝날때 마다 repository 전체 비우는 코드
        
        postsRepository.deleteAll();        
    }


	@Test
	void 게시글저장_불러오기() {

        //given
        postsRepository.save(Posts.builder()
        .title("테스트 게시글")
        .content("테스트 본문")
        .author("jojoldu@gmail.com")
        .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("테스트 게시글"));
        assertThat(posts.getContent(), is("테스트 본문"));

    }
    
    @Test
    public void BaseTimeEntity_등록(){
        //given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder().title("테스트 게시글").content("테스트 본문").author("jojodu@gmail.com").build());

        //when
        List<Posts> postList = postsRepository.findAll();

        //then
        Posts posts = postList.get(0);
        assertTrue(posts.getCreateDate().isAfter(now));
        assertTrue(posts.getModifieDate().isAfter(now));

    }

}
