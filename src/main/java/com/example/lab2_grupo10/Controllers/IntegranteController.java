package com.example.lab2_grupo10.Controllers;

import com.example.lab2_grupo10.Entity.Integrante;
import com.example.lab2_grupo10.repository.ArtistaRepository;
import com.example.lab2_grupo10.repository.IntegranteRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public class IntegranteController {



    final IntegranteRepository integranteRepository;

    public IntegranteController(IntegranteRepository integranteRepository) {
        this.integranteRepository = integranteRepository;
    }

    @GetMapping("/listar")
    public String listar(Model model) {

        model.addAttribute("lista", integranteRepository.findAll());
        return "integrante/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo() {
        return "integrante/nuevoForm";
    }

    @PostMapping("/guardar")
    public String guardar(Integrante integrante) {
        integranteRepository.save(integrante);
        System.out.println(integrante.getId());

        return "redirect:/listar";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam("id") int id, Model model) {

        Optional<Integrante> integranteOptional = integranteRepository.findById(id);
        if (integranteOptional.isPresent()) {
            Integrante integrante = integranteOptional.get();
            model.addAttribute("artista", integrante);
            return "integrante/editarForm";
        } else {
            return "redirect:/listar";
        }
    }

    @GetMapping("/borrar")
    public String borrar(@RequestParam("id") int id) {
        Optional<Integrante> integranteOptional = integranteRepository.findById(id);
        if (integranteOptional.isPresent()) {
            integranteRepository.deleteById(id);
        }
        return "redirect:/listar";

    }
}
