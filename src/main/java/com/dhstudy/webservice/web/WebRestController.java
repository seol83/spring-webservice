package com.dhstudy.webservice.web;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import com.dhstudy.webservice.domain.PostsRepository;
import com.dhstudy.webservice.dto.posts.PostsSaveRequestDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postsRepository;

    @GetMapping(value="/hello")
    public String hello() {
        return "HelloWorld!";
    }

    @PostMapping(value="/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto) {
        postsRepository.save(dto.toEntity());
    }
    
}