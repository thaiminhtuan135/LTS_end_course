package com.example.end_course.chat.request;

import com.example.end_course.chat.Enum.Action;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class InformationRequest extends Request {

    @Builder
    public InformationRequest(@NonNull Action action) {
        super(action);
    }
}