package ua.opnu;

public class Student extends Person {
    private String group;
    private String studentID;

    public Student(String lastName, String firstName, int age, String group, String studentID) {
        super(lastName, firstName, age);
        this.group = group;
        this.studentID = studentID;
    }

    public String getGroup() { return group; }
    public void setGroup(String group) { this.group = group; }

    public String getStudentID() { return studentID; }
    public void setStudentID(String studentID) { this.studentID = studentID; }

    @Override
    public String toString() {
        return "Студент групи " + group + ", " + getLastName() + " " + getFirstName() +
                ", вік: " + getAge() + ". Номер студентського квитка: " + studentID;
    }
}