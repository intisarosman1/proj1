public record Student(String id, String lastName, String firstName, String email, String phone) implements Comparable<Student> {
    public Student {
        if (id == null || id.equals("")) {
            throw new IllegalArgumentException("id cannot be null");
        }
        if (lastName == null || lastName.equals("")) {
            throw new IllegalArgumentException("lastName cannot be null");
        }
        if (firstName == null || firstName.equals("")) {
            throw new IllegalArgumentException("firsName cannot be null");
        }
        if (email == null || email.equals("")) {
            throw new IllegalArgumentException("email cannot be null");
        }
        if (phone == null || phone.equals("")) {
            throw new IllegalArgumentException("phone cannot be null");
        }

    }

    @Override
    public int compareTo(Student student) {
        if (this.lastName.compareTo(student.lastName) > 0) {
            return 1;
        } else if (this.lastName.compareTo(student.lastName) == 0) {
            return 0;
        } else {
            return -1;
        }
    }
}
