package com.example.employee.Controller;

import com.example.employee.Model.Emp;
import com.example.employee.Repository.empReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller//Controller used to indicate this class is a controller to handle API end points
public class empController {
    @Autowired
    empReposiory empRepo;//Repository object created

    @GetMapping("/index.page")
    public String index() {
        return "index"; // loads index.html
    }
    @PostMapping("/save")//Post Api to save the data into to the database
    public String addStudent(@RequestParam Long empid,
                           @RequestParam String empname,
                           @RequestParam String empEmail,
                           @RequestParam String empLocation){
        Emp emp = new Emp();
        emp.setEmpId(empid);
        emp.setEmpname(empname);
        emp.setEmpEmail(empEmail);
        emp.setEmpLocation(empLocation);
        empRepo.save(emp);
        return "redirect:/";//redirect to the home page(index)again

    }
    @GetMapping("/displayAll")//Get api to display all datas in the database
    public ResponseEntity<List<Emp>> getAllData(){
        return new ResponseEntity<>(empRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping("display/{id}")//To get a specific data's using ID
    public ResponseEntity<Emp> getEmployeeById(@PathVariable Long id) {
            Optional<Emp> emp = empRepo.findById(id);//to unwrapp
            if (emp.isPresent()) {
                return ResponseEntity.ok(emp.get());
            } else {
                return ResponseEntity.notFound().build();
            }

    }


}
