package com.example.woorimaeul.upload;

public class Board {
    String title;
    String article;

    Board(){}

    Board(String title, String article){
        this.title = title;
        this.article = article;
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

}
