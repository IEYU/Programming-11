public class Student {
    /*
    This class contains the information of a student object that is being constructed.
    It includes the student's first and last name, grade, and the student's student number.
     */

    private String first;   //first represents the first name of the student
    private String last;    //last represents the last name of the student
    private int grade;  //grade represents the grade the student is in
    private int id; //id represents the students' student number
    static int unique_id = (int)(Math.random()*10);

    Student(String first, String last, int grade){
        this.first = first;
        this.last = last;
        this.grade = grade;
        this.id = unique_id;
        unique_id ++;
    }

    //getters and setters of first, last, grade, id, and unique_id
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getUnique_id() {
        return unique_id;
    }

    public static void setUnique_id(int unique_id) {
        Student.unique_id = unique_id;
    }

    //This method returns the student's name and the grade that student is in
    public String toString(){
        return "Name: " + first + " " + last + " Grade: " + grade;
    }
}
