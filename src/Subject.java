/**
 * Subjects.java
 *
 * description
 *
 * @author axu5 <github.com/axu5>
 * @version 22.02.2022
 */
public class Subject {
  public static void main(String[] args) {
    var mora = new Teacher("Mrs Mora", "Pembroke");
    var pkj = new Teacher("Mrs Pkj", "Swieqi");

    var aleks = new Student("Aleks", "Mellieha");
    var frank = new Student("Frank", "Sliema");
    var eren = new Student("Eren", "Sliema");
    var luca = new Student("Luca", "Sliema");

    var cs = new Subject("IB Computer Science", mora);
    var history = new Subject("IB History", pkj);

    cs.addStudent(aleks);
    cs.addStudent(frank);
    cs.addStudent(eren);
    cs.addStudent(luca);

    history.addStudent(eren);
    history.addStudent(luca);

    aleks.addCourseGrade(cs, 7);
    frank.addCourseGrade(cs, 6);
    luca.addCourseGrade(cs, 5);
    eren.addCourseGrade(cs, 4);

    luca.addCourseGrade(history, 7);
    eren.addCourseGrade(history, 6);

    cs.printStudentNames();
    System.out.println("CS " + cs.getAverageGrade());
    history.printStudentNames();
    System.out.println("History " + history.getAverageGrade());

    eren.printGrades();

    cs.removeStudent(eren);

    cs.printStudentNames();
    System.out.println("CS " + cs.getAverageGrade());
    history.printStudentNames();

    System.out.println("History " + history.getAverageGrade());
    eren.printGrades();
  }

  private String courseName;
  private Teacher teacher;
  private Student[] students = new Student[this.MAX_STUDENTS];
  private final int MAX_STUDENTS = 30;
  private int numStudents;

  Subject(String courseName, Teacher teacher) {
    // creates reference, any edits to "this" object will be applied in the teacher
    // object
    // teacher.adxdCourse(this);
    this.teacher = teacher;
    this.courseName = courseName.trim();
  }

  Subject(String course) {
    this.courseName = course.trim();
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName.trim();
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher teacher) {
    // add the teacher reference to this class, and add the subject reference into
    // the teacher
    this.teacher = teacher;
    teacher.addCourse(this);
  }

  public void printStudentNames() {
    // concatenate an empty string with commas for all the names.
    String cumulation = "";
    for (int i = 0; i < this.numStudents; ++i) {
      String studentName = this.students[i].getName();
      cumulation += (i > 0 ? ", " : "") + studentName;
    }

    // print the final result onto a new line
    System.out.println(cumulation);
  }

  /**
   * @param student - the student object
   * @return return false if the course exists
   */
  public boolean addStudent(Student student) {
    // loop over the students, return out if student is found, do not create
    // duplicates
    for (int i = 0; i < numStudents; ++i) {
      Student current = this.students[i];
      if (current.getName().equals(student.getName()))
        return false;
    }

    // set to the last position of the students array
    this.students[numStudents++] = student;
    return true;
  }

  /**
   * @param student student object
   * @return return if the operation was successful
   */
  public boolean removeStudent(Student student) {
    // make a variable for the offset of the items that will replace items in the
    // array
    int removedOffset = 0;
    for (int i = 0; i < numStudents; ++i) {
      // set current
      Student current = this.students[i];
      // if this student name is being removed, add to offset counter
      if (current.getName().equals(student.getName())) {
        removedOffset++;
        student.removeCourse(this);
      }

      // replace current index with an item from further on in the array.
      this.students[i] = i <= numStudents - removedOffset ? this.students[i + removedOffset] : null;
    }

    // remove the amount of students removed.
    numStudents -= removedOffset;

    // remove the course from the student as well.
    // this works because you can remove courses that don't exist in the student,
    // nothing will happen
    student.removeCourse(this);

    // if removedOffset is 0 the student wasn't found in the class and this returns
    // false
    return removedOffset > 0;
  }

  public double getAverageGrade() {
    double total = 0;

    for (int i = 0; i < numStudents; ++i) {
      // add everything to total
      Student current = this.students[i];
      total += current.getCourseGrade(this.courseName);
    }

    // return average grade
    return total / numStudents;
  }
}