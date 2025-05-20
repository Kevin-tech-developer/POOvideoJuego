public class CriaturaCamaleon extends Criatura{
    private EstrategiaBatalla estrategiaOriginal;
    private EstrategiaBatalla estrategiaCopiada;

    public CriaturaCamaleon(String nombre, EstrategiaBatalla estrategia) {
        super(nombre, 100, 20, 15, estrategia );
        this.estrategiaOriginal = estrategia;
        this.estrategiaCopiada = null;
    }

    @Override
    public void ejecutarAccion(Criatura enemigo){
        procesarEfectos();

        if(estrategiaCopiada != null){
            System.out.println(getNombre()+" copia la estrategia del enemigo y la usa");
            estrategiaCopiada.actuar(this, enemigo);
            estrategiaCopiada = null;
        }
        else{
            estrategiaOriginal.actuar(this, enemigo);
        }

        estrategiaCopiada = enemigo.getEstrategiaBatalla();
    }

    public EstrategiaBatalla getEstrategiaOriginal(){
        return estrategiaOriginal;
    }


}
