import Exceptions.CapacidadMaximaException;
import Exceptions.CodigoDuplicadoException;
import Exceptions.ProductoNoExisteException;
import Exceptions.ProveedorNoExisteException;
import Principal.Cliente;
import Principal.Producto;
import Principal.Proveedor;

import java.io.Serializable;

public class Portafolio implements Serializable {
    private static final long serialVersionUID = 1L;
    private Proveedor[] proveedores;
    private Cliente[] clientes;
    private Producto[] productos;
    private int nProveedores;
    private int nClientes;
    private int nProductos;
    private int contadorProveedores;
    private int contadorClientes;
    private int contadorProductos;

    public Portafolio(int nProveedores, int nClientes, int nProductos) {
        this.nProveedores = nProveedores;
        this.nClientes = nClientes;
        this.nProductos = nProductos;
        this.proveedores = new Proveedor[nProveedores];
        this.clientes = new Cliente[nClientes];
        this.productos = new Producto[nProductos];
        this.contadorProveedores = 0;
        this.contadorClientes = 0;
        this.contadorProductos = 0;
    }

    public void agregarProveedor(Proveedor proveedor) throws CapacidadMaximaException, CodigoDuplicadoException{
        if (contadorProveedores == nProveedores) {
            throw new CapacidadMaximaException("Capacidad maxima de proveedores alcanzada");
        } else {
            for (int i=0; i<contadorProveedores; i++) {
                if (proveedores[i].getId() == proveedor.getId()) {
                    throw new CodigoDuplicadoException("El proveedor ya existe");
                }
            }
        }
        proveedores[contadorProveedores] = proveedor;
        contadorProveedores++;
    }

    public void agregarCliente(Cliente cliente) throws CapacidadMaximaException, CodigoDuplicadoException {
        if (contadorClientes == nClientes) {
            throw new CapacidadMaximaException("Capacidad maxima de clientes alcanzada");
        } else {
            for (int i=0; i<contadorClientes; i++) {
                if (clientes[i].getId() == cliente.getId()) {
                    throw new CodigoDuplicadoException("El cliente ya existe");
                }
            }
        }
        clientes[contadorClientes] = cliente;
        contadorClientes++;
    }


    public void agregarProducto(Producto producto) throws CapacidadMaximaException, CodigoDuplicadoException {
        if (contadorProductos == nProductos) {
            throw new CapacidadMaximaException("Capacidad maxima de productos alcanzada");
        } else {
            for (int i=0; i<contadorProductos; i++) {
                if (productos[i].getCodigo() == producto.getCodigo()) {
                    throw new CodigoDuplicadoException("El producto ya existe");
                }
            }
        }
        productos[contadorProductos] = producto;
        contadorProductos++;
    }

    public Proveedor buscarProveedor(int idProveedor) throws ProveedorNoExisteException {
        for (int i=0; i<contadorProveedores; i++) {
            if (proveedores[i].getId() == idProveedor) {
                return proveedores[i];
            }
        }
        throw new ProveedorNoExisteException("Proveedor no existe");
    }

    public Producto buscarProducto(int codigo) throws ProductoNoExisteException {
        for (int i=0; i<contadorProductos; i++) {
            if (productos[i].getCodigo() == codigo) {
                return productos[i];
            }
        }
        throw new ProductoNoExisteException("El producto no existe");
    }

    public void listarProveedores() {
        for (int i=0; i<contadorProveedores; i++) {
            System.out.println(proveedores[i]);
        }
    }

    public void listarClientes() {
        for (int i=0; i<contadorClientes; i++) {
            System.out.println(clientes[i]);
        }
    }

    public void listarProductos() {
        for (int i=0; i<contadorProductos; i++) {
            System.out.println(productos[i]);
        }
    }

}
