import javax.script.ScriptEngine;
import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private int courseID;
    private Instructor instructor;
    private List<Student> enrolledStudents;
    private int credits;
    public Course(String courseName, int courseID, Instructor instructor) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.instructor = instructor;
        this.enrolledStudents = new ArrayList<Student>();
        this.credits= credits;
    }
    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            System.out.println(student.getName() + " has been enrolled in " + courseName );
        }
        else {
            System.out.println(student.getName() + " is already been enrolled in " + courseName );
        }
    }
        public void dispalyCourseDetails() {
            System.out.println("Course Id: " + courseID + "Course Name: " + courseName + "Credits: " + credits);
            System.out.println("Instructor Name: " + instructor.getName() + instructor.getDepartment() + "\n");
            System.out.println("Enrolled Students: ");
            if (enrolledStudents.isEmpty()) {
                System.out.println("No students enrolled");
            }
            else {
                for (Student student : enrolledStudents) {
                    student.displayDetails();
                }
            }
        }
        public int getCredits() {
            return credits;
        }
        public String getCourseName() {
            return courseName;
        }
        public int getCourseID() {
            return courseID;
        }
}
