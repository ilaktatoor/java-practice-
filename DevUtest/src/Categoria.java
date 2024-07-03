public class Categoria {
    private String nombre;
    private int puntoSurtir;
    private int cantidadSurtir;

    public Categoria(String nombre, int puntoSurtir, int cantidadSurtir) {
        this.nombre = nombre;
        this.puntoSurtir = puntoSurtir;
        this.cantidadSurtir = cantidadSurtir;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntoSurtir() {
        return puntoSurtir;
    }

    public int getCantidadSurtir() {
        return cantidadSurtir;
    }
}

