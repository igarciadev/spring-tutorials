package com.igarciadev.openapi.domain.mapper;

import com.igarciadev.openapi.domain.PostDto;
import com.igarciadev.openapi.entity.Post;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper
{
    PostDto postToPostModel(Post post);

    Post postModelToPost(PostDto postDto);

    List<PostDto> postToPostModel(List<Post> post);

    List<Post> postModelToPost(List<PostDto> postDtos);
}
