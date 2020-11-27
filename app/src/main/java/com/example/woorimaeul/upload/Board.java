package com.example.woorimaeul.upload;

public class Board {
    String title;
    String article;
    String userId;

    Board(){}

    Board(String title, String article, String userId){
        this.title = title;
        this.article = article;
        this.userId = userId;
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


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
