package Paquete;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

/*
        4.Añadid alguna relación ManyToMany.

*/

@Entity
public class Veterinarios implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany(mappedBy = "veterinarios")
    private List<Mascotas>mascotas;

    public  Veterinarios(String nombre){
        this.nombre=nombre;
    }

    public Veterinarios(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Mascotas> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascotas> mascotas) {
        this.mascotas = mascotas;
    }
    @Override
    public String toString(){
        return "Veterinario [Id:  "+ id+ ", Nombre: "+ nombre + "]";
    }
}

