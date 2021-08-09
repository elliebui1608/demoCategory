package com.example.demoCategory;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService implements DatabaseInterface {
    Connection con;
    public DatabaseService(Connection con) {
        this.con = con;
    }





    @Override
    public void add(Student std) throws ClassNotFoundException, SQLException {
        String quer1 = "INSERT INTO studentinfo VALUES ( ?, ? ,?)";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, std.getStudentid());
        query.setString(2, std.getFirstname());
        query.setString(3, std.getLastname());
        query.executeUpdate();
    }

    @Override
    public Student edit(Student std, String studentid) throws SQLException, ClassNotFoundException {
        PreparedStatement query;
        query = con.prepareStatement("Update studentinfo set studentid=?, firstname=?, lastname=? where studentid = ?");
        query.setString(1, std.getStudentid());
        query.setString(2, std.getFirstname());
        query.setString(3, std.getLastname());
        query.setString(4, studentid);
        query.executeUpdate();
        return std;
    }

    @Override
    public void delete(String studentid) throws SQLException {
        String quer1 = "Delete from studentinfo where studentid = ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, studentid);
        query.executeUpdate();
    }

    public Student search(String studentid) throws SQLException,ClassNotFoundException {
        String quer1 = "Select * from studentinfo where studentid = ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, studentid);
        ResultSet rs = query.executeQuery();

        if (!rs.first()) {
            System.out.print("Record not existing");
            return null;
        }
        Student obj1 = null;
        obj1 = new Student(rs.getString("studentid"), rs.getString("firstname"),rs.getString("lastname"));
        return obj1;
    }

    @Override
    public List<Student> display()  throws SQLException,ClassNotFoundException  {
        //create an array list that will contain the data recovered
        List<Student> Studentlist = new ArrayList<Student>();
        String quer1 = "Select * from studentinfo";
        PreparedStatement query = con.prepareStatement(quer1);
        ResultSet rs = query.executeQuery();
        Student obj1;
        //display records if there is data;
        while (rs.next()) {
            obj1 = new Student(rs.getString("studentid"), rs.getString("firstname"),rs.getString("lastname"));
            Studentlist.add(obj1);
        }
        return Studentlist;
    }


    // for Items table
    public List<take> display2(String studentid) throws ClassNotFoundException, SQLException {
        //create an array list that will contain the data recovered
        List<take> Itemlist = new ArrayList<take>();
        String quer1 = "Select coursename,building from take where studentid=?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, studentid);
        ResultSet rs = query.executeQuery();
        take obj2;


        //display records if there is data;
        while (rs.next()) {
            obj2 = new take(rs.getString("coursename"),rs.getString("building"));
            Itemlist.add(obj2);
        }
        return Itemlist;
    }
}
