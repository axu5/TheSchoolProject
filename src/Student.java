/**
 * Student.java
 *
 * Student is a class for IB students
 *
 * @author axu5 <github.com/axu5>
 * @version 16.02.2022
 */
public class Student extends Person {
  // private instance variables/ attributes
  private int numCourses; // number of courses taken so far
  private final int MAX_COURSES = 30; // maximum number of courses
  private Subject[] courses; // course names
  private int[] grades; // grade for the corresponding course names

  // Constructor
  public Student(String name, String address) {
    super(name, address);
    this.numCourses = 0;
    this.courses = new Subject[this.MAX_COURSES];
    this.grades = new int[MAX_COURSES];
  }

  // toString method
  public String toString() {
    return super.toString();
  }

  public int getNumCourses() {
    // complete code
    return this.numCourses;
  }

  // Add a course and its grade - No validation in this method
  public void addCourseGrade(Subject course, int grade) {
    // complete code
    // make sure to update counter

    // add a new course
    this.courses[this.numCourses] = course;
    this.grades[this.numCourses] = grade;
    this.numCourses++;
  }

  public double getCourseGrade(String course) {
    for (int i = 0; i < this.numCourses; ++i) {
      String currentSubjectName = this.courses[i].getCourseName();
      if (currentSubjectName.equals(course)) {
        return this.grades[i];
      }
    }

    return 0;
  }

  public void removeCourse(Subject course) {
    int removedOffset = 0;
    for (int i = 0; i < this.numCourses - removedOffset; ++i) {
      String currentSubjectName = this.courses[i].getCourseName();
      if (currentSubjectName.equals(course.getCourseName())) {
        removedOffset++;
      }

      this.courses[i] = this.courses[i + removedOffset];
      this.courses[i] = i <= numCourses - removedOffset ? this.courses[i + removedOffset] : null;
    }

    this.numCourses -= removedOffset;
  }

  // Print all courses taken and their grade
  public void printGrades() {
    // complete code
    // use counter for loop
    for (int i = 0; i < this.numCourses; ++i) {
      String currentCourseName = this.courses[i].getCourseName();
      int currentGrade = this.grades[i];
      System.out.printf("COURSE: %s - GRADE: %s\n", currentCourseName, currentGrade);
    }
  }

  // Get the value of one course in the list of courses
  public Subject getCourse(int index) {
    return this.courses[index];
  }

  // Geth the value of one grade in the list of grades
  public int geGrade(int index) {
    return this.grades[index];
  }

  // Complete the average grade
  public double getAverageGrade() {
    int total = 0;
    for (int i = 0; i < numCourses; ++i) {
      total += this.grades[i];
    }

    return total / numCourses;
  }
}