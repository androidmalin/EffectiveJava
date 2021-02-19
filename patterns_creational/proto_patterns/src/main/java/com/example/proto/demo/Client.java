package com.example.proto.demo;

public class Client {
    public static void main(String[] args) {

        ExamPaper examPaper = new ExamPaper();
        System.out.println(examPaper);

//        ExamPaper examPaper2 = (ExamPaper) BeanUtils.copy(new ExamPaper());
//        System.out.println(examPaper2);
    }
}
