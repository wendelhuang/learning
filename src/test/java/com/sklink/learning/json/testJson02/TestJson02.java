package com.sklink.learning.json.testJson02;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class Person {
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
public class TestJson02 {
    @Test
    public void test() {
        List<Person> list = new ArrayList<>();
        Person person = new Person("zhangsan", 20);
        list.add(person);
        list.add(person);
        System.out.println(list.size());

        list.get(0).setName("lisi");
        System.out.println(list.get(1).getName());

        System.out.println(JSON.toJSONString(list));
        System.out.println(JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect));
    }
}
