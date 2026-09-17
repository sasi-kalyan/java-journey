package com.task.tracker.app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

/*
    Entity - Used to create the task object when requires
 */
public class Task {
    private Long id;
    private String taskDesc;
    private TaskStatus status;
    private String createdAt;
    private String updatedAt;
}
