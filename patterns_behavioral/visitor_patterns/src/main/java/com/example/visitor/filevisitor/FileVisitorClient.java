package com.example.visitor.filevisitor;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;


public class FileVisitorClient {
    public static void main(String[] args) {
        try {
            // 使用FileVisitor对目录进行遍历
            Files.walkFileTree(
                    Paths.get("/Users/", "xxx/xxx/xxx/xxx/xxx/xxx"),
                    new SFileVisitor()
            );
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private static class SFileVisitor extends SimpleFileVisitor<Path> {
        /**
         * 在访问子目录前触发该方法
         */
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
            System.out.println("正在访问" + dir + "目录");
            return FileVisitResult.CONTINUE;
        }

        /**
         * 在访问文件时触发该方法
         */
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println("正在访问" + file + "文件");
            if (file.endsWith("gradle-wrapper.properties")) {
                System.out.println("------gradle-wrapper.properties,文件内容-----");
                List<String> list = Files.readAllLines(file);
                // 打印出文件的内容
                System.out.println(list);
                return FileVisitResult.TERMINATE;
            }
            return FileVisitResult.CONTINUE;
        }

        /**
         * 在访问失败时触发该方法
         */
        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            // 写一些具体的业务逻辑
            return super.visitFileFailed(file, exc);
        }

        /**
         * 在访问目录之后触发该方法
         */
        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            // 写一些具体的业务逻辑
            return super.postVisitDirectory(dir, exc);
        }
    }
}
