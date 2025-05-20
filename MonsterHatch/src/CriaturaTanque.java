public class CriaturaTanque extends Criatura{

    public CriaturaTanque(String nombre, EstrategiaBatalla estrategia) {
        super(nombre, 120, 20, 10,estrategia);
    }

    @Override
    public void reducirVida(int daño){
        if(getVida() > getVidaMaxima()*0.95){
            System.out.println(getNombre()+" activa defensa de tanque y reduce el daño");
            daño *= 0.9;
        }
        daño = Math.max(daño, 0);
        super.reducirVida(daño);
    }

}
