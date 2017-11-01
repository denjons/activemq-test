package com.example.testproducer.model;

public class Request {
    String id;
    String request;

    public Request() {
    }

    public Request(String id, String request) {
        this.id = id;
        this.request = request;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(50);
        builder.append("{");
        builder.append("'_id': '");builder.append(getId());builder.append("',");
        builder.append("'request': '");builder.append(getRequest());builder.append("'");
        builder.append("}");
        return builder.toString();
    }
}
