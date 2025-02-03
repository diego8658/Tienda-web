package modelo;

public class categoria {
    private int id;
    private String Nombre;

    public categoria(int id, String Nombre) {
        this.id = id;
        this.Nombre = Nombre;
    }

    public categoria() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
}
