public class EfectoAletargador extends EfectoTemporal{
    private int reduccion;

    public EfectoAletargador(String nombre, int turnosAfecta, int reduccion) {
        super(nombre, turnosAfecta);
        this.reduccion = reduccion;
    }

    @Override
    public void AplicarEfecto(Criatura enemigo){
        enemigo.modificarAtaqueTemporal(-reduccion);
        System.out.println(enemigo.getNombre()+" pierde "+reduccion+" de ataque temporal");
        reducirTurno();

    }
}
