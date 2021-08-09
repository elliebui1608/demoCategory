package com.example.demoCategory;

import java.sql.SQLException;
import java.util.List;

public interface DatabaseInterface {
    public void add(Student std) throws ClassNotFoundException, SQLException;
    public Student edit(Student std, String studentid) throws SQLException, ClassNotFoundException;
    public void delete(String studentid) throws SQLException;
    public List<Student> display() throws ClassNotFoundException, SQLException;
}
