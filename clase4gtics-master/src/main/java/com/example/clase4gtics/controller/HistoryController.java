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
@RequestMapping("/history")
public class HistoryController {


    final EmployeeRepository employeeRepository;
    final JobHistoryRepository jobHistoryRepository;
    final DepartmentsRepository departmentsRepository;

    public HistoryController(EmployeeRepository employeeRepository,
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



    @GetMapping("/buscar")
    public String buscarEmpleado(Model model, @RequestParam("search") String search) {
        List<Employees> listaEmpleados = employeeRepository.buscarPorNombreApellidoPuestoDepartamentoCiudad(search);
        model.addAttribute("listaEmpleados", listaEmpleados);
        return "employee/list";
    }

}


