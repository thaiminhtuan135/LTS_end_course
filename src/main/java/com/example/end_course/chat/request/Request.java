package com.example.end_course.chat.request;

import com.example.end_course.chat.Enum.Action;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@RequiredArgsConstructor
public abstract class Request implements Serializable {
    @NonNull
    protected Action action;
}