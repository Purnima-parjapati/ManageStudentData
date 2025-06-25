package Service;

import DAO.StudentDAO;
import DAO.StudentDAOImpl;
import exception.StudentNotFoundException;
import Model.Student;

import java.util.List;

public class StudentService {
    private final StudentDAO studentDAO;

    public StudentService() {
        this.studentDAO = new StudentDAOImpl();
    }

    public void registerStudent(Student student) {
        studentDAO.registerStudent(student);
    }

    public void updateStudent(Student student) throws StudentNotFoundException {
        studentDAO.updateStudent(student);
    }

    public void deleteStudent(int StudentID) throws StudentNotFoundException {
        studentDAO.deleteStudent(StudentID);
    }

    public Student getStudentByID(int StudentId) throws StudentNotFoundException {
        return studentDAO.getStudentByID(StudentId);
    }

    public List<Student> getAllStudent() {
        return studentDAO.getAllStudent();
    }
}

