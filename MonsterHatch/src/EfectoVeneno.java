public class EfectoVeneno extends EfectoTemporal{
    private int daño;
    
    public EfectoVeneno(String nombre, int turnosAfecta, int daño) {
        super(nombre, turnosAfecta);
        this.daño = daño;
    }

    @Override
    public void AplicarEfecto(Criatura enemigo){
        enemigo.reducirVida(daño);
        System.out.println(enemigo.getNombre()+" sufre "+daño+" de daño por veneno");
        reducirTurno();
    }

}
