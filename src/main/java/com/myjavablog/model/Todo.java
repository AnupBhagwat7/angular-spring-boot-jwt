package com.myjavablog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@Builder
//@AllArgsConstructor
@NoArgsConstructor
public class Todo implements Serializable{

    private Long id;

    private String name;
    private String desc;
    private String status;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Todo(Long id, String name, String desc, String status) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.status = status;
    }
}
