package Principal;

import Exceptions.*;

import java.io.Serializable;

public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    private int codigo;
    private String nombre;
    private double precio;
    private int stock;
    private Proveedor proveedor;

    public Producto(int codigo, String nombre, double precio, int stock, Proveedor proveedor) throws ValorInvalidoException {
        if (precio <= 0) { throw new ValorInvalidoException("Precio invalido"); }
        if (stock < 0) { throw new ValorInvalidoException("Stock invalido"); }
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.proveedor = proveedor;
    }

    public int getCodigo() {return codigo;}

    public Proveedor getProveedor() {return proveedor;}

    public void aumentarStock(int aumento) {stock += aumento;}

    public void vender(int cantidad) throws StockInsuficienteException {
        if (cantidad > stock) {
            throw new StockInsuficienteException("Cantidad insuficiente de productos");
        }
        stock -= cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo= " + codigo + ", nombre= " + nombre + ", precio= " + precio + ", stock= " + stock + " | " + proveedor.toString() + '}';
    }
}
