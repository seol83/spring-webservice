package com.dhstudy.webservice.service;

import com.dhstudy.webservice.domain.PostsRepository;
import com.dhstudy.webservice.dto.posts.PostsSaveRequestDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }
}