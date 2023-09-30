package com.example.demo.json;

public class Greeting {
    private String message;

    public Greeting() {
        this("Hello world!");
    }

    public Greeting(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Greeting [message=" + message + "]";
    }
}
