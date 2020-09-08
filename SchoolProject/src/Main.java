public class Main {
    public static void main(String[] args) {
        //This construct a new school object called Secondary_School with a total of 100 teachers and 1000 students
        School Secondary_School = new School("Secondary_School", 1000, 100);

        //This adds 10 students to the students list
        Secondary_School.add_student(new Student("Elena", "Stone", 8));
        Secondary_School.add_student(new Student("Eadie", "Cas", 9));
        Secondary_School.add_student(new Student("Shelly", "Merrill", 10));
        Secondary_School.add_student(new Student("Wasim", "Turnbull", 11));
        Secondary_School.add_student(new Student("Shak", "Browne", 12));
        Secondary_School.add_student(new Student("Kade", "Ellwood", 8));
        Secondary_School.add_student(new Student("Harley", "Hes", 9));
        Secondary_School.add_student(new Student("Dollie", "Cantrell", 10));
        Secondary_School.add_student(new Student("Zak", "Gordon", 11));
        Secondary_School.add_student(new Student("Caris", "Jacobs", 12));

        //This adds 3 teachers to the teachers list
        Secondary_School.add_teacher(new Teacher("Mya", "Stevenson", "Math"));
        Secondary_School.add_teacher(new Teacher("Ava", "Irvine", "Language Art"));
        Secondary_School.add_teacher(new Teacher("Brennan", "Dalton", "Science"));

        //This displays the teachers list after the 3 teachers are added
        Secondary_School.show_teachers();
        //This displays the students list after the 10 students are added
        Secondary_School.show_students();

        //This removes the first student from the students list
        Secondary_School.remove_student(0);
        //This removes the first student from the new students list
        Secondary_School.remove_student(0);

        //This removes the first teacher from the teachers list
        Secondary_School.remove_teacher(0);

        //This displays the edited teachers list
        Secondary_School.show_teachers();
        //This displays the edited students list
        Secondary_School.show_students();
    }
}
