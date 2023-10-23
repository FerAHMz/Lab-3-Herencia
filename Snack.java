/**
 * Clase que representa un snack, hereda de la clase Producto.
 */
public class Snack extends Producto {
    private int gramos;
    private String sabor;
    private String tamanio;

    /**
     * Constructor de la clase Snack.
     * 
     * @param id                El ID del snack.
     * @param nombre            El nombre del snack.
     * @param cantidadDisponible La cantidad disponible del snack.
     * @param cantidadVendidos  La cantidad vendida del snack.
     * @param estado            El estado del snack (disponible o no disponible).
     * @param precio            El precio del snack.
     * @param gramos            Los gramos del snack.
     * @param sabor             El sabor del snack (barbacoa, picante, natural).
     * @param tamanio           El tamaño del snack (individual, familiar).
     */
    public Snack(int id, String nombre, int cantidadDisponible, int cantidadVendidos, String estado, int precio, int gramos, String sabor, String tamanio) {
        super(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio, "Snack");
        this.gramos = gramos;
        this.sabor = sabor;
        this.tamanio = tamanio;
    }

    // Getters
    public int getGramos() {
        return gramos;
    }

    public String getSabor() {
        return sabor;
    }

    public String getTamanio() {
        return tamanio;
    }

    /**
     * Método que imprime los detalles específicos de un snack.
     */
    @Override
    public void imprimirDetalles() {
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Cantidad Disponible: " + getCantidadDisponible());
        System.out.println("Cantidad Vendidos: " + getCantidadVendidos());
        System.out.println("Estado: " + getEstado());
        System.out.println("Precio: " + getPrecio());
        System.out.println("Gramos: " + gramos);
        System.out.println("Sabor: " + sabor);
        System.out.println("Tamaño: " + tamanio);
    }
}
