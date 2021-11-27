package gui;

import javax.swing.*;
import java.awt.*;
import Class.ClassContainer;
import Class.Student;
import Class.StudentCondition;

public class MainPanel extends JFrame{
    private JPanel panelMain;
    private JButton button1;
    private JButton button2;
    private JTable groupsTable;
    private JTable studentsTable;

    private GroupsTableModel groupsTableModel;

    ClassContainer classContainer = new ClassContainer();

    public MainPanel() throws HeadlessException {
        super("Class APP");
        setContentPane(panelMain);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        groupsTableModel = new GroupsTableModel();
        infill();
        System.out.println(groupsTableModel);
        System.out.println(classContainer);



        groupsTable.setModel(groupsTableModel);



    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    private void infill(){
        Student student1 = new Student("Pawel", "Kowalski", StudentCondition.ODRABIAJĄCY, 1999, 1.1, "Pawlo");
        Student student6 = new Student("Pawel", "Kowalski", StudentCondition.ODRABIAJĄCY, 1999, 1.1, "Pawlo");
        Student student2 = new Student("Pawel2", "Nowak", StudentCondition.ODRABIAJĄCY, 1999, 7.1, "Pawlo");
        Student student3 = new Student("Aawel", "Test", StudentCondition.ODRABIAJĄCY, 1999, 3.1, "Pawlo");
        Student student4 = new Student("Bawel", "Litewka", StudentCondition.ODRABIAJĄCY, 1999, 4.1, "Pawlo");
        Student student5 = new Student("Bawel", "Litewka", StudentCondition.ODRABIAJĄCY, 1999, 0, "Pawlo");









        classContainer.addClass("Klasa 1", 10);
        classContainer.addClass("Klasa 2", 20);
        classContainer.addClass("Klasa 3", 30);
        classContainer.addClass("Klasa 4", 40);

        classContainer.getClassByName("Klasa 1").addStudent(student1);
        classContainer.getClassByName("Klasa 1").addStudent(student2);
        classContainer.getClassByName("Klasa 1").addStudent(student2);
        classContainer.getClassByName("Klasa 1").addStudent(student3);
        classContainer.getClassByName("Klasa 1").addStudent(student5);







        classContainer.getClassByName("Klasa 1").sortByName();
        System.out.println("Posortowane po imieniu: " + classContainer.getClassByName("Klasa 1"));
        classContainer.getClassByName("Klasa 1").sortByPoints();
        System.out.println("Posortowane po punktach: " + classContainer.getClassByName("Klasa 1"));
        classContainer.getClassByName("Klasa 2").addStudent(student4);
        System.out.println("Lista pustych: " + classContainer.findEmpty());

        classContainer.summary();

        System.out.println(classContainer.getClassByName("Klasa 1").max());

        System.out.println("Wyszukane 1");
        System.out.println(classContainer.getClassByName("Klasa 2").searchPartial("wka"));
        System.out.println("Wyszukane 2");
        System.out.println(classContainer.getClassByName("Klasa 1").searchPartial("ski"));
        classContainer.getClassByName("Klasa 1").removeStudentIfLowPoints(student5);
        classContainer.getClassByName("Klasa 1").removeStudentIfLowPoints(student1);

    }


}
