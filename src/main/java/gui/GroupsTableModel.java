package gui;

import javax.swing.table.AbstractTableModel;

import Class.ClassContainer;

public class GroupsTableModel extends AbstractTableModel {

    private String[] columnNames = new String[]{"Class name", "Students limit"};


    private ClassContainer classContainer;

    public GroupsTableModel(ClassContainer classContainer) {
        this.classContainer = classContainer;
    }

    @Override
    public int getRowCount() {
        Integer temp = classContainer.getGroupSize();
        if (temp == null)return 0;
        return temp;
    }


    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                return classContainer.getClassById(rowIndex).getNazwaGrupy();
            }
            case 1 -> {
                return classContainer.getClassById(rowIndex).getMaksymalnaIloscStudentow();
            }
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                classContainer.changeGroupName(rowIndex, (String) aValue);
            }
            case 1 -> {
                classContainer.getClassById(rowIndex).setMaksymalnaIloscStudentow(Integer.parseInt((String) aValue));
            }
        }
        System.out.println(classContainer);
    }

}
