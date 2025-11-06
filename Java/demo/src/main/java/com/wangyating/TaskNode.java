package com.wangyating;

public class TaskNode {
    int id;
    String description;
    TaskNode next;
    TaskNode prev;

    public TaskNode(int id, String description) {
        this.id = id;
        this.description = description;
    }

}
