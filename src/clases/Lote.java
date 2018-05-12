
package clases;

/**
 *
 * @author kimberly
 */
public class Lote {
    
    private int idLote, idProducto, cant;
    private String NombreProducto;
    private double precioCompra;

    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getIdLote() {
        return idLote;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public int getCant() {
        return cant;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }
}
