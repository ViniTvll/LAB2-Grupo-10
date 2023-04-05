package com.example.lab2_grupo10.Entity;


import jakarta.persistence.*;

@Entity
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "IdProveedores", nullable= false)
    private int id;


    @Column(name="Nombre",nullable = false, length=45)
    private String nombre;


    @Column(name="Telefono", nullable = false)
    private int telefono;


    @Column(name="Elemento",nullable = false, length=45)
    private String elemento;


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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }
}
