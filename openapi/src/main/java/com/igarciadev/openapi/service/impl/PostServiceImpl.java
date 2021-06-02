package com.igarciadev.openapi.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.igarciadev.openapi.entity.Post;
import com.igarciadev.openapi.repository.PostRepository;
import com.igarciadev.openapi.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService
{
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void remove(Long id)
    {
        postRepository.deleteById(id);
    }

    @Override
    public List<Post> select()
    {
        return postRepository.findAll();
    }

    @Override
    public Post select(Long id)
    {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public Post update(Long id, Post postModel)
    {
        Post post = select(id);
        postModel.setId(post.getId());

        return postRepository.save(postModel);
    }

    @Override
    public List<Post> saveAll(List<Post> postModels)
    {
        return postRepository.saveAll(postModels);
    }
}
