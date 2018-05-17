package cn.timebusker.entity;

import java.io.Serializable;

/**
 * Demo Entity
 */
public class DemoInfo implements Serializable {

    private static final long serialVersionUID = 1;

    private String id;

    private String name;

    // 描述
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
