package com.example.iterator.course;


public class Client {
    public static void main(String[] args) {
        Course java = new Course("Java架构");
        Course javaBase = new Course("Java基础");
        Course design = new Course("设计模式");
        Course ai = new Course("人工智能");

        ICourseAggregate<Course> aggregate = new CourseAggregateImpl<>();
        aggregate.add(java);
        aggregate.add(javaBase);
        aggregate.add(design);
        aggregate.add(ai);

        System.out.println("===========课程列表==========");
        printCourse(aggregate);

        aggregate.remove(ai);

        System.out.println("===========删除操作之后的课程列表==========");
        printCourse(aggregate);
    }

    private static void printCourse(ICourseAggregate<Course> aggregate) {
        Iterator<Course> iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            Course course = iterator.next();
            System.out.println(course.getName());
        }
    }
}
