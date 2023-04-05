package com.example.lab2_grupo10.Controllers;

import com.example.lab2_grupo10.Entity.Artista;
import com.example.lab2_grupo10.Entity.Proveedor;
import com.example.lab2_grupo10.repository.ArtistaRepository;
import com.example.lab2_grupo10.repository.ProveedorRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public class ProveedorController {

    final ProveedorRepository proveedorRepository;

    public ProveedorController(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @GetMapping("/listar")
    public String listar(Model model) {

        model.addAttribute("lista", proveedorRepository.findAll());
        return "proveedor/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo() {
        return "proveedor/nuevoForm";
    }

    @PostMapping("/guardar")
    public String guardar(Proveedor proveedor) {
        proveedorRepository.save(proveedor);
        System.out.println(proveedor.getId());

        return "redirect:/listar";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam("id") int id, Model model) {

        Optional<Proveedor> artistaOptional = proveedorRepository.findById(id);
        if (artistaOptional.isPresent()) {
            Proveedor proveedor = artistaOptional.get();
            model.addAttribute("artista", proveedor);
            return "artista/editarForm";
        } else {
            return "redirect:/listar";
        }
    }

    @GetMapping("/borrar")
    public String borrar(@RequestParam("id") int id) {
        Optional<Proveedor> proveedorOptional = proveedorRepository.findById(id);
        if (proveedorOptional.isPresent()) {
            proveedorRepository.deleteById(id);
        }
        return "redirect:/listar";

    }
}
