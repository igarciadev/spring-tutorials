package com.igarciadev.openapi.service;

import com.igarciadev.openapi.entity.Post;

import java.util.List;

public interface PostService
{
    void remove(Long id);

    List<Post> select();

    Post select(Long id);

    Post update(Long id, Post postModel);

    List<Post> saveAll(List<Post> postModels);
}
