package com.example.pokedex.model;

import java.util.List;

public class Pokemon{
    private String num;
    private String name;
    private String img;
    private List<String> type;
    private String heigth;
    private String weigth;
    private List<String> weaknesses;

    public Pokemon(String num, String name, String img, List<String> type, String heigth, String weigth, List<String> weaknesses) {
        this.num = num;
        this.name = name;
        this.img = img;
        this.type = type;
        this.heigth = heigth;
        this.weigth = weigth;
        this.weaknesses = weaknesses;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public String getHeigth() {
        return heigth;
    }

    public void setHeigth(String heigth) {
        this.heigth = heigth;
    }

    public String getWeigth() {
        return weigth;
    }

    public void setWeigth(String weigth) {
        this.weigth = weigth;
    }

    public List<String> getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(List<String> weaknesses) {
        this.weaknesses = weaknesses;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", type=" + type +
                ", heigth='" + heigth + '\'' +
                ", weigth='" + weigth + '\'' +
                ", weaknesses=" + weaknesses +
                '}';
    }
}