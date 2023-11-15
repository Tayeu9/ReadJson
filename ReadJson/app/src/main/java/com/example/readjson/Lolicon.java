package com.example.readjson;

public class Lolicon {
    protected  String name;
    protected  String age;
    protected  String img;

    public Lolicon(String name, String age, String img) {
        this.name = name;
        this.age = age;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
