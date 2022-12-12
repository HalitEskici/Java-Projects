package Test;

public class Main {
    public static void main(String[] args) {
        Course math = new Course("Math", "MAT101", "MAT");
        Course vMath = new Course("Math", "MAT101", "MAT");
        Course physics = new Course("Physics", "PHY101", "PHY");
        Course vPhysics = new Course("Physics", "PHY101", "PHY");
        Course chemistry = new Course("Chemistry", "CHE101", "CHE");
        Course vChemistry = new Course("Chemistry", "CHE101", "CHE");

        Teacher t1 = new Teacher("Halit Eskici", "111", "MAT");
        Teacher t2 = new Teacher("Albert Einstein", "222", "PHY");
        Teacher t3 = new Teacher("Nicola Tesla", "333", "CHE");

        math.addTeacher(t1);
        physics.addTeacher(t2);
        chemistry.addTeacher(t3);

        Student s1 = new Student("Özgür Eskici", 11, "3", math, physics, chemistry, vMath, vPhysics, vChemistry);
        s1.addBulkExamNote(50, 20, 40, 50, 100, 20);
        s1.isPass();

        Student s2 = new Student("Umut Eskici", 10, "566", math, physics, chemistry, vMath, vPhysics, vChemistry);
        s2.addBulkExamNote(100, 50, 30, 15, 30, 55);
        s2.isPass();

        Student s3 = new Student("Deniz Eskici", 12, "4", math, physics, chemistry, vMath, vPhysics, vChemistry);
        s3.addBulkExamNote(50, 20, 50, 60, 80, 20);
        s3.isPass();
    }
}
