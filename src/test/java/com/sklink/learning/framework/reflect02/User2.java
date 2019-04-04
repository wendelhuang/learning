package com.sklink.learning.framework.reflect02;

@Table("CBS_T_BOOK_KEEP")
public class User2 {
    private String name;
    private Integer age;

    public User2(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
