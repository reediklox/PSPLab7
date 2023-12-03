/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class BookTableModel extends AbstractTableModel{
    
    private int colnum = 5;
    private int rownum;
    private String[] colNames = { "BookID", "author","publish_year", "book_name", "book_ganre"};
    private ArrayList<String[]> ResultSets;
    
    public BookTableModel(ResultSet rs){
        ResultSets = new ArrayList<>();
        try{
            while (rs.next()){
                String[] row = { rs.getString("BookID"),
                    rs.getString("author"),
                    rs.getString("publish_year"),
                    rs.getString("book_name"),
                    rs.getString("book_ganre")};
                
                ResultSets.add(row);
            }
                
        } catch(Exception e){
            System.out.println("Exception in BookTableModel");
        }
    }
    
    @Override
    public int getRowCount() {
        return ResultSets.size();
    }

    @Override
    public int getColumnCount() {
        return colnum;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] row = ResultSets.get(rowIndex);
        return row[columnIndex];
    }
    
    @Override
    public String getColumnName(int param)
    {
     return colNames[param];
    }
} 
