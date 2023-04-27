package com.tddninja.todo.application.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Status {

    TODO(1),
    DOING(2),
    DONE(3);

    private final int value;
}
