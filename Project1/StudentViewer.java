import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StudentViewer extends JFrame {
    private final StudentManager studentManager;
    private int index;

    public StudentViewer() throws IOException {
        studentManager = new StudentManager();
        index = 0;

        // CREATING THE GUI
        setSize(500, 450);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension screenSize = getToolkit().getScreenSize();
        setLocation((screenSize.width - getWidth()) / 2,
                (screenSize.height - getHeight()) / 2);

        // Panel
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        // id
        JLabel idLabel = new JLabel("Id:");
        idLabel.setBounds(25, 125, 75, 30);
        panel.add(idLabel);

        // id field
        JTextField idField = new JTextField();
        idField.setBounds(110, 125, 200, 30);
        panel.add(idField);

        // Last name
        JLabel lastNameLabel = new JLabel("Last:");
        lastNameLabel.setBounds(25, 175, 75, 30);
        panel.add(lastNameLabel);

        // Last name field
        JTextField lastNameField = new JTextField();
        lastNameField.setBounds(110, 175, 200, 30);
        panel.add(lastNameField);

        // First name
        JLabel firstNameLabel = new JLabel("First:");
        firstNameLabel.setBounds(25, 225, 75, 30);
        panel.add(firstNameLabel);

        // First name field
        JTextField firstNameField = new JTextField();
        firstNameField.setBounds(110, 225, 200, 30);
        panel.add(firstNameField);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(25, 275, 75, 30);
        panel.add(emailLabel);

        // Email field
        JTextField emailField = new JTextField();
        emailField.setBounds(110, 275, 200, 30);
        panel.add(emailField);

        // Phone
        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(25, 325, 75, 30);
        panel.add(phoneLabel);

        // Phone field
        JTextField phoneField = new JTextField();
        phoneField.setBounds(110, 325, 200, 30);
        panel.add(phoneField);


        // Load Data button
        JButton loadDataButton = new JButton("Load Data");
        loadDataButton.setBounds(25, 25, 100, 30);
        panel.add(loadDataButton);


        // Previous button
        JButton previousButton = new JButton("Prev");
        previousButton.setBounds(310, 25, 65, 30);
        panel.add(previousButton);

        // Next button
        JButton nextButton = new JButton("Next");
        nextButton.setBounds(385, 25, 65, 30);
        panel.add(nextButton);

        // Dropdown button
        String[] listStrings = {};
        JComboBox dropdownList = new JComboBox(listStrings);
        dropdownList.setBounds(25, 75, 100, 30);
        panel.add(dropdownList);

        // EVENT LISTENERS
        ActionListener dropDownSelection = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student student = studentManager.getStudent(dropdownList.getSelectedIndex(), 0);
                idField.setText(student.id());
                lastNameField.setText(student.lastName());
                firstNameField.setText(student.firstName());
                emailField.setText(student.email());
                phoneField.setText(student.phone());
                index = 0;
            }
        };

        loadDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int getCourseCount = studentManager.getCourseCount();
                for (int i = 0; i < getCourseCount; i++) {
                    dropdownList.addItem(studentManager.getCourseName(i));
                }
                dropdownList.setSelectedIndex(-1);
                dropdownList.addActionListener(dropDownSelection);
            }
        });

        // Previous action listener
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index - 1 >= 0) {
                    index--;
                    Student student = studentManager.getStudent(dropdownList.getSelectedIndex(), index);
                    idField.setText(student.id());
                    lastNameField.setText(student.lastName());
                    firstNameField.setText(student.firstName());
                    emailField.setText(student.email());
                    phoneField.setText(student.phone());
                }
            }
        } );

        // Next action listener
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index - 1 < studentManager.getStudentCount(dropdownList.getSelectedIndex())) {
                    index++;
                    Student student = studentManager.getStudent(dropdownList.getSelectedIndex(), index);
                    idField.setText(student.id());
                    lastNameField.setText(student.lastName());
                    firstNameField.setText(student.firstName());
                    emailField.setText(student.email());
                    phoneField.setText(student.phone());
                }
            }
        } );

        // Visibility
        setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new StudentViewer();
    }
}

