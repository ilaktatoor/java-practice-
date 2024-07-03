public class Producto {
    private String name;
    private String descripcion;
    private Categoria categoria;
    private double pVenta;
    private double pCompra;
    private int cantidad;
    private int cantidadVendida;

    public Producto(String name, String descripcion, Categoria categoria, double pVenta, double pCompra, int cantidad) {
        this.name = name;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.pVenta = pVenta;
        this.pCompra = pCompra;
        this.cantidad = cantidad;
        this.cantidadVendida = 0;
    }

    public String getName() {
        return name;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void addCantidad(int cantidad) {
        this.cantidad += cantidad;
    }

    public void reduceCantidad(int cantidad) {
        this.cantidad -= cantidad;
        this.cantidadVendida += cantidad;
    }

    public double calcularGanancia() {
        return (pVenta - pCompra) * cantidadVendida;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "name='" + name + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", categoria='" + categoria.getNombre() + '\'' +
                ", pVenta=" + pVenta +
                ", pCompra=" + pCompra +
                ", cantidad=" + cantidad +
                ", cantidadVendida=" + cantidadVendida +
                '}';
    }
}

