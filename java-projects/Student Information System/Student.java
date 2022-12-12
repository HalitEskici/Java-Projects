package Test;

public class Student {
    String name;
    String studentNumber;
    int classes;
    Course math;
    Course physics;
    Course chemistry;
    Course vMath;
    Course vPhysics;
    Course vChemistry;
    double average;
    boolean isPass;

    Student(String name, int classes, String studentNumber, Course math, Course physics, Course chemistry, Course vMath, Course vPhysics, Course vChemistry) {
        this.name = name;
        this.classes = classes;
        this.studentNumber = studentNumber;
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
        this.vMath = vMath;
        this.vPhysics = vPhysics;
        this.vChemistry = vChemistry;
        this.isPass = false;
        calcAverage();
    }

    void addBulkExamNote(int math, int physics, int chemistry, int vMath, int vPhysics, int vChemistry) {
        if (math >= 0 && math <= 100) {
            this.math.note = math;
        }

        if (physics >= 0 && physics <= 100) {
            this.physics.note = physics;
        }

        if (chemistry >= 0 && chemistry <= 100) {
            this.chemistry.note = chemistry;
        }
        if (this.vMath.note >= 0 && this.vMath.note <= 100) {
            this.vMath.note = vMath;
        }
        if (vPhysics >= 0 && vPhysics <= 100) {
            this.vPhysics.note = vPhysics;
        }
        if (vChemistry >= 0 && vChemistry <= 100) {
            this.vChemistry.note = vChemistry;
        }
    }

    public void isPass() {
        if (this.math.note == 0 || this.physics.note == 0 || this.chemistry.note == 0
                || this.vMath.note == 0 || this.vPhysics.note == 0 || this.vChemistry.note == 0) {
            System.out.println("Grades are not fully entered.");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Average: " + this.average);
            if (this.isPass) {
                System.out.println("Passed the class!");
            } else {
                System.out.println("Failed the class!.");
            }
        }
    }


    public void calcAverage() {
        double physicsAverage = (this.physics.note * 0.8) + (this.vPhysics.note * 0.2);
        double chemistryAverage = (this.chemistry.note * 0.7) + (this.vChemistry.note * 0.3);
        double mathAverage = (this.math.note * 0.5) + (this.vMath.note * 0.5);

        this.average = (physicsAverage + chemistryAverage + mathAverage) / 3.0;
    }

    public boolean isCheckPass() {
        calcAverage();
        return this.average > 55;
    }

    public void printNote() {
        System.out.println("=========================");
        System.out.println("Student: " + this.name);
        System.out.println("Math Grade: " + this.math.note);
        System.out.println("Physics Grade: " + this.physics.note);
        System.out.println("Chemistry Grade: " + this.chemistry.note);
        System.out.println("Mathematics Oral Grade: " + this.vMath.note);
        System.out.println("Physics Oral Grade: " + this.vPhysics.note);
        System.out.println("Chemistry Oral Grade: " + this.vChemistry.note);
    }
}
