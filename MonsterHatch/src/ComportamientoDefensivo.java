public class ComportamientoDefensivo implements EstrategiaBatalla{

    @Override
    public void actuar(Criatura criatura, Criatura enemigo){
        int escudo = 5+ (int)(Math.random()*5); 
        if(criatura instanceof CriaturaMagica){
            CriaturaMagica magica = (CriaturaMagica) criatura;
            if(magica.gastarMana(20)){
                escudo +=2;
                System.out.println(criatura.getNombre()+" potencio su escudo con Mana!");
            }
        }
        criatura.aumentarDefensa(escudo);
        System.out.println(criatura.getNombre()+" refuerza su defensa aumentando su escudo en "+escudo+" puntos");
    }
}
