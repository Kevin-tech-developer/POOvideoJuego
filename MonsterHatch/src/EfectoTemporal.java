public abstract class EfectoTemporal {
    protected String nombre;
    protected int turnosRestantes;

    public EfectoTemporal(String nombre, int turnosAfecta ) {
        this.nombre = nombre;
        this.turnosRestantes = turnosAfecta;
        
    }

    public abstract void AplicarEfecto(Criatura enemigo);
        
    public boolean estaActivo(){
        return turnosRestantes >0;
    }

    public void reducirTurno(){
        turnosRestantes --;
    }
    public String getNombre(){
        return nombre;
    }


}
