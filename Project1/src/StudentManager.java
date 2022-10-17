import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Scanner;

/**
 * StudentManager for array displaying courses and students
 *
 * @author Intisar Osman
 * @version 10-17-20
 */

/** StudentManager class */
public class StudentManager implements StudentManagerInterface {
    private final String[] courses;
    private final Student[][] students;

    /** StudentManager constructor */
    public StudentManager() throws IOException {
        File courseFile = new File("Courses.csv");
        Scanner coursesScanner = new Scanner(courseFile);

        courses = new String[(int) Files.lines(courseFile.toPath()).filter(line -> line.length() > 0).count() - 2];
        students = new Student[courses.length][];

        int courseIndex = 0;
        int[] studentsEnrolled = new int[courses.length];
        coursesScanner.nextLine();
        coursesScanner.nextLine();
        while (coursesScanner.hasNextLine()) {
            String courseData = coursesScanner.nextLine();
            if (courseData.length() != 0) {
                courses[courseIndex] = courseData.substring(0, courseData.indexOf(","));
                studentsEnrolled[courseIndex] = Integer.valueOf(courseData.substring(courseData.indexOf(",") + 1,
                        courseData.length()));
                courseIndex++;
            }
        }

        for (int i = 0; i < courses.length; i++) {
            students[i] = new Student[studentsEnrolled[i]];
        }

        File studentsFile = new File("Students.csv");
        Scanner studentsScanner = new Scanner(studentsFile);
        courseIndex = 0;
        int studentIndex = 0;
        studentsScanner.nextLine();
        while (studentsScanner.hasNextLine()) {
            String studentData = studentsScanner.nextLine();
            if (studentData.length() != 0) {
                String[] studentDataArray = studentData.split(",");
                for (int i = 0; i < courses.length; i++) {
                    if (courses[i].equals(studentDataArray[0])) {
                        if (i != courseIndex) {
                            studentIndex = 0;
                        }
                        courseIndex = i;
                    }
                }
                Student student = new Student(studentDataArray[1], studentDataArray[2], studentDataArray[3],
                        studentDataArray[4], studentDataArray[5]);
                students[courseIndex][studentIndex] = student;
                studentIndex++;
            }
        }
        for (int i = 0; i < students.length; i++) {
            Arrays.sort(students[i]);

        }
        coursesScanner.close();
        studentsScanner.close();
    }

    /**
     * Retrieves the count of courses
     *
     * @return count of courses
     */
    @Override
    public int getCourseCount() {
        return courses.length;
    }

    /**
     * Retrieves the number of students in the specified course (by index)
     *
     * @param courseIndex the index of the course
     * @return student count in that course
     */
    @Override
    public int getStudentCount(int courseIndex) {
        return students[courseIndex].length;
    }

    /**
     * Retrieves the number of students in all courses
     *
     * @return student count in all courses
     */
    @Override
    public int getStudentCount() {
        int totalStudents = 0;
        for (int i = 0; i < students.length; i++) {
            totalStudents += students[i].length;
        }
        return totalStudents;
    }

    /**
     * Retrieves the number of students in the specified course (by name)
     *
     * @param courseName the name of the course to search for
     * @return student count in that course, or -1 if course is not found
     */
    @Override
    public int getStudentCount(String courseName) {
        for (int i = 0; i < courses.length; i++) {
            if (courses[i].equals(courseName)) {
                return students[i].length;
            }
        }
        return -1;
    }

    /**
     * Retrieves the course name at the specified index
     *
     * @param courseIndex index of the desired course
     * @return course name
     */
    @Override
    public String getCourseName(int courseIndex) {
        return courses[courseIndex];
    }

    /**
     * Retrieves the student at the specific course and student index
     *
     * @param courseIndex  course index
     * @param studentIndex student index
     * @return student at that array position
     */
    @Override
    public Student getStudent(int courseIndex, int studentIndex) {
        return students[courseIndex][studentIndex];
    }

    /**
     * Retrieves a copy of the student array for the course at the specified index
     *
     * @param courseIndex course index
     * @return copy of student array (not a reference to the internal one)
     */
    @Override
    public Student[] getStudents(int courseIndex) {
        return students[courseIndex];
    }

    /**
     * Retrieves the first course index associated with the specified student id
     *
     * @param id the student id to search for
     * @return the first course index containing the specified student, or -1 if not found
     */
    @Override
    public int findStudentCourse(String id) {
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < students[i].length; j++) {
                if (students[i][j].id().equals(id)) {
                    return i;
                }
            }
        }
        return -1;
    }
}



