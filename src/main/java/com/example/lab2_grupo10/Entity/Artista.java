package com.example.lab2_grupo10.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="idArtistas",nullable = false)
    private int id;


    @Column(name= "Nombre_Grupo", nullable= false, length=45)
    private String nombre;


    @Column(name="Tipo_musica", nullable = false, length=45)
    private String tipoMusica;

    @Column(name="Fecha_creacion",nullable = false)
    private String fechaCreacion;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoMusica() {
        return tipoMusica;
    }

    public void setTipoMusica(String tipoMusica) {
        this.tipoMusica = tipoMusica;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
