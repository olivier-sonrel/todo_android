package com.olivier.todo;

import java.io.Serializable;

public class Todo implements Serializable {
    private Long id;
    private String name;
    private String urgency;

    public Todo() {
    }

    public Todo(String name, String urgency) {
        this.name = name;
        this.urgency = urgency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", urgency='" + urgency + '\'' +
                '}';
    }
}
