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
    this.courseName = courseName;
  }

  Subject(String course) {
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
    teacher.addCourse(this);
  }

  public void printStudentNames() {
    String cumulation = "";
    for (int i = 0; i < this.numStudents; ++i) {
      Student current = this.students[i];
      cumulation += (i > 0 ? ", " : "") + current.getName();
    }

    System.out.println(cumulation);
  }

  /**
   * @param student - the student object
   * @return return false if the course exists
   */
  public boolean addStudent(Student student) {
    for (int i = 0; i < numStudents; ++i) {
      Student current = this.students[i];
      if (current.getName().equals(student.getName()))
        return false;
    }

    this.students[numStudents++] = student;
    return true;
  }

  /**
   * @param student student object
   * @return return if the operation was successful
   */
  public boolean removeStudent(Student student) {
    int removedOffset = 0;
    for (int i = 0; i < numStudents; ++i) {
      Student current = this.students[i];
      if (current.getName().equals(student.getName())) {
        removedOffset++;
        student.removeCourse(this);
      }

      this.students[i] = this.students[i + removedOffset];
    }
    numStudents -= removedOffset;

    student.removeCourse(this);

    return removedOffset > 0;
  }

  public double getAverageGrade() {
    double total = 0;

    for (int i = 0; i < numStudents; ++i) {
      Student current = this.students[i];
      total += current.getCourseGrade(this.courseName);
    }

    return total / numStudents;
  }
}