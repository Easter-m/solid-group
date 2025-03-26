public class Student extends Person {
    private int StudentId;

    public Student(String name, String email) {
        super(name, email);
        this.StudentId = StudentId;
    }

    @Override
    public void displayDetails() {
        System.out.println("StudentId: " + StudentId + "Name: " + name + "Email: " + email);
    }
    public int getStudentId() {
        return StudentId;
    }
}
     class Instructor extends Person {
    private String department;

    public Instructor (String name, String email, String department) {
        super(name, email);
        this.department = department;
    }
    @Override
         public void displayDetails() {
            System.out.println("Instructor: " + name + "Email: " + email + "Department: " + department);
    }
        public String getDepartment() {
        return department;
        }
     }
