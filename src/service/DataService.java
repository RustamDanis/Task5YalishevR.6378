package service;

import model.Student;
import model.Teacher;
import model.Type;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class DataService {

    private List<User> userList = new ArrayList<>();

    // Существующие методы...

    public Student getStudentById(int id) {
        for (User user : userList) {
            if (user instanceof Student) {
                Student student = (Student) user;
                if (student.getStudentId() == id) {
                    return student;
                }
            }
        }
        return null;
    }

    public Teacher getTeacherById(int id) {
        for (User user : userList) {
            if (user instanceof Teacher) {
                Teacher teacher = (Teacher) user;
                if (teacher.getTeacherId() == id) {
                    return teacher;
                }
            }
        }
        return null;
    }
}