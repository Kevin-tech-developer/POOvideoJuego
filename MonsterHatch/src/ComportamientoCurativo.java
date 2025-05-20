public class ComportamientoCurativo implements EstrategiaBatalla{
    @Override
    public void actuar(Criatura criatura, Criatura enemigo){
        int recuperacion = 1 +(int)(Math.random()*2);
        if(criatura instanceof CriaturaMagica){
            CriaturaMagica magica = (CriaturaMagica) criatura;
            if(magica.gastarMana(30)){
                recuperacion +=4;
                System.out.println(criatura.getNombre()+" potencio su recuperacio con Mana!");
            }
        }
        criatura.aumentarVida(recuperacion);
        System.out.println(criatura.getNombre()+" aumento su vida "+recuperacion+" puntos mas");
    }
}
