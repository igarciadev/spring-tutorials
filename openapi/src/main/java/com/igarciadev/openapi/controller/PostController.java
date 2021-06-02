package com.igarciadev.openapi.controller;

import com.igarciadev.openapi.domain.PostDto;
import com.igarciadev.openapi.domain.mapper.PostMapper;
import com.igarciadev.openapi.entity.Post;
import com.igarciadev.openapi.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostController implements PostsApiDelegate
{
    @Autowired
    private PostService postService;

    @Autowired
    private PostMapper postMapper;

    @Override
    public ResponseEntity<Void> deleteOnePostById(Long id)
    {
        postService.remove(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PostDto>> getAllPosts()
    {
        List<Post>    posts    = postService.select();
        List<PostDto> postDtos = postMapper.postToPostModel(posts);

        return new ResponseEntity<>(postDtos, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PostDto> getOnePostById(Long id)
    {
        Post    post    = postService.select(id);
        PostDto postDto = postMapper.postToPostModel(post);

        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PostDto>> postMultiplePosts(List<PostDto> entities)
    {
        List<Post>    posts    = postService.saveAll(postMapper.postModelToPost(entities));
        List<PostDto> postDtos = postMapper.postToPostModel(posts);

        return new ResponseEntity<>(postDtos, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PostDto> putOnePostById(Long id, PostDto entity)
    {
        Post    post    = postService.update(id, postMapper.postModelToPost(entity));
        PostDto postDto = postMapper.postToPostModel(post);

        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }
}
