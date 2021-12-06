package gui;

import Class.ClassContainer;
import Class.Student;
import Class.Class;
import Class.StudentCondition;

import javax.swing.*;

public class AddGroup {
    private static JTextField className = new JTextField();
    private static JTextField classLimit = new JTextField();
//    private static JTextField rokUrodzenia = new JTextField();
//    private static JTextField pseudonim = new JTextField();
//
//    private static JComboBox<StudentCondition> comboBox = new JComboBox(StudentCondition.values());
//
//    private static JTextField stan = new JTextField();



    static Object[] message = {
            "Nazwa grupy:", className,
            "Nazwisko:", classLimit
    };

    public static void getData(ClassContainer classContainer) {

        int option = JOptionPane.showConfirmDialog(null, message, "Dodaj klase", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {

            classContainer.addClass(className.getText(), Integer.parseInt(classLimit.getText()));

        } else {
            System.out.println("Addstudent cancelled");
        }
    }


}
