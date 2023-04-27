package com.example.end_course.chat.response;

import com.example.end_course.chat.Enum.StatusCode;
import lombok.Getter;

import java.util.List;

@Getter
public class UserOnlineResponse extends Response{
    private List<String> userIds;

    public UserOnlineResponse(List<String> userIds , StatusCode statusCode) {
        this.userIds = userIds;
        this.statusCode = statusCode;
    }
}
