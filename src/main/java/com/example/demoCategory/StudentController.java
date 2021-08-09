package com.example.demoCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SessionAttributes({"id","fname","lname","errMsg","errorMessage"})
@RequestMapping
@Controller
public class StudentController {

    DatabaseService service1;

    //   @Autowired
//    Categoryservice service;

    @Autowired
    ConnectionStudent connect;

//    @Autowired
//    Connection1 con;


    //a mapping when someone enters file
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String showCategorypage(ModelMap model,@RequestParam(defaultValue = "") String id) throws ClassNotFoundException, SQLException {

        service1 = new DatabaseService(connect.connect());
        model.addAttribute("todos",service1.display());



        //    model.addAttribute("todos", service.retrieveTodos());


        List<Student> filteredTodos = new ArrayList<Student>();

        filteredTodos = (List) model.get("todos");

        model.put("id",filteredTodos.get(0).getStudentid());



        model.put("fname",filteredTodos.get(0).getFirstname());

        model.put("lname",filteredTodos.get(0).getLastname());
        return "students";


    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showCategoryPage2(ModelMap model)  throws ClassNotFoundException, SQLException  {

        service1 = new DatabaseService(connect.connect());

        model.addAttribute("todos",service1.display());

//        model.addAttribute("todos", service.retrieveTodos());


        List<Student> filteredTodos = new ArrayList<Student>();

        filteredTodos = (List) model.get("todos");

        model.put("id",filteredTodos.get(0).getStudentid());



        model.put("fname",filteredTodos.get(0).getFirstname());

        model.put("lname",filteredTodos.get(0).getLastname());

        return "students";




    }

    @RequestMapping(value ="/add-todo", method = RequestMethod.GET)
    public String showtodopage(){
        return "studentser";
    }


    @RequestMapping(value ="/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @RequestParam String studentid, @RequestParam String firstname, @RequestParam String lastname) throws SQLException, ClassNotFoundException{


        if (!((service1.search(studentid)) ==null)){
            model.put("errorMessage","Record Existing");
            return "redirect:/students";
        }
        Student cc = new Student(studentid,firstname,lastname);

        service1.add(cc);
        // service.addTodo(catcode,catdesc);

//code cu tu lab 4



        model.clear();
        return "redirect:/students";
    }


    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(ModelMap model,  @RequestParam(defaultValue = "") String id) throws SQLException, ClassNotFoundException{

        model.put("id", id);

        Student cc = service1.search(id);
        model.put("id",cc.getStudentid());
        model.put("fname", cc.getFirstname());
        model.put("lname", cc.getLastname());

        //     model.addAttribute("category",service.retrieve(id));
        /* code cu tu lab4*/
//        Category x = service.retrieve(id);
//
//        model.put("id",x.getCatcode());
//        model.put("desc", x.getCatdesc());



        return "studentedit";
    }



    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String showUpdate(ModelMap model,  @RequestParam String studentid, @RequestParam String firstname, @RequestParam String lastname) throws SQLException, ClassNotFoundException {

//get the old catcode
        String iid = (String) model.get("id");
        Student cc = new Student(studentid, firstname, lastname);
        service1.edit(cc,iid);





//        String iid = (String) model.get("id");

//        service.deleteTodo(iid);
//
//        service.addTodo(catcode,catdesc);



        return "redirect:/";

    }



    @RequestMapping(value ="/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(ModelMap model, @RequestParam String id) throws SQLException, ClassNotFoundException {

        service1.delete(id);
        model.clear();
//        service.deleteTodo(id);
//
//
//
//        model.clear();
        return "redirect:/";
    }

    @RequestMapping(value ="/see-todo", method = RequestMethod.GET)
    public String seetodo(ModelMap model, @RequestParam(defaultValue = "") String id) throws SQLException, ClassNotFoundException {

        model.put("id", id);

        service1 = new DatabaseService(connect.connect());

        String iid = (String) model.get("id");

        List<take> Takelist = new ArrayList<>();

        Takelist = service1.display2(iid);

        if(Takelist.size()==0){
            model.put("errorMessage"," No course available ");
            return "redirect:/";
        }
        model.put("fname",iid);
        model.put("lname",iid);
        System.out.println(iid);
        model.addAttribute("todos1", service1.display2(iid));
        return "take";
    }


    @RequestMapping(value ="/see-todo", method = RequestMethod.POST)
    public String seetodo2(ModelMap model) throws SQLException, ClassNotFoundException {
        return "redirect:/";
    }


}
