/**
 * Subjects.java
 *
 * description
 *
 * @author axu5 <github.com/axu5>
 * @version 22.02.2022
 */
public class Subject {
  private String courseName;
  private final int MAX_STUDENTS = 30;
  private Student[] students = new Student[this.MAX_STUDENTS];
  private int numStudents;
  private Teacher teacher;

  Subject(Teacher teacher, String course) {
    // creates reference, any edits to "this" object will be applied in the teacher
    // object
    teacher.addCourse(this);
    this.teacher = teacher;
    this.courseName = course;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  /**
   * @param student - the student object
   * @return return false if the course exists
   */
  public boolean addStudent(Student student) {
    for (int i = 0; i < numStudents; ++i)
      if (this.students[i].getName().equals(student.getName()))
        return false;

    this.students[numStudents++] = student;
    return true;
  }

  /**
   * @param student student object
   * @return return if the operation was successful
   */
  public boolean removeCourse(Student student) {
    int removedOffset = 0;
    for (int i = 0; i < numStudents; ++i) {
      if (this.students[i].getName().equals(student.getName())) {
        removedOffset++;
      }

      this.students[i] = this.students[i + removedOffset];
    }
    numStudents -= removedOffset;

    return removedOffset > 0;
  }
}