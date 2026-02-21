package Principal;

import java.io.Serializable;

public class Proveedor implements Serializable {
    private int id;
    private String nombre;
    private String telefono;

    public Proveedor(int id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getId() {return id;}

    @Override
    public String toString() {
        return "Principal.Proveedor{" + "id= " + id + ", nombre= " + nombre + '}';
    }
}
