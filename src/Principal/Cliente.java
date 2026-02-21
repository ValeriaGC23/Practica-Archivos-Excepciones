package Principal;

import java.io.Serializable;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private String email;

    public Cliente(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public int getId() {return id;}

    @Override
    public String toString() {
        return  "Cliente{" + "id= " + id + ", nombre= " + nombre + ", email= " + email + '}';
    }
}
