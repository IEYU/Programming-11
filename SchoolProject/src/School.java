import java.util.ArrayList;

public class School {
    /*
    This class contains the information of the school object that is being constructed.
    It includes the School's name, the total number of students and the total number of teachers.
    It also store the information of students and teachers that are added to / removed from the school
     */

    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    //ArrayList<Course> courses = new ArrayList<>();
    private String name;    //name represents the name of the school that is being constructed
    private int total_student;  //total_student represents the total number of students in the school
    private int total_teacher;  //total_teacher represents the total number of teachers in the school

    //When a new school object is constructed, it contains information of the school name, the total number of students, and the total number of teachers
    School(String name, int total_student, int total_teacher){
        this.name = name;
        this.total_student = total_student;
        this.total_teacher = total_teacher;
    }

    //getters and setters of name, total_student, and total_teacher
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal_student() {
        return total_student;
    }

    public void setTotal_student(int total_student) {
        this.total_student = total_student;
    }

    public int getTotal_teacher() {
        return total_teacher;
    }

    public void setTotal_teacher(int total_teacher) {
        this.total_teacher = total_teacher;
    }

    //This is the method of adding a teacher to the teachers arraylist
    public void add_teacher(Teacher teacher){
        this.teachers.add(teacher);
    }
    //This is the method of adding a student to the students arraylist
    public void add_student(Student student){
        this.students.add(student);
    }
    //This is the method of removing the teacher at a chosen index from the teachers arraylist
    public void remove_teacher(int teacher_pos){
        this.teachers.remove(teacher_pos);
    }
    //This is the method of removing the student at a chosen index from the students arraylist
    public void remove_student(int student_pos){
        this.students.remove(student_pos);
    }
    //This is the method of displaying/printing the teachers list
    public void show_teachers(){
        System.out.println(teachers);
    }
    //This is the method of displaying/printing the students list
    public void show_students(){
        System.out.println(students);
    }
}