package com.example.end_course.service.post;

import com.example.end_course.model.Post;
import com.example.end_course.model.TypePost;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Post save(Post post);

    Optional<Post> getPostById(int id);

    void delete(int id);

    List<Post> getPosts();
}
