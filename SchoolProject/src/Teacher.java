public class Teacher {
    /*
    This class contains the information of the teacher object that is being constructed.
    It includes the teacher's first and last name and the subject that teacher teaches.
     */

    private String first;   //first represents the first name of a teacher
    private String last;    //last represents teh last name of a teacher
    private String subject; //subject represents the subject that a teacher teaches

    //When a new teacher object is constructed, it contains the information of the teacher's first and last name and the subject that teacher teaches
    Teacher(String first, String last, String subject){
        this.first = first;
        this.last = last;
        this.subject = subject;
    }

    //getters and setters of first, last, and subject
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    //This method returns the teacher's name and the subject that teacher teaches
    public String toString(){
        return "Name: " + first + " " + last + " Subject: " + subject;
    }
}
