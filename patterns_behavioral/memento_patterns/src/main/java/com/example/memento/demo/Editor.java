package com.example.memento.demo;


public class Editor {

    private String title;
    private String content;
    private String img;

    public Editor(String title, String content, String img) {
        this.title = title;
        this.content = content;
        this.img = img;
    }

    public ArticleMemento saveToMemento() {
        return new ArticleMemento(this.title, this.content, this.img);
    }

    public void undoFromMemento(ArticleMemento articleMemento) {
        this.title = articleMemento.getTitle();
        this.content = articleMemento.getContent();
        this.img = articleMemento.getImgs();
    }


    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImg() {
        return img;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", imgs='" + img + '\'' +
                '}';
    }
}
