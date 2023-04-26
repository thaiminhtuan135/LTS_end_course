package com.example.end_course.controller;

import com.example.end_course.model.Topic;
import com.example.end_course.model.TypePost;
import com.example.end_course.service.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
@RequestMapping("admin/topic")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping("/list")
    public List<Topic> getTypePost() {
        return topicService.getTopics();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Topic> getbyId(@PathVariable Integer id) {
        try {
            Topic topic = topicService.getTopicById(id).get()   ;
            return new ResponseEntity<>(topic, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            Topic topic = topicService.getTopicById(id).get();
            topicService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
