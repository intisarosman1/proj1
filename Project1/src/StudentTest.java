import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void constructor() {
        Student testStudent = new Student("101010", "Anderson", "Jaime", "jollibee777@gmail.com", "206-987-654");
        assertEquals("101010", testStudent.id());
        assertEquals("Anderson", testStudent.lastName());
        assertEquals("Jaime", testStudent.firstName());
        assertEquals("jollibee777@gmail.com", testStudent.email());
        assertEquals("206-987-654", testStudent.phone());

        assertThrows(IllegalArgumentException.class,
                () -> new Student(null, "Anderson", "Jaime", "jollibee777@gmail.com", "206-987-654"));
        assertThrows(IllegalArgumentException.class,
                () -> new Student("101010", "Anderson", "", "jollibee777@gmail.com", "206-987-654"));
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void compareTo() {
    }

    @Test
    void id() {
    }

    @Test
    void lastName() {
    }

    @Test
    void firstName() {
    }

    @Test
    void email() {
    }

    @Test
    void phone() {
    }
}