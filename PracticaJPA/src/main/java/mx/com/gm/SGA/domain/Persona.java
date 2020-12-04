package mx.com.gm.SGA.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 *
 * @author aledom
 */

@Entity

public class Persona implements Serializable{
    private static final long SerialVersionUID=1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id_persona")
    private int idpersona;
    private String Nombre;
    private String Apellidos;
    private int edad;
    private String Email;

    public Persona() {
    }

    public Persona(String Nombre, String Apellidos, int edad, String Email) {
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.edad = edad;
        this.Email = Email;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return "Persona{" + "idpersona=" + idpersona + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", edad=" + edad + ", Email=" + Email + '}';
    }
}
