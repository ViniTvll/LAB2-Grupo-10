package com.example.lab2_grupo10.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Integrante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idArtistas",nullable = false)
    private int id;

    @Column(name= "Nombre", nullable= false, length=45)
    private String nombre;


    @Column(name="Edad", nullable = false)
    private int tipoMusica;

    @Column(name="Anhios_exp",nullable = false)
    private int fechaCreacion;

    @Column(name="rol",nullable = false, length=40)
    private String rol;


    @Column(name="artistas_idArtistas",nullable = false)
    private int artistas_id;

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

    public int getTipoMusica() {
        return tipoMusica;
    }

    public void setTipoMusica(int tipoMusica) {
        this.tipoMusica = tipoMusica;
    }

    public int getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(int fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getArtistas_id() {
        return artistas_id;
    }

    public void setArtistas_id(int artistas_id) {
        this.artistas_id = artistas_id;
    }
}
