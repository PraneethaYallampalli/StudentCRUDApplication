package com.web.controller; // Ensure this matches your package structure

import com.web.model.Student;
import com.web.service.StudentServiceImp;

import ch.qos.logback.core.model.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student/")
public class StudentController {

    @Autowired
    private StudentServiceImp studentServiceImp;

    @GetMapping("/add")
    public String showCreateForm(ModelMap model) {
        model.addAttribute("student", new Student());
        return "/student/adddetails";
    }

    @PostMapping("/adddetails")
    public String createStudent(@ModelAttribute("student") Student student) {
        studentServiceImp.addstudent(student);
        return "/student/success";
    }
    @GetMapping("/studentlist")
    public String getAllStudents(ModelMap model) {
        model.addAttribute("students", studentServiceImp.getAllStudents());
        return "student/studentlist";
    }
    @RequestMapping("/delete/{id}")
    public String deleteStudent(@PathVariable long id) {
        studentServiceImp.deleteStudent(id);
        return "student/delete"; 
    }
    @GetMapping("/edit/{id}")
    public String studentUpdate(@PathVariable long id, ModelMap model) {
        Student studentData = studentServiceImp.getStudent(id);
       model.addAttribute("student",studentData);
        return "student/edit";
    }
    @PostMapping("/editupdated/{id}")
    public String update(@PathVariable long id,@ModelAttribute("student")Student student) {
    	 studentServiceImp.updateStudent(id,student);
    	return "/student/updatesuccess";
    }

}
