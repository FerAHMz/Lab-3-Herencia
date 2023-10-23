/**
 * La clase {@code NuevaCategoria} representa una categoría adicional en el inventario.
 * Esta clase hereda de la clase {@code Producto} y agrega atributos específicos para esta nueva categoría.
 */
public class NuevaCategoria extends Producto {
    
    /** Tipo de dulce (ejemplo: "chocolate", "goma de mascar", "caramelo duro"). */
    private String tipoDulce;
    
    /** Sabor del dulce (ejemplo: "fresa", "menta", "chocolate"). */
    private String sabor;

    /**
     * Constructor para crear un nuevo producto de la categoría {@code NuevaCategoria}.
     *
     * @param id ID del producto.
     * @param nombre Nombre del producto.
     * @param cantidadDisponible Cantidad disponible en inventario.
     * @param cantidadVendidos Cantidad de productos vendidos.
     * @param estado Estado del producto (disponible o no disponible).
     * @param precio Precio del producto.
     * @param tipoDulce Tipo específico de dulce.
     * @param sabor Sabor específico del dulce.
     */
    public NuevaCategoria(int id, String nombre, int cantidadDisponible, int cantidadVendidos, String estado, int precio, String tipoDulce, String sabor) {
        super(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio, "NuevaCategoria");
        this.tipoDulce = tipoDulce;
        this.sabor = sabor;
    }

    /**
     * Obtiene el tipo de dulce.
     *
     * @return Tipo de dulce.
     */
    public String getTipoDulce() {
        return tipoDulce;
    }

    /**
     * Obtiene el sabor del dulce.
     *
     * @return Sabor del dulce.
     */
    public String getSabor() {
        return sabor;
    }

    /**
     * Imprime los detalles específicos de un producto de la categoría {@code NuevaCategoria}.
     */
    @Override
    public void imprimirDetalles() {
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Cantidad Disponible: " + getCantidadDisponible());
        System.out.println("Cantidad Vendidos: " + getCantidadVendidos());
        System.out.println("Estado: " + getEstado());
        System.out.println("Precio: " + getPrecio());
        System.out.println("Tipo de Dulce: " + tipoDulce);
        System.out.println("Sabor: " + sabor);
    }
}
