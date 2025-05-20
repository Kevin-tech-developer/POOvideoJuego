public class CriaturaMagica extends Criatura{
    private int mana;

    public CriaturaMagica(String nombre, EstrategiaBatalla estrategia) {
        super(nombre, 100, 20, 15, estrategia);
        this.mana = 30;
    }

    @Override
    public void ejecutarAccion(Criatura enemigo){
        super.ejecutarAccion(enemigo);
        this.recargarMana(10);
    }

    public boolean gastarMana(int cantidad){
        if(mana >=cantidad){
            mana-=cantidad;
            return true;
        }
        return false;
    }

    public void recargarMana(int cantidad){
        this.mana +=cantidad;
        if(this.mana >30){
            this.mana = 30;
        }
    }

    public int getMana(){
        return mana;
    }

}
