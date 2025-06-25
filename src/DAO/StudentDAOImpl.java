package DAO;

import exception.StudentNotFoundException;
import Model.Student;
import Connection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDAOImpl implements StudentDAO  {

    public void registerStudent(Student student) {
        String query = "INSERT INTO Student (FirstName,Lastname,DateOfBirth,Gender,Email,Phone,Course,EnrollmentID) VAlUES(?,?,?,?,?,?,?,?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1,student.getFirstName());
            ps.setString(2,student.getLastName());
            ps.setString(3, student.getDateOfBirth());
            ps.setString(4,student.getGender());
            ps.setString(5, student.getEmail());
            ps.setString(6, student.getPhone());
            ps.setString(7,student.getCourse());
            ps.setString(8, student.getEnrollmentID());

            ps.executeUpdate();
        }
        catch (SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudent(Student student) {
        String query = "UPDATE Student SET FirstName=?,Lastname=?,DateOfBirth=?,Gender=?,Email=?,Phone=?,Course=?,EnrollmentID=? WHERE StudentID = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1,student.getFirstName());
            ps.setString(2,student.getLastName());
            ps.setString(3, student.getDateOfBirth());
            ps.setString(4,student.getGender());
            ps.setString(5, student.getEmail());
            ps.setString(6, student.getPhone());
            ps.setString(7,student.getCourse());
            ps.setString(8, student.getEnrollmentID());
            ps.setInt(9, student.getStudentID());


            int rows = ps.executeUpdate();
           if(rows==0) throw new StudentNotFoundException("Student not found to update");
        }
        catch (SQLException |ClassNotFoundException| StudentNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(int StudentID) {
        String query = "DELETE FROM Student WHERE StudentID=?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, StudentID);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    @Override
    public Student getStudentByID(int StudentID) throws StudentNotFoundException {
        String query = "SELECT * FROM Student WHERE StudentID=?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1,StudentID);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return new Student( rs.getInt("StudentID"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("DateOfBirth"),
                        rs.getString("Gender"),
                        rs.getString("Email"),
                        rs.getString("Phone"),
                        rs.getString("Course"),
                        rs.getString("EnrollmentID")
                );
            }
            else {
                throw new StudentNotFoundException("No Student Found");
            }

        }
        catch (SQLException |ClassNotFoundException e){
            e.printStackTrace();
            throw  new StudentNotFoundException("Database error");
        }

    }


    @Override
    public List<Student> getAllStudent() {
        List<Student> list = new ArrayList<>();
        String query = "SELECT * FROM Student";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()){
                list.add(new Student(
                        rs.getInt("StudentID"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("DateOfBirth"),
                        rs.getString("Gender"),
                        rs.getString("Email"),
                        rs.getString("Phone"),
                        rs.getString("Course"),
                        rs.getString("EnrollmentID")
                ));
            }
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return list;
    }
}

