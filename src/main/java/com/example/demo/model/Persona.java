package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Persona {
    @Id
    private String rut;
    private String nombre;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<Vehiculo> vehiculos;

    public Persona() {
        this.rut = "";
        this.nombre = "";
        this.vehiculos = new ArrayList<Vehiculo>();
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getRut() {
        return this.rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setVehiculos(ArrayList<Vehiculo> lista) {
        this.vehiculos = lista;
    }

    public List<Vehiculo> getVehiculos() {
        return this.vehiculos;
    }
}
