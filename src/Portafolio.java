import Exceptions.CapacidadMaximaException;
import Exceptions.CodigoDuplicadoException;
import Exceptions.ProductoNoExisteException;
import Exceptions.ProveedorNoExisteException;
import Principal.Cliente;
import Principal.Producto;
import Principal.Proveedor;

public class Portafolio {
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
            for (Proveedor p : proveedores) {
                if (p.getId() == proveedor.getId()) {
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
            for (Cliente c : clientes) {
                if (c.getId() == cliente.getId()) {
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
            for (Producto p : productos) {
                if (p.getCodigo() == producto.getCodigo()) {
                    throw new CodigoDuplicadoException("El producto ya existe");
                }
            }
        }
        productos[contadorProductos] = producto;
        contadorProductos++;
    }

    public Proveedor buscarProveedor(int idProveedor) throws ProveedorNoExisteException {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getId() == idProveedor) {
                return proveedor;
            }
        }
        throw new ProveedorNoExisteException("Principal.Proveedor no existe");
    }

    public Producto buscarProducto(int codigo) throws ProductoNoExisteException {
        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo) {
                return producto;
            }
        }
        throw new ProductoNoExisteException("Principal.Producto no existe");
    }

    public void listarProveedores() {
        for (Proveedor proveedor : proveedores) {
            System.out.println(proveedor);
        }
    }

    public void listarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public void listarProductos() {
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

}
