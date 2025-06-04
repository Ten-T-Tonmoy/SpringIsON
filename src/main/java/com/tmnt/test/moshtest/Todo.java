package com.tmnt.test.moshtest;

public class Todo {
    private Long id;
    private String task;
    private boolean isDone;

    public Todo(Long id,String task,boolean isDone){
        this.id=id;
        this.task=task;
        this.isDone=isDone;

    }

    public String getTask() {
        return task;
    }

    public Long getId(){
        return id;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
