package com.prototype.greetings.helloworld;

public class Value {
    private String id;
    private String quote;

    public Value(String id, String quote){
        this.id = id;
        this.quote = quote;

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
