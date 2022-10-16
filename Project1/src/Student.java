public record Student(String id, String lastName, String firstName, String email, String phone) implements Comparable<Student> {
    public Student {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        if (lastName == null) {
            throw new IllegalArgumentException("lastName cannot be null");
        }
        if (firstName == null) {
            throw new IllegalArgumentException("firsName cannot be null");
        }
        if (email == null) {
            throw new IllegalArgumentException("email cannot be null");
        }
        if (phone == null) {
            throw new IllegalArgumentException("phone cannot be null");
        }

    }

    @Override
    public int compareTo(Student student) {
        return this.lastName.compareTo(student.lastName);
    }
}
