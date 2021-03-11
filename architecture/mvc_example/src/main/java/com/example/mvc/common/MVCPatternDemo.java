package com.example.mvc.common;


/**
 * Model 代表承载数据的对象或JAVA POJO。如果其数据发生更改，它也可以具有更新控制器的逻辑。
 * <p>
 * View 视图表示模型包含的数据的可视化。
 * <p>
 * Controller 控制器同时作用于模型和视图。
 * 它控制数据流入模型对象并在数据更改时更新视图。它使视图和模型分离。
 */
public class MVCPatternDemo {
    public static void main(String[] args) {

        //fetch student record based on his roll no from the database
        Student model = getStudentFromDatabase();

        //Create a view : to write student details on console
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        //update model data
        controller.setStudentName("John");

        controller.updateView();
    }

    private static Student getStudentFromDatabase() {
        Student student = new Student();
        student.setName("Robert");
        student.setRollNo("10");
        return student;
    }
}