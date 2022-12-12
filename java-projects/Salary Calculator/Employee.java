package Test;

public class Employee {
    String name;
    double salary;
    int workHours;
    int hireYear;
    double tax = 0;
    double bonus = 0;
    double firstSalary = 0;

    Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
        this.firstSalary = salary;
    }

    //If employee's salary is more than 1000, 3% tax will be implied.
    void taxCalculation() {
        if (this.salary > 1000) {
            this.tax += (this.salary * 3) / 100;
            this.salary -= this.tax;
        }
    }

    //If employee work more than 40 hours, every hour more than 40 will be multiplied and added net salary.
    void bonusCalculation() {
        if (workHours > 40) {
            this.bonus = (this.workHours - 40) * 30;
            this.salary += this.bonus;
        }
    }

    //This year is 2022. If the employee has been working for the company for less than 10 years, his salary is increased by %5.
    //If the employee has been working for the company for more than 10 years but less than 20 years, his salary is increased by %10.
    // If the employee has been working for the company for more than 20 years, his salary is increased by %15.
    void raiseSalary() {
        if ((2022 - hireYear) < 10) {
            salary += salary / 20;
        } else if ((2022 - hireYear) >= 10 && (2022 - hireYear) < 20) {
            salary += salary / 10;
        } else if ((2022 - hireYear) >= 20) {
            salary += 3 * (salary / 20);
        }
    }

    @Override
    public String toString() {
        String returnString = "";
        returnString += "Name: " + this.name + "\n" +
                "Salary: " + this.firstSalary + "\n" +
                "Working Hour: " + workHours + "\n" +
                "Starting Year: " + this.hireYear + "\n" +
                "Bonus: " + this.bonus + "\n" +
                "Tax: " + this.tax + "\n" +
                "Final Salary: " + this.salary;

        return returnString;
    }
}
