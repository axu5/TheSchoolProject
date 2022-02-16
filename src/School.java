/**
 * School.java
 *
 * This is the demo class for the whole project
 *
 * @author axu5 <github.com/axu5>
 * @version 16.02.2022
 */
public class School {
  public static void main(String[] _args) {
    // Test Student class
    // Create 3 students giving them 4 courses ("IB Comp Science", "IB Math SL", "IB
    // TOK", and "IB History") with 4 associated grades to each student.
    // print the object, the grades and the average

    var alex = new Student("Alex", "Pembroke");
    alex.addCourseGrade("IB Comp Science", 5);
    alex.addCourseGrade("IB Math SL", 6);
    alex.addCourseGrade("IB TOK", 6);
    alex.addCourseGrade("IB History", 7);

    System.out.println(alex);
    alex.printGrades();
    System.out.println(alex.getAverageGrade());

    // Test Teacher class
    Teacher t1 = new Teacher("Ms Mora", "Madliena");
    String[] milesToMora = { "IB CompSci 11", "IB CompSci 12", "IGCSE Computer Science 9", "IB Maths SL" };

    System.out.println(t1);
    for (int i = 0; i < milesToMora.length; ++i) {
      if (t1.addCourse(milesToMora[i]))
        System.out.println(milesToMora[i] + " added.");
      else
        System.out.println(milesToMora[i] + " cannot be added.");
    }

    String courseToRemove = "IB Maths SL";
    System.out.println(t1.removeCourse(courseToRemove) ? "course removed" : "course not found");

    t1.showCourses();
  }
}