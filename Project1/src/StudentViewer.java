import javax.swing.*;
import java.awt.*;

public class StudentViewer extends JFrame {
    public StudentViewer() {
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

        // id Field
        JTextField idField = new JTextField();
        idField.setBounds(110, 125, 200, 30);
        panel.add(idField);

        // Last Name
        JLabel lastNameLabel = new JLabel("Last:");
        lastNameLabel.setBounds(25, 175, 75, 30);
        panel.add(lastNameLabel);

        // Last Name Field
        JTextField lastNameField = new JTextField();
        lastNameField.setBounds(110, 175, 200, 30);
        panel.add(lastNameField);

        // First Name
        JLabel firstNameLabel = new JLabel("First:");
        firstNameLabel.setBounds(25, 225, 75, 30);
        panel.add(firstNameLabel);

        // First Name Field
        JTextField firstNameField = new JTextField();
        firstNameField.setBounds(110, 225, 200, 30);
        panel.add(firstNameField);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(25, 275, 75, 30);
        panel.add(emailLabel);

        // Email Field
        JTextField emailField = new JTextField();
        emailField.setBounds(110, 275, 200, 30);
        panel.add(emailField);

        // Phone
        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(25, 325, 75, 30);
        panel.add(phoneLabel);

        // Phone Field
        JTextField phoneField = new JTextField();
        phoneField.setBounds(110, 325, 200, 30);
        panel.add(phoneField);


        // Load Data Button
        JButton loadDataButton = new JButton("Load Data");
        loadDataButton.setBounds(25, 25, 100, 30);
        panel.add(loadDataButton);

        // Previous Button
        JButton prevButton = new JButton("Prev");
        prevButton.setBounds(310, 25, 65, 30);
        panel.add(prevButton);

        // Next Button
        JButton nextButton = new JButton("Next");
        nextButton.setBounds(385, 25, 65, 30);
        panel.add(nextButton);

        // Dropdown Button
        String[] listStrings = {};
        JComboBox dropdownList = new JComboBox(listStrings);
        dropdownList.setBounds(25, 75, 100, 30);
        panel.add(dropdownList);

        // Visibility
        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentViewer();
    }
}

