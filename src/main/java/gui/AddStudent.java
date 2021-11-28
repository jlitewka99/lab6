package gui;

import javax.swing.*;
import java.util.ArrayList;
import Class.ClassContainer;
import Class.Student;
import Class.StudentCondition;
import java.util.List;

public class AddStudent {
    private static JTextField studentFirstName = new JTextField();
    private static JTextField studentSecondName = new JTextField();
    private static JTextField rokUrodzenia = new JTextField();
    private static JTextField pseudonim = new JTextField();

    private static JComboBox<StudentCondition> comboBox = new JComboBox(StudentCondition.values());

    private static JTextField stan = new JTextField();



    static Object[] message = {
            "Imie:", studentFirstName,
            "Nazwisko:", studentSecondName,
            "Rok urodzenia:", rokUrodzenia,
            "Pseudonim:", pseudonim,
            "Stan:", comboBox
    };

    public static void getData(ClassContainer classContainer, int index) {

        int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {

            classContainer.getClassById(index).addStudent(new Student(studentFirstName.getText(), studentSecondName.getText(), comboBox.getPrototypeDisplayValue(), rokUrodzenia.getText(), 0.0, pseudonim.getText()));

        } else {
            System.out.println("Addstudent cancelled");
        }
    }


}
