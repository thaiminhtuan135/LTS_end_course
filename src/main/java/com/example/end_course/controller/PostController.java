package com.example.end_course.controller;

import com.example.end_course.model.Post;
import com.example.end_course.model.Topic;
import com.example.end_course.service.post.PostService;
import com.example.end_course.service.topic.TopicService;
import com.example.end_course.util.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
@RequestMapping("/admin/post")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private TopicService topicService;
    private final com.google.gson.Gson gson = Gson.gson();

    @GetMapping("/list")
    public List<Post> getTypePost() {
        return postService.getPosts();
    }

    @PostMapping("/create/topic/{topicId}")
    private ResponseEntity<?> create(@RequestBody String post ,
                                         @PathVariable Integer topicId) {
        return topicService.getTopicById(topicId).map(topic -> {
            Post post1 = gson.fromJson(post, Post.class);
            post1.setTopic(topic);
            post1.setTopic_id(topic.getId());
            return new ResponseEntity<>(postService.save(post1), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{postId}/edit/topic/{topicId}")
    public ResponseEntity<?> update(@RequestBody String dataUpdate,
                                    @PathVariable Integer postId,
                                    @PathVariable Integer topicId) {
        return postService.getPostById(postId).map(post -> {
            try {
                Topic topic = topicService.getTopicById(topicId).get();
                Post post1 = gson.fromJson(dataUpdate, Post.class);
                post1.setId(post.getId());
                post1.setTopic(topic);
                post1.setTopic_id(topic.getId());
                return new ResponseEntity<>(postService.save(post1), HttpStatus.OK);
            } catch (NoSuchElementException e) {
                return new ResponseEntity<>("Topic post not found",HttpStatus.NOT_FOUND);
            }
        }).orElseGet(() -> new ResponseEntity<>("Post not found",HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getbyId(@PathVariable Integer id) {
        try {
            Post post = postService.getPostById(id).get();
            return new ResponseEntity<>(post, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Post not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            Post post = postService.getPostById(id).get();
            postService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Post not found", HttpStatus.NOT_FOUND);
        }
    }
}
