public class InfoCriatura {
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private String descripcion;

    public InfoCriatura(String nombre, int vida, int ataque, int defensa , String descripcion) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.descripcion = descripcion;

    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public String getDescripcion(){
        return descripcion;
    }

    


}
