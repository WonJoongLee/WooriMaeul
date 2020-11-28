package com.example.woorimaeul.upload;

public class Board {
    String title;
    String article;
    String name;

    Board(){}

    Board(String title, String article, String name){
        this.title = title;
        this.article = article;
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
