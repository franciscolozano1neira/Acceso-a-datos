package Reto2.Reto2AccesoADatos.src.Reto2;

import java.util.List;
import java.util.ArrayList;

public class Biblioteca {
	private nombreBiblioteca nombreBiblio;
	private List<Libro> libro = new ArrayList<>();
	
	public Biblioteca() {	}
	
	public Biblioteca(nombreBiblioteca nombreBiblio) {
		this.nombreBiblio = nombreBiblio;
	}
	
	public void add(Libro nuevoLibro) {
		libro.add(nuevoLibro);
}

	public List<Libro> getContent() {
	        return libro;
	}
}


