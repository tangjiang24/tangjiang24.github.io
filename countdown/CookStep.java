package com.tj24.demo.countdown;

import java.io.Serializable;

public class CookStep implements Serializable {
    private String id;
    private String photoUrl;
    private String content;

    public CookStep() {
    }

    public CookStep(String id, String photoUrl, String content) {
        this.id = id;
        this.photoUrl = photoUrl;
        this.content = content;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
