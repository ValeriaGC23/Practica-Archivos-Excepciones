import Exceptions.*;
import Principal.Cliente;
import Principal.Producto;
import Principal.Proveedor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Portafolio
        Portafolio portafolio = new Portafolio(5, 20, 7);

        //Proveedores
        Proveedor proveedor1 = new Proveedor(82686, "Tech Solutions", "555-012-3453");
        Proveedor proveedor2 = new Proveedor(20054, "Apple Inc", "154-234-7857");
        Proveedor proveedor3 = new Proveedor(50321, "Logística Flash", "016-800-9997");

        portafolio.agregarProveedor(proveedor1);
        portafolio.agregarProveedor(proveedor2);
        portafolio.agregarProveedor(proveedor3);

        //Clientes
        Cliente c1 = new Cliente(12435543, "Marta Gonzalez", "marta@gmail.com");
        Cliente c2 = new Cliente(98765432, "Carlos Ramirez", "c.ramirez@outlook.com");
        Cliente c3 = new Cliente(45678, "Lucia Fernandez", "lucia.f88@yahoo.com");

        portafolio.agregarCliente(c1);
        portafolio.agregarCliente(c2);
        portafolio.agregarCliente(c3);

        //Productos
        Producto p1 = new Producto(234, "Impresora Samsung", 750097.8, 3, proveedor3);
        Producto p2 = new Producto(501, "Monitor LG 27'", 485000.5, 15, proveedor1);
        Producto p3 = new Producto(882, "Teclado Mecánico RGB", 1235900.0, 8, proveedor2);

        portafolio.agregarProducto(p1);
        portafolio.agregarProducto(p2);
        portafolio.agregarProducto(p3);

        //Menu
        Scanner sc = new Scanner(System.in);
        int opcion;

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

                    System.out.print("Ingrese telefono: ");
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

                    System.out.println("Proveedor registrado con exito");
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




            }

        } while (true);
    }
}
