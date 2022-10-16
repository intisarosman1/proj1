import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudentManager implements StudentManagerInterface {
    private final String[] courses;
    private final Student[][] students;

    public StudentManager() throws FileNotFoundException {
        //TODO: fill this in! we have lots of work to do here
        // read courses file and create all arrays
        // read student file, create objects, set up references
        // sort students as instructed
        File courseFile = new File("Courses.csv");
        Scanner courseScanner = new Scanner(courseFile);

        int courseCount = -2;

        courses = new String[courseCount];
        courseScanner.nextLine();



    }

    /**
     * Retrieves the count of courses
     *
     * @return count of courses
     */
    @Override
    public int getCourseCount() {
        return 0;
    }

    /**
     * Retrieves the number of students in the specified course (by index)
     *
     * @param courseIndex the index of the course
     * @return student count in that course
     */
    @Override
    public int getStudentCount(int courseIndex) {
        return 0;
    }

    /**
     * Retrieves the number of students in all courses
     *
     * @return student count in all courses
     */
    @Override
    public int getStudentCount() {
        return 0;
    }

    /**
     * Retrieves the number of students in the specified course (by name)
     *
     * @param courseName the name of the course to search for
     * @return student count in that course, or -1 if course is not found
     */
    @Override
    public int getStudentCount(String courseName) {
        return 0;
    }

    /**
     * Retrieves the course name at the specified index
     *
     * @param courseIndex index of the desired course
     * @return course name
     */
    @Override
    public String getCourseName(int courseIndex) {
        return null;
    }

    /**
     * Retrieves the student at the specifiec course and student index
     *
     * @param courseIndex  course index
     * @param studentIndex student index
     * @return student at that array position
     */
    @Override
    public Student getStudent(int courseIndex, int studentIndex) {
        return null;
    }

    /**
     * Retrieves a copy of the student array for the course at the specified index
     *
     * @param courseIndex course index
     * @return copy of student array (not a reference to the internal one)
     */
    @Override
    public Student[] getStudents(int courseIndex) {
        return new Student[0];
    }

    /**
     * Retrieves the first course index associated with the specified student id
     *
     * @param id the student id to search for
     * @return the first course index containing the specified student, or -1 if not found
     */
    @Override
    public int findStudentCourse(String id) {
        return 0;
    }
}
