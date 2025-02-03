package modelo;

public class producto {

    private int idProducto;
    private String nombre;
    private String descripcion;
    private double precio;
    private double precioCOM;
    private double precioVEN;
    private int idProveedor;
    private int categoriaid;

    public producto(String nombre, String descripcion, double precio, double precioCOM, double precioVEN, int categoriaid) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.precioCOM = precioCOM;
        this.precioVEN = precioVEN;
        this.categoriaid = categoriaid;
    }
    public producto(int idProducto, String nombre, String descripcion, double precio, double precioCOM, double precioVEN, int idProveedor, int categoriaid) {
    this.idProducto = idProducto;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.precio = precio;
    this.precioCOM = precioCOM;
    this.precioVEN = precioVEN;
    this.idProveedor = idProveedor;
    this.categoriaid = categoriaid;
}

    public producto() {
    }
    


    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecioCOM() {
        return precioCOM;
    }

    public void setPrecioCOM(double precioCOM) {
        this.precioCOM = precioCOM;
    }

    public double getPrecioVEN() {
        return precioVEN;
    }

    public void setPrecioVEN(double precioVEN) {
        this.precioVEN = precioVEN;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getCategoriaid() {
        return categoriaid;
    }

    public void setCategoriaid(int categoriaid) {
        this.categoriaid = categoriaid;
    }



}
