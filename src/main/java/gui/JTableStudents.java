package gui;

import javax.swing.*;

public class JTableStudents extends JTable {
    @Override
    public boolean isCellEditable(int row, int column) {
        return true;
    }
}
