/**
 * Teacher.java
 *
 * The teacher subclass of a person. This is a class for organizing teachers'
 * classes
 *
 * @author axu5 <github.com/axu5>
 * @version 16.02.2022
 */
public class Teacher extends Person {
  private int numCourses;
  private String[] courses;
  private final int MAX_COURSES = 5;

  Teacher(String name, String address) {
    super(name, address);
    this.numCourses = 0;
    this.courses = new String[this.MAX_COURSES];
  }

  // can add and remove courses
  // added courses go to end of array but removing courses implies on shifting the
  // rest down
  // the counter of courses also needs to be updated
  /**
   * @param course - the name of the course
   * @return return false if the course exists
   */
  public boolean addCourse(String course) {
    for (int i = 0; i < numCourses; ++i)
      if (this.courses[i].equals(course))
        return false;

    this.courses[numCourses++] = course;
    return true;
  }

  /**
   * @param course String name of the course
   * @return return if the operation was successful
   */
  public boolean removeCourse(String course) {
    int removedOffset = 0;
    boolean found = false;
    for (int i = 0; i < numCourses; ++i) {
      if (this.courses[i].equals(course)) {
        removedOffset++;
        found = true;
      }

      this.courses[i] = this.courses[i + removedOffset];
    }
    numCourses -= removedOffset;

    return found;
  }

  /**
   * test method for remove and add course
   */
  public void showCourses() {
    for (int i = 0; i < this.MAX_COURSES; ++i) {
      System.out.println("[" + i + "] " + this.courses[i]);
    }
  }

  public String toString() {
    return super.toString();
  }
}