package reto2.parte3_3;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


public class Empleado {
 
    private int id;
    private String nombre;
    private String titulo;
    private boolean activo=false;
    private Integer numeroEmpl;
    private Date fechaAlta;

    public Empleado(){
    };

    public Empleado(int id, String nombre, String titulo, boolean activo, int numeroEmpl, Date fechaAlta) {
        this.id = id;
        this.nombre = nombre;
        this.titulo = titulo;
        this.activo = activo;
        this.numeroEmpl = numeroEmpl;
        this.fechaAlta = fechaAlta;
    }

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
 
    public String getTitulo() {
        return titulo;
    }
 
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
 
    public boolean isActivo() {
        return activo;
    }
 
   
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
 
    public Integer getNumeroEmpl() {
        return numeroEmpl;
    }
 
    
    public void setNumeroEmpl(Integer numeroEmpl) {
        this.numeroEmpl = numeroEmpl;
    }
 
    public Date getFechaAlta() {
        return fechaAlta;
    }
 
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }


	@Override
	public String toString() {
		DateFormat formatter = DateFormat.getDateInstance(DateFormat.FULL,
                new Locale("es"));
		return "Empleado [id=" + id + ", nombre=" + nombre + ", titulo="
				+ titulo + ", activo=" + activo + ", numeroEmpl=" + numeroEmpl
				+ ", fechaAlta=" + formatter.format(fechaAlta) + "]";
	}
    
    
 
}

