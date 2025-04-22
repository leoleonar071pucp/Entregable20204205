package com.example.clase4gtics.controller;
import com.example.clase4gtics.entity.Employees;
import com.example.clase4gtics.entity.Jobs;
import com.example.clase4gtics.repository.DepartmentsRepository;
import com.example.clase4gtics.repository.EmployeeRepository;
import com.example.clase4gtics.repository.JobHistoryRepository;
import com.example.clase4gtics.repository.DepartmentsRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {


    final EmployeeRepository employeeRepository;
    final JobHistoryRepository jobHistoryRepository;
    final DepartmentsRepository departmentsRepository;

    public EmployeeController(EmployeeRepository employeeRepository,
                                JobHistoryRepository jobHistoryRepository,
                                DepartmentsRepository departmentsRepository

    ) {
        this.employeeRepository = employeeRepository;
        this.jobHistoryRepository = jobHistoryRepository;
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
        model.addAttribute("listaJobs", jobHistoryRepository.findAll());
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
    public String EditarEmployee(Model model,@RequestParam("id") int id) {

        Optional<Employees> optEmployee = employeeRepository.findById(id);

        if (optEmployee.isPresent()) {
            Employees employees = optEmployee.get();
            model.addAttribute("employee", employees);
            model.addAttribute("listaJobs", jobHistoryRepository.findAll());
            model.addAttribute("listaManagers",employeeRepository.findAllManagers());
            model.addAttribute("listaDepartamentos",departmentsRepository.findAll());
            return "employee/edit";
        } else {
            return "redirect:/employee/list";
        }


    }

    @GetMapping("/borrar")
    public String DeleteEmployee(Model model,@RequestParam("id") int id,
                                      RedirectAttributes attr) {

        Optional<Employees> optEmployee = employeeRepository.findById(id);

        if (optEmployee.isPresent()) {
            employeeRepository.deleteById(id);
        }
        return "redirect:/employee/list";

    }

    @GetMapping("/buscar")
    public String buscarEmpleado(Model model, @RequestParam("search") String search) {
        List<Employees> listaEmpleados = employeeRepository.buscarPorNombreApellidoPuestoDepartamentoCiudad(search);
        model.addAttribute("listaEmpleados", listaEmpleados);
        return "employee/list";
    }

}


