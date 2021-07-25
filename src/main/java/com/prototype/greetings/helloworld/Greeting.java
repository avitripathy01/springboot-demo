package com.prototype.greetings.helloworld;

public class Greeting {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private  String content;

    public Greeting(int id, String content){
        this.id = id;
        this.content = content;
    }


}
