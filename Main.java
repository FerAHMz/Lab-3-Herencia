import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Clase principal que contiene la lógica para gestionar el inventario del bar.
 */
public class Main {
    /** Lista que almacena todos los productos del inventario. */
    private static ArrayList<Producto> productos = new ArrayList<>();

    /**
     * Método principal que inicia la aplicación.
     *
     * @param args Argumentos de línea de comando.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean go = true;
        int opcion;

        cargarCSV("Inventario.csv");

        while (go) {
            printMenu();
            opcion = sc.nextInt();
            sc.nextLine();  // Consume el salto de línea restante
            switch (opcion) {
                case 1:
                    // Buscar un producto por ID
                    System.out.print("Ingrese el ID del producto: ");
                    int idBusqueda = sc.nextInt();
                    Producto productoEncontrado = buscarProductoPorID(idBusqueda);

                    if (productoEncontrado != null) {
                        System.out.println("Producto encontrado:");
                        productoEncontrado.imprimirDetalles();
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 2:
                    // Listar categoría de productos
                    System.out.println("Las siguientes categorías están disponibles: ");
                    System.out.println("Bebida");
                    System.out.println("Snack");
                    System.out.println("NuevaCategoria");
                    System.out.print("Ingrese la categoría a listar: ");
                    String categoria = sc.nextLine();
                    listarProductosPorCategoria(categoria);
                    break;
                case 3:
                    // Mostrar las ventas actuales más comisión
                    mostrarVentasYComision();
                    break;
                case 4:
                    mostrarTotalProductosPorCategoria();
                    break;
                case 5:
                    go = false;
                    break;
            }
        }
        sc.close();
    }

    /**
     * Imprime el menú principal de opciones.
     */
    public static void printMenu() {
        System.out.println("\nBienvenido al bar");
        System.out.println("1. Buscar un producto por ID");
        System.out.println("2. Listar categoría de productos");
        System.out.println("3. Mostrar las ventas actuales más comisión");
        System.out.println("4. Mostrar total de productos por categoría");
        System.out.println("5. Salir");
        System.out.print("Ingrese una opción: ");
    }

    /**
     * Carga los productos desde un archivo CSV al inventario.
     *
     * @param nombreArchivo Nombre del archivo CSV.
     */
    public static void cargarCSV(String nombreArchivo) {
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            boolean primeraLinea = true;

            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(";", -1); // El argumento -1 permite conservar los valores vacíos

                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }

                int id = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                int cantidadDisponible = partes[2].isEmpty() ? 0 : Integer.parseInt(partes[2]);
                int cantidadVendidos = partes[3].isEmpty() ? 0 : Integer.parseInt(partes[3]);
                String estado = partes[4];
                int precio = Integer.parseInt(partes[5]);
                String categoria = partes[6];

                switch (categoria) {
                    case "Bebida":
                        int ml = Integer.parseInt(partes[7]);
                        String tipo = partes[8];
                        productos.add(new Bebida(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio, ml, tipo));
                        break;
                    case "Snack":
                        int gramos = Integer.parseInt(partes[9]);
                        String sabor = partes[10];
                        String tamanio = partes[11];
                        productos.add(new Snack(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio, gramos, sabor, tamanio));
                        break;
                    case "NuevaCategoria":
                        String tipoDulce = partes[12];
                        String saborDulce = partes[13];
                        productos.add(new NuevaCategoria(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio, tipoDulce, saborDulce));
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e);
        }
    }

    /**
     * Busca un producto por ID en el inventario.
     *
     * @param id ID del producto a buscar.
     * @return Producto encontrado o null si no se encuentra.
     */
    public static Producto buscarProductoPorID(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    /**
     * Lista los productos de una categoría específica.
     *
     * @param categoria Categoría de productos a listar.
     */
    public static void listarProductosPorCategoria(String categoria) {
        for (Producto producto : productos) {
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                System.out.println(producto.getNombre());
            }
        }
    }

    /**
     * Muestra las ventas totales y la comisión calculada.
     */
    public static void mostrarVentasYComision() {
        double ventasTotales = 0;
        double comision = 0.20; // 20% de comisión

        for (Producto producto : productos) {
            ventasTotales += (producto.getPrecio() * producto.getCantidadVendidos());
        }

        double comisionTotal = ventasTotales * comision;

        System.out.println("Ventas totales: " + ventasTotales);
        System.out.println("Comisión (" + (comision * 100) + "%): " + comisionTotal);
    }

    /**
     * Muestra el total de productos por categoría.
     */
    public static void mostrarTotalProductosPorCategoria() {
        int bebidaCount = 0;
        int snackCount = 0;
        int nuevaCategoriaCount = 0;

        for (Producto producto : productos) {
            switch (producto.getCategoria()) {
                case "Bebida":
                    bebidaCount++;
                    break;
                case "Snack":
                    snackCount++;
                    break;
                case "NuevaCategoria":
                    nuevaCategoriaCount++;
                    break;
            }
        }

        System.out.println("Total de productos en Bebida: " + bebidaCount);
        System.out.println("Total de productos en Snack: " + snackCount);
        System.out.println("Total de productos en NuevaCategoria: " + nuevaCategoriaCount);
    }
}
