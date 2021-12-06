package gui;

import Class.ClassContainer;
import Class.Student;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Filter {
    private static JTextField filterText = new JTextField();
//    private static JTextField classLimit = new JTextField();
//    private static JTextField rokUrodzenia = new JTextField();
//    private static JTextField pseudonim = new JTextField();
//
//    private static JComboBox<StudentCondition> comboBox = new JComboBox(StudentCondition.values());
//
//    private static JTextField stan = new JTextField();


    static Object[] message = {
            "Filter:", filterText,
    };

    public static List<Student> getData(ClassContainer classContainer, int index) {

        List<Student> list = new ArrayList<Student>();

        int option = JOptionPane.showConfirmDialog(null, message, "Dodaj klase", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            list = classContainer.getClassById(index).searchPartial(filterText.getText());

            return list;
//            classContainer.addClass(filter.getText(), Integer.parseInt(classLimit.getText()));

        } else {
            return list;
//            System.out.println("Addstudent cancelled");
        }
    }


}
