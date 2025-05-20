public class ComportamientoAgresivo implements EstrategiaBatalla {

    @Override
    public void actuar(Criatura criatura, Criatura enemigo){
        int daño = criatura.getAtaqueActual()+ (int)(Math.random()*5);
        if(criatura instanceof CriaturaMagica){
            CriaturaMagica magica = (CriaturaMagica) criatura;
            if(magica.gastarMana(30)){
                daño +=10;
                System.out.println(criatura.getNombre()+" potencio su ataque usando Mana!");
            }
        }
        if (enemigo.getEstrategiaBatalla() instanceof ComportamientoDefensivo) {
            int Dañoparcial = Math.max(enemigo.getDefensa()-daño, 0);
            enemigo.reducirVida(daño);
            if(Dañoparcial >0){
                System.out.println(criatura.getNombre()+" ataca violentamente causando "+daño+" puntos de daño a "+enemigo.getNombre());
            }
            else if(Dañoparcial <=0){
                System.out.println(criatura.getNombre()+" causo 0 daño a "+enemigo.getNombre());
            }
        }
        else if(enemigo.getEstrategiaBatalla() instanceof ComportamientoEvasivo){
            System.out.println(criatura.getNombre()+ " ataca violentamente causando "+daño+ " puntos de daño, pero "+enemigo.getNombre()+" los evadio todos, sin poder causarle ningun daño total");
            enemigo.reducirVida(0);
        }
        else{
            enemigo.reducirVida(daño);  
        }
    }
}
