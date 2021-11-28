package gui;

import javax.swing.table.AbstractTableModel;

import Class.ClassContainer;
import Class.Class;


public class StudentsTableModel extends AbstractTableModel {

    private String[] columnNames = new String[]{"Imie", "Nazwisko", "Students limit"};

    @Override
    public int getColumnCount() {
        return 3;
    }

    private ClassContainer classContainer;


    private final Class emptyClass = new Class();

    private Class aClass = emptyClass;

    public StudentsTableModel(ClassContainer classContainer) {
        this.classContainer = classContainer;
    }

    public void setClass(Class aClass){
        this.aClass = aClass;
    }

    public void setClass(){
        this.aClass = emptyClass;
    }

    @Override
    public int getRowCount() {
        Integer temp = aClass.getListaStudentow().size();
        if (temp == null)return 0;
        return temp;
    }




    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                return aClass.getListaStudentow().get(rowIndex).getImie();
            }
            case 1 -> {
                return aClass.getListaStudentow().get(rowIndex).getNazwisko();
            }
            case 2 -> {
                return aClass.getListaStudentow().get(rowIndex);
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
                aClass.getListaStudentow().get(rowIndex).setImie((String) aValue);
            }
            case 1 -> {
                aClass.getListaStudentow().get(rowIndex).setNazwisko((String) aValue);
            }
        }
        System.out.println(classContainer);
    }
}
