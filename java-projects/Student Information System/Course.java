package Test;

public class Course {
    Teacher courseTeacher;
    String name;
    String code;
    String prefix;
    int note;

    public Course(String name, String code, String prefix) {
        this.name = name;
        this.code = code;
        this.prefix = prefix;
        this.note = 0;
    }

    public void addTeacher(Teacher t) {
        if (this.prefix.equals(t.branch)) {
            this.courseTeacher = t;
            System.out.println("Transaction successful.");
        } else {
            System.out.println("Academician " + t.name + " cannot teach this course.");
        }
    }

    public void printTeacher() {
        if (courseTeacher != null) {
            System.out.println("Academician of the " + this.name + " course: " + courseTeacher.name);
        } else {
            System.out.println("No academician has been assigned to the " + this.name + " course.");
        }
    }
}
