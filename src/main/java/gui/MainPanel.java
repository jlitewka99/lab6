package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import Class.ClassContainer;
import Class.Student;

public class MainPanel extends JFrame {
    private JPanel panelMain;
    private JButton removeGroupButton;
    private JButton removeStudentButton;
    private JTable groupsTable;
    private JTable studentsTable;
    private JButton addStudent;
    private JButton addGroup;
    private JButton sortButton;
    private JButton filterButton;


    ClassContainer classContainer = new ClassContainer();
    private GroupsTableModel groupsTableModel;
    private StudentsTableModel studentsTableModel;


    public MainPanel() throws HeadlessException {
        super("Class APP");
        setContentPane(panelMain);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);


        groupsTableModel = new GroupsTableModel(classContainer);
        studentsTableModel = new StudentsTableModel(classContainer);


        groupsTable.setModel(groupsTableModel);
        studentsTable.setModel(studentsTableModel);


        groupsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = groupsTable.getSelectedRow();
                if (groupsTableModel.getRowCount() > index && index != -1) {
                    studentsTableModel.setClass(classContainer.getClassById(index));
                    studentsTable.updateUI();
                }
            }
        });


        removeGroupButton.addActionListener(e -> {
            int index = groupsTable.getSelectedRow();
            if (groupsTableModel.getRowCount() > index && index != -1) {
                classContainer.removeClass(classContainer.getClassById(index).getNazwaGrupy());
                studentsTableModel.setClass();
                groupsTable.updateUI();
                studentsTable.updateUI();
            }
        });
        addStudent.addActionListener(e -> {
            int index = groupsTable.getSelectedRow();
            AddStudent.getData(classContainer, index);
            studentsTable.updateUI();
        });
        addGroup.addActionListener(e -> {
//            int index = groupsTable.getSelectedRow();
            AddGroup.getData(classContainer);
            groupsTable.updateUI();
        });
        sortButton.addActionListener(e -> {
            int index = groupsTable.getSelectedRow();

            classContainer.getClassById(index).sortByName();
            studentsTable.updateUI();


        });
//        filterButton.addActionListener(e -> {
//            int index = groupsTable.getSelectedRow();
//
////            Class aClass
//
//            List<Student> list = Filter.getData(classContainer, index);
//            studentsTableModel.setClass(list);/
////            classContainer.getClassById(index).sortByName();
////            studentsTable.updateUI();
//
//
//        });


    }

    private void createUIComponents() {
        groupsTable = new JTableStudents();
        studentsTable = new JTableStudents();
    }


}
