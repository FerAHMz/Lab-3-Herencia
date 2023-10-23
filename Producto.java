/**
 * Clase abstracta que representa un producto genérico.
 */
public abstract class Producto {
    protected int id;
    protected String nombre;
    protected int cantidadDisponible;
    protected int cantidadVendidos;
    protected String estado;
    protected int precio;
    protected String categoria;

    /**
     * Constructor de la clase Producto.
     * 
     * @param id                El ID del producto.
     * @param nombre            El nombre del producto.
     * @param cantidadDisponible La cantidad disponible del producto.
     * @param cantidadVendidos  La cantidad vendida del producto.
     * @param estado            El estado del producto (disponible o no disponible).
     * @param precio            El precio del producto.
     * @param categoria         La categoría del producto.
     */
    public Producto(int id, String nombre, int cantidadDisponible, int cantidadVendidos, String estado, int precio, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadDisponible = cantidadDisponible;
        this.cantidadVendidos = cantidadVendidos;
        this.estado = estado;
        this.precio = precio;
        this.categoria = categoria;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public int getCantidadVendidos() {
        return cantidadVendidos;
    }

    public String getEstado() {
        return estado;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    /**
     * Método abstracto para imprimir los detalles del producto.
     * Las clases hijas deben implementar este método.
     */
    public abstract void imprimirDetalles();
}
