package com.example.memento.demo;


public class Client {
    public static void main(String[] args) {
        DraftsBox draftsBox = new DraftsBox();

        Editor editor = new Editor(
                "Java编程思想",
                "Java书籍",
                "img.png"
        );

        ArticleMemento articleMemento = editor.saveToMemento();
        draftsBox.addMemento(articleMemento);

        System.out.println("标题：" + editor.getTitle() + "\n" +
                "内容：" + editor.getContent() + "\n" +
                "插图：" + editor.getImg() + "\n暂存成功");

        System.out.println("完整的信息:" + editor);


        System.out.println("==========首次修改文章===========");
        editor.setTitle("Java编程思想1");
        editor.setContent("Java书籍1");
        System.out.println("==========首次修改文章完成===========");
        System.out.println("完整的信息" + editor);

        articleMemento = editor.saveToMemento();
        draftsBox.addMemento(articleMemento);
        System.out.println("==========保存到草稿箱===========");


        System.out.println("==========第2次修改文章===========");
        editor.setTitle("Java编程思想2");
        editor.setContent("Java书籍2");
        System.out.println("完整的信息" + editor);
        System.out.println("==========第2次修改文章完成===========");

        System.out.println("==========第1次撤销===========");
        articleMemento = draftsBox.getMemento();
        editor.undoFromMemento(articleMemento);
        System.out.println("完整的信息" + editor);
        System.out.println("==========第1次撤销完成===========");


        System.out.println("==========第2次撤销===========");
        articleMemento = draftsBox.getMemento();
        editor.undoFromMemento(articleMemento);
        System.out.println("完整的信息" + editor);
        System.out.println("==========第2次撤销完成===========");
    }
}
