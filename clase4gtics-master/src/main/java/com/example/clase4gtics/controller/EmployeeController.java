package com.example.clase4gtics.controller;

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

    // Eliminamos el ShipperRepository porque ya no lo necesitamos
    // final ShipperRepository shipperRepository;

    // Ya no es necesario el constructor con el repository

    @GetMapping(value = {"/list", ""})
    public String hello(Model model) {
        // Puedes agregar un atributo al modelo si lo necesitas, pero no es necesario
        model.addAttribute("message", "Hello");

        // Retornamos la vista que puede ser una página HTML simple o un mensaje
        return "hello"; // La vista que se renderiza puede ser un archivo .html o .jsp, dependiendo de tu configuración
    }
}


