package modelo;

public class pedido {
    private int id;
    private int idUser;
    private String fecha;
    private double total;
    private String estado;

    public pedido(int id, int idUser, String fecha, double total, String estado) {
        this.id = id;
        this.idUser = idUser;
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
    }

    public pedido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
