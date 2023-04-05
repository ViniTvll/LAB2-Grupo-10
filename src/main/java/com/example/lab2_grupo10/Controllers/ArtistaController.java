package com.example.lab2_grupo10.Controllers;

import com.example.lab2_grupo10.Entity.Artista;
import com.example.lab2_grupo10.repository.ArtistaRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@RequestMapping("/artista")
public class ArtistaController {


    final ArtistaRepository artistaRepository;

    public ArtistaController(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

    @GetMapping("/listar")
    public String listar(Model model) {

        model.addAttribute("lista", artistaRepository.findAll());
        return "artista/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo() {
        return "artista/nuevoForm";
    }

    @PostMapping("/guardar")
    public String guardar(Artista artista) {
        artistaRepository.save(artista);
        System.out.println(artista.getId());

        return "redirect:/listar";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam("id") int id, Model model) {

        Optional<Artista> artistaOptional = artistaRepository.findById(id);
        if (artistaOptional.isPresent()) {
            Artista artista = artistaOptional.get();
            model.addAttribute("artista", artista);
            return "artista/editarForm";
        } else {
            return "redirect:/listar";
        }
    }

    @GetMapping("/borrar")
    public String borrar(@RequestParam("id") int id) {
        Optional<Artista> artistaOptional = artistaRepository.findById(id);
        if (artistaOptional.isPresent()) {
            artistaRepository.deleteById(id);
        }
        return "redirect:/listar";

    }
}
