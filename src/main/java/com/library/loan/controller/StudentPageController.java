package com.library.loan.controller;

import com.library.loan.model.Student;
import com.library.loan.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentPageController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/students/page")
    public String showStudentsPage(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "students"; // Renders templates/students.html
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("student", new Student());
        return "register";
    }

    @PostMapping("/register")
    public String processRegister(@ModelAttribute Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        studentRepository.save(student);
        return "redirect:/login";
    }

    public String deleteStudent(@PathVariable Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return "Student deleted";
        } else {
            return "Student not found";
        }
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
