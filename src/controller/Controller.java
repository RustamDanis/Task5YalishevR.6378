package controller;

import model.Student;
import model.StudyGroup;
import model.Teacher;
import model.Type;
import model.User;
import service.DataService;
import service.StudyGroupService;
import view.StudentView;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final DataService service = new DataService();
    private final StudentView view = new StudentView();

    // Существующие методы...

    public void createTeacher(String firstName, String lastName, String middleName) {
        service.create(firstName, lastName, middleName, Type.TEACHER);
    }

    public StudyGroup createStudyGroup(int teacherId, List<Integer> studentIds) {
        Teacher teacher = service.getTeacherById(teacherId);
        List<Student> students = new ArrayList<>();
        for (int studentId : studentIds) {
            Student student = service.getStudentById(studentId);
            if (student != null) {
                students.add(student);
            }
        }
        if (teacher != null && !students.isEmpty()) {
            StudyGroupService studyGroupService = new StudyGroupService();
            StudyGroup studyGroup = studyGroupService.createStudyGroup(teacher, students);
            return studyGroup;
        } else {
            System.out.println("Ошибка при создании учебной группы: преподаватель или студенты не найдены.");
            return null;
        }
    }
}