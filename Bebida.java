/**
 * Clase que representa una bebida, hereda de la clase Producto.
 */
public class Bebida extends Producto {
    private int ml;
    private String tipo;

    /**
     * Constructor de la clase Bebida.
     * 
     * @param id                El ID de la bebida.
     * @param nombre            El nombre de la bebida.
     * @param cantidadDisponible La cantidad disponible de la bebida.
     * @param cantidadVendidos  La cantidad vendida de la bebida.
     * @param estado            El estado de la bebida (disponible o no disponible).
     * @param precio            El precio de la bebida.
     * @param ml                Los mililitros de la bebida.
     * @param tipo              El tipo de bebida (energética, con licor, natural, agua pura).
     */
    public Bebida(int id, String nombre, int cantidadDisponible, int cantidadVendidos, String estado, int precio, int ml, String tipo) {
        super(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio, "Bebida");
        this.ml = ml;
        this.tipo = tipo;
    }

    // Getters
    public int getMl() {
        return ml;
    }

    public String getTipo() {
        return tipo;
    }

    /**
     * Método que imprime los detalles específicos de una bebida.
     */
    @Override
    public void imprimirDetalles() {
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Cantidad Disponible: " + getCantidadDisponible());
        System.out.println("Cantidad Vendidos: " + getCantidadVendidos());
        System.out.println("Estado: " + getEstado());
        System.out.println("Precio: " + getPrecio());
        System.out.println("Mililitros: " + ml);
        System.out.println("Tipo: " + tipo);
    }
}
