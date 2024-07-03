import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Producto> product_list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Mostrar Productos en Inventario.\n2. Añadir producto a Inventario.\n3. Venta.\n4. Mostrar Ganancias.\n5. Surtir Productos.\n6. Exit.");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    showProducts();
                    break;
                case 2:
                    addProduct(scanner);
                    break;
                case 3:
                    addSell(scanner);
                    break;
                case 4:
                    cGanancias();
                    break;
                case 5:
                    surtirProductos();
                    break;
                case 6:
                    System.out.println("Saliendo del programa");
                    scanner.close();
                    return;  // Exit the loop after closing the scanner
                default:
                    System.out.println("[!] Seleccione una opción válida.");
            }
        }
    }

    // funciones
    private static void showProducts() {
        if (!product_list.isEmpty()) {
            for (Producto product : product_list) {
                System.out.println(product);
            }
        } else {
            System.out.println("[!] No se han agregado productos al inventario.");
        }
    }

    private static void addProduct(Scanner scanner) {
        System.out.println("Enter name: ");
        String nombre = scanner.nextLine();

        System.out.println("Descripción del producto:");
        String descripcion = scanner.nextLine();

        System.out.println("Categoría del producto:");
        String nombreCategoria = scanner.nextLine();

        System.out.println("Punto de surtir:");
        int puntoSurtir = scanner.nextInt();

        System.out.println("Cantidad a surtir:");
        int cantidadSurtir = scanner.nextInt();

        scanner.nextLine();  // Consume the newline character

        Categoria categoria = new Categoria(nombreCategoria, puntoSurtir, cantidadSurtir);

        System.out.println("Precio de Venta:");
        double pVenta = scanner.nextDouble();

        System.out.println("Precio de Compra:");
        double pCompra = scanner.nextDouble();

        System.out.println("Cantidades a agregar:");
        int cantidad = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        boolean found = false;
        for (Producto product : product_list) {
            if (nombre.equals(product.getName())) {
                product.addCantidad(cantidad);
                System.out.println("Producto existente actualizado correctamente.");
                System.out.println("Nueva cantidad de " + product.getName() + ": " + product.getCantidad());
                found = true;
                break;
            }
        }

        if (!found) {
            Producto product = new Producto(nombre, descripcion, categoria, pVenta, pCompra, cantidad);
            product_list.add(product);
            System.out.println("Producto agregado correctamente.");
        }
    }

    private static void addSell(Scanner scanner) {
        System.out.println("Nombre del producto a vender: ");
        String nombre = scanner.nextLine();

        System.out.println("Cantidades a vender: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        boolean found = false;
        for (Producto product : product_list) {
            if (nombre.equals(product.getName())) {
                if (product.getCantidad() >= cantidad) {
                    product.reduceCantidad(cantidad);
                    System.out.println("Producto vendido correctamente.");
                    found = true;
                    if (product.getCantidad() == 0) {
                        product_list.remove(product);
                    }
                    break;
                } else {
                    System.out.println("[!] No hay suficiente cantidad en inventario para realizar la venta.");
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("[!] El producto no se encontró en el inventario.");
        }
    }

    private static void cGanancias() {
        double totalGanancias = 0;
        for (Producto product : product_list) {
            double gananciaProducto = product.calcularGanancia();
            System.out.println("Producto: " + product.getName() + ", Cantidad Vendida: " + product.getCantidadVendida() + ", Ganancia: $" + gananciaProducto);
            totalGanancias += gananciaProducto;
        }
        System.out.println("Las ganancias totales son: $" + totalGanancias);
    }

    private static void surtirProductos() {
        System.out.println("Productos a surtir:");
        for (Producto product : product_list) {
            Categoria categoria = product.getCategoria();
            if (product.getCantidad() <= categoria.getPuntoSurtir()) {
                System.out.println("Producto: " + product.getName() +
                        ", Cantidad Actual: " + product.getCantidad() +
                        ", Punto de Surtir: " + categoria.getPuntoSurtir() +
                        ", Cantidad a Surtir: " + categoria.getCantidadSurtir());
                product.addCantidad(categoria.getCantidadSurtir());
            }
        }
    }
}

