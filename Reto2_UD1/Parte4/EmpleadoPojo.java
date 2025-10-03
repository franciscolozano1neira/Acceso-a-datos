package Reto2.Reto2AccesoADatos.src.Parte4;

public class EmpleadoPojo {
        private int id;
        private String nombre;
        private String apellidos;
        private int edad;
        private String direccion;
        private String titulo;
        private boolean activo;
        private int numeroEmp;
        private String fechaAlta;
        private boolean carnetConducir;
        private String fechaNacimiento;

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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public int getNumeroEmp() {
        return numeroEmp;
    }

    public void setNumeroEmp(int numeroEmp) {
        this.numeroEmp = numeroEmp;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public boolean isCarnetConducir() {
        return carnetConducir;
    }

    public void setCarnetConducir(boolean carnetConducir) {
        this.carnetConducir = carnetConducir;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}

