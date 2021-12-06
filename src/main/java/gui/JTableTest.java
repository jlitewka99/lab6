package gui;

import javax.swing.*;

public class JTableTest extends JTable {
    @Override
    public boolean isCellEditable(int row, int column) {
        return true;
    }
}
