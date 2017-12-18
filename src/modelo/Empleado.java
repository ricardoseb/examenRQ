
package modelo;

/**
 *
 * @author Rquiroga
 */
public class Empleado {
    
    private int codigo;
    private String rut;
    private String nombre;
    private String apellido;
    private int celular;
    private String email;
    private int sueldo;
    private String estadoc;
    private String dpto;

    public Empleado() {
    }

    public Empleado(int codigo, String rut, String nombre, String apellido, int celular, String email, int sueldo, String estadoc, String dpto) {
        this.codigo = codigo;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.email = email;
        this.sueldo = sueldo;
        this.estadoc = estadoc;
        this.dpto = dpto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public String getEstadoc() {
        return estadoc;
    }

    public void setEstadoc(String estadoc) {
        this.estadoc = estadoc;
    }

    

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    @Override
    public String toString() {
        return "Empleado{" + "codigo=" + codigo + ", rut=" + rut + ", nombre=" + nombre + ", apellido=" + apellido + ", celular=" + celular + ", email=" + email + ", sueldo=" + sueldo + ", estadoc=" + estadoc + ", dpto=" + dpto + '}';
    }

    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }
    
    
    
    
}
