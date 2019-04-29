package com.yg.springjacksonunwrapped;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class SavedItem<Id, Info> {
    private Id id;
    @JsonUnwrapped
    private Info info;

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "SavedItem{" +
                "id=" + id +
                ", info=" + info +
                '}';
    }
}
