package com.example.testproducer.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

public class Request {

    String id;

    @NotNull
    @Min(30)
    String userId;
    @NotNull
    @Size(min=1, max=250)
    String request;
    @NotNull
    @Size(min=1)
    ArrayList<String> tags;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(50);
        builder.append("{");
        builder.append("'_id': '");builder.append(getId());builder.append("',");
        builder.append("'userId': '");builder.append(getUserId());builder.append("',");
        builder.append("'request': '");builder.append(getRequest());builder.append("',");
        builder.append("'tags': [");
        for (String tag: tags) {
            builder.append("'");builder.append(tag);builder.append("',");
        }
        builder.delete(builder.length() - 1, builder.length());
        builder.append("]}");
        return builder.toString();
    }
}
