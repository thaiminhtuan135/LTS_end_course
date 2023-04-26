package com.example.end_course.controller;

import com.example.end_course.model.TypeCourse;
import com.example.end_course.model.TypePost;
import com.example.end_course.service.typePost.TypePostService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
@RequestMapping("/admin/type-post")
public class TypePostController {
    @Autowired
    private TypePostService typePostService;
    private final Gson gson = new Gson();
    @GetMapping("/list")
    public List<TypePost> getTypePost() {
        return typePostService.getTypePosts();
    }

    @PostMapping("/create")
    public ResponseEntity<TypePost> create(@RequestBody String typePost) {

        try {
            TypePost typePost1 = gson.fromJson(typePost, TypePost.class);
            return new ResponseEntity<>(typePostService.save(typePost1), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<TypePost> update(@RequestBody String typePost, @PathVariable Integer id) {

        return typePostService.getTypePostById(id).map(typePost1 -> {
            TypePost typeCourse2 = gson.fromJson(typePost, TypePost.class);
            typeCourse2.setId(typePost1.getId());
            return new ResponseEntity<>(typePostService.save(typeCourse2), HttpStatus.OK);

        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypePost> getbyId(@PathVariable Integer id) {
        try {
            TypePost typePost = typePostService.getTypePostById(id).get()   ;
            return new ResponseEntity<>(typePost,HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            TypePost typePost = typePostService.getTypePostById(id).get();
            typePostService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
