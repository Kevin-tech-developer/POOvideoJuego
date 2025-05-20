public class ComportamientoEvasivo implements EstrategiaBatalla{
    @Override
    public void actuar(Criatura criatura, Criatura enemigo){
        criatura.activarEsquiva();
        System.out.println(criatura.getNombre()+ " evade todo ataque, sin causar daño");
    }

}
