import Exceptions.*;
import Principal.Cliente;
import Principal.Producto;
import Principal.Proveedor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Portafolio portafolio;

        java.io.File archivo = new java.io.File("portafolio.dat");
        if (archivo.exists()) {
            portafolio = PersistenciaLectura.leer("portafolio.dat"); // carga lo guardado
        } else {
            portafolio = new Portafolio(5, 20, 7); // solo si no existe el archivo
        }

        //Menu
        Scanner sc = new Scanner(System.in);
        int opcion;
        boolean continuar = true;

        do{
            System.out.println("\n------ BIENVENIDO A NUESTRO PORTAFOLIO ------ \n");
            System.out.println("Escriba el numero de la opcion que desea:");
            System.out.println("1. Registrar proveedor");
            System.out.println("2. Registrar cliente");
            System.out.println("3. Registrar producto");
            System.out.println("4. Listar proveedores");
            System.out.println("5. Listar clientes");
            System.out.println("6. Listar productos");
            System.out.println("7. Buscar producto por codigo");
            System.out.println("8. Aumentar stock de un producto");
            System.out.println("9. Registrar venta");
            System.out.println("10. Guardar portafolio en archivo");
            System.out.println("11. Cargar portafolio desde archivo");
            System.out.println("12. Salir \n");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){
                case 1:
                    System.out.print("Ingrese id: ");
                    int idProveedor = Integer.parseInt(sc.nextLine());

                    System.out.print("Ingrese nombre: ");
                    String nombreProveedor = sc.nextLine();

                    System.out.print("Ingrese telefono: ");
                    String telefonoProveedor = sc.nextLine();

                    try{
                        Proveedor nuevoProveedor = new Proveedor(idProveedor,nombreProveedor ,telefonoProveedor);
                        portafolio.agregarProveedor(nuevoProveedor);
                    } catch(CapacidadMaximaException | CodigoDuplicadoException e) {
                        System.out.println(e.getMessage() + " - Proveedor no creado\n");
                        break;
                    }

                    System.out.println("Proveedor registrado con exito!!");
                    break;

                case 2:
                    System.out.print("Ingrese id: ");
                    int idCliente = Integer.parseInt(sc.nextLine());

                    System.out.print("Ingrese nombre: ");
                    String nombreCliente = sc.nextLine();

                    System.out.print("Ingrese email: ");
                    String emailCliente = sc.nextLine();

                    try{
                        Cliente nuevoCliente = new Cliente(idCliente,nombreCliente,emailCliente);
                            portafolio.agregarCliente(nuevoCliente);
                    } catch(CapacidadMaximaException | CodigoDuplicadoException e) {
                        System.out.println(e.getMessage() + " - Cliente no creado\n");
                        break;
                    }

                    System.out.println("Cliente registrado con exito");
                    break;

                case 3:
                    System.out.print("Ingrese codigo: ");
                    int codigoProducto = Integer.parseInt(sc.nextLine());

                    System.out.print("Ingrese nombre: ");
                    String nombreProducto = sc.nextLine();

                    System.out.print("Ingrese precio: ");
                    double precioProducto = Double.parseDouble(sc.nextLine());

                    System.out.print("Ingrese stock: ");
                    int stockProducto = Integer.parseInt(sc.nextLine());

                    System.out.print("Ingrese id del proveedor: ");
                    int idProv = Integer.parseInt(sc.nextLine());
                    Proveedor proveedorProducto;

                    try {
                        proveedorProducto = portafolio.buscarProveedor(idProv);
                    } catch(ProveedorNoExisteException e) {
                        System.out.println(e.getMessage() + " - Producto no creado\n");
                        break;
                    }

                    try{
                        Producto nuevoProducto = new Producto(codigoProducto ,nombreProducto ,precioProducto, stockProducto, proveedorProducto);
                        portafolio.agregarProducto(nuevoProducto);
                    } catch(CapacidadMaximaException | CodigoDuplicadoException | ValorInvalidoException e) {
                        System.out.println(e.getMessage() + "- Producto no creado\n");
                        break;
                    }

                    System.out.println("Producto registrado con exito");
                    break;

                case 4:
                    portafolio.listarProveedores();
                    break;

                case 5:
                    portafolio.listarClientes();
                    break;

                case 6:
                    portafolio.listarProductos();
                    break;

                case 7:
                    System.out.print("Ingrese el codigo del producto: ");
                    int codigo = Integer.parseInt(sc.nextLine());
                    Producto producto;

                    try {
                        producto = portafolio.buscarProducto(codigo);
                    } catch(ProductoNoExisteException e) {
                        System.out.println(e.getMessage() + "\n");
                        break;
                    }

                    System.out.println(producto.toString());
                    break;

                case 8:
                    System.out.print("Ingrese el codigo del producto: ");
                    int codigo2 = Integer.parseInt(sc.nextLine());
                    Producto producto2;

                    try {
                        producto2 = portafolio.buscarProducto(codigo2);
                    } catch(ProductoNoExisteException e) {
                        System.out.println(e.getMessage() + "\n");
                        break;
                    }

                    System.out.print("Ingrese la cantidad de unidades nuevas del producto: ");
                    int cantidad = Integer.parseInt(sc.nextLine());
                    producto2.aumentarStock(cantidad);
                    System.out.println("Stock actualizado con exito");
                    break;

                case 9:
                    System.out.print("Ingrese el codigo del producto: ");
                    int codigo3 = Integer.parseInt(sc.nextLine());
                    Producto producto3;

                    try {
                        producto3 = portafolio.buscarProducto(codigo3);
                    } catch(ProductoNoExisteException e) {
                        System.out.println(e.getMessage() + "\n");
                        break;
                    }

                    System.out.print("Ingrese la cantidad de unidades vendidas del producto: ");
                    int cantidad2 = Integer.parseInt(sc.nextLine());
                    try{
                        producto3.vender(cantidad2);
                    } catch(StockInsuficienteException e) {
                        System.out.println(e.getMessage() + " - Venta no valida\n");
                        break;
                    }

                    System.out.println("Stock actualizado con exito");
                    break;

                case 10:
                    Persistencia.guardar("portafolio.dat", portafolio);
                    break;

                case 11:
                    Portafolio portafolioLeido = PersistenciaLectura.leer("portafolio.dat");
                    portafolioLeido.listarProveedores();
                    portafolioLeido.listarClientes();
                    portafolioLeido.listarProductos();
                    break;

                case 12:
                    Persistencia.guardar("portafolio.dat", portafolio);
                    System.out.println("Hasta luego!");
                    continuar = false;
                    break;
            }
        } while (continuar);
    }
}
