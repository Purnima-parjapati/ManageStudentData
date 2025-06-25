package DAO;

import Model.Student;
import exception.StudentNotFoundException;
import java.util.List;

public interface StudentDAO {
    void  registerStudent(Student student);
    Student getStudentByID(int StudentID) throws StudentNotFoundException;
    void updateStudent(Student student);
    void deleteStudent(int StudentID);
    List<Student> getAllStudent();

}
