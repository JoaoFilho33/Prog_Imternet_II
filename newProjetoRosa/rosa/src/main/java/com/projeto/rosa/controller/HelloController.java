package com.projeto.rosa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/teste")
    public String teste(@RequestParam(value = "name", required = false, defaultValue = "Hello Word") String name, Model model) {
        model.addAttribute( "name", name);

        return "teste";
    }

    @GetMapping("/teste/{id}")
    public String getTesteById(@PathVariable Long id, Model model) {
        // Aqui você pode recuperar os dados do recurso com o ID fornecido
        // e adicionar os dados ao modelo antes de retornar o template "teste"
        return "teste";
    }



}
