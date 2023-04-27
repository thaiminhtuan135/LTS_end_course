package com.example.end_course.chat.response;

import com.example.end_course.chat.Enum.StatusCode;
import lombok.Getter;

import java.io.Serializable;

@Getter
public abstract class Response implements Serializable {
    protected StatusCode statusCode;
}
