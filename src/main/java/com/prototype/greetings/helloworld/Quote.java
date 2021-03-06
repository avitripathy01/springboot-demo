package com.prototype.greetings.helloworld;

public class Quote {
    private String type ;
    private Value value;

    public Quote(String type, Value value){
        this.type = type;
        this.value = value;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
