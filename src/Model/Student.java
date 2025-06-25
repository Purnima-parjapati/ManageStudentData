package Model;

public class Student {
    private int StudentID;
    private String FirstName;
    private String LastName;
    private String DateOfBirth;
    private String Gender;
    private String Email;
    private String Phone;
    private String Course;
    private String EnrollmentID;

    public Student(int studentID, String firstName, String lastName, String dateOfBirth, String gender, String email, String phone, String course, String enrollmentID) {
        StudentID = studentID;
        FirstName = firstName;
        LastName = lastName;
        DateOfBirth = dateOfBirth;
        Gender = gender;
        Email = email;
        Phone = phone;
        Course = course;
        EnrollmentID = enrollmentID;
    }
    public Student() {
        // default constructor
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int studentID) {
        StudentID = studentID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public String getEnrollmentID() {
        return EnrollmentID;
    }

    public void setEnrollmentID(String enrollmentID) {
        EnrollmentID = enrollmentID;
    }

    public String toString() {
        return "Student{" +
                "studentID=" + StudentID +
                ", firstName='" + FirstName + '\'' +
                ", lastName='" + LastName + '\'' +
                ", dateOfBirth='" + DateOfBirth + '\'' +
                ", gender='" + Gender + '\'' +
                ", email='" + Email + '\'' +
                ", phone='" + Phone + '\'' +
                ", course='" + Course + '\'' +
                ", enrollmentID='" + EnrollmentID + '\'' +
                '}';
    }
}


