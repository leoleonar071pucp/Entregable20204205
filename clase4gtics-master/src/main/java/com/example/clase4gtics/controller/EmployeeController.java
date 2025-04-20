package com.example.clase4gtics.controller;
import com.example.clase4gtics.entity.Employees;
import com.example.clase4gtics.entity.Jobs;
import com.example.clase4gtics.repository.DepartmentsRepository;
import com.example.clase4gtics.repository.EmployeeRepository;
import com.example.clase4gtics.repository.JobRepository;
import com.example.clase4gtics.repository.DepartmentsRepository;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {


    final EmployeeRepository employeeRepository;
    final JobRepository jobRepository;
    final DepartmentsRepository departmentsRepository;

    public EmployeeController(EmployeeRepository employeeRepository,
                                JobRepository jobRepository,
                                DepartmentsRepository departmentsRepository

    ) {
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
        this.departmentsRepository = departmentsRepository;
    }



    @GetMapping(value = {"/list", ""})
    public String hello(Model model) {

        model.addAttribute("listaEmpleados", employeeRepository.findAll());


        // Retornamos la vista que puede ser una página HTML simple o un mensaje
        return "employee/list"; // La vista que se renderiza puede ser un archivo .html o .jsp, dependiendo de tu configuración
    }

    @GetMapping("/nuevo")
    public String NuevoEmployee(Model model) {
        model.addAttribute("listaJobs", jobRepository.findAll());
        model.addAttribute("listaManagers",employeeRepository.findAllManagers());
        model.addAttribute("listaDepartamentos",departmentsRepository.findAll());
        return "employee/create";
    }

    @PostMapping("/guardar")
    public String SaveEmployee(Employees employees, RedirectAttributes attr) {
        employeeRepository.save(employees);
        return "redirect:/employee/list";
    }

    @GetMapping("/editar")
    public String EditarEmployee(Model model, @RequestParam("id") int id) {

        Optional<Employees> optEmployee = employeeRepository.findById(id);

        if (optEmployee.isPresent()) {
            Employees employees = optEmployee.get();
            model.addAttribute("Employee", employees);
            model.addAttribute("listaManagers",employeeRepository.findAllManagers());
            model.addAttribute("listaDepartamentos",departmentsRepository.findAll());
            return "product/editFrm";
        } else {
            return "redirect:/product";
        }
    }
}


