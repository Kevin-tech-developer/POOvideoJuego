public class CriaturaVeloz extends Criatura{
    public CriaturaVeloz(String nombre, EstrategiaBatalla estrategia) {
        super(nombre, 80, 22, 13, estrategia);
    }

    @Override
    public void ejecutarAccion(Criatura enemigo){
        System.out.println(getNombre()+" se mueve rapidamente y ataca dos veces:");
        super.ejecutarAccion(enemigo);
        System.out.println(getNombre()+" lanza su segundo ataque veloz");
        super.ejecutarAccion(enemigo);
    }

}
