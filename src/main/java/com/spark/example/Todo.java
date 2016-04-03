package com.spark.example;

/**
 * Created by bertanasco on 4/2/16.
 */
public class Todo {
    private String description;
    private boolean done;

    public String getDescription() {
        return description;
    }

    public Todo setDescription(final String description) {
        this.description = description;
        return this;
    }

    public boolean isDone() {
        return done;
    }

    public Todo setDone(final boolean done) {
        this.done = done;
        return this;
    }
}
