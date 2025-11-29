package reto2.parte2;

public class Libro {
	String titulo;
	String autor;
	String editorial;
	int pagina;
	int AñoPublicacion;

	public Libro(){}

	public Libro(String titulo, String autor, String editorial, int pagina, int añoPublicacion) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.pagina = pagina;
		AñoPublicacion = añoPublicacion;
	}
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", pagina=" + pagina
				+ ", AñoPublicacion=" + AñoPublicacion + "]\n";
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getPagina() {
		return pagina;
	}

	public void setPagina(int pagina) {
		this.pagina = pagina;
	}

	public int getAñoPublicacion() {
		return AñoPublicacion;
	}

	public void setAñoPublicacion(int añoPublicacion) {
		AñoPublicacion = añoPublicacion;
	}
}
