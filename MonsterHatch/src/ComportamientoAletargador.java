public class ComportamientoAletargador  implements EstrategiaBatalla{

    @Override
    public void actuar(Criatura criatura, Criatura enemigo){
        int reduccion = 6;
        if(criatura instanceof CriaturaMagica){
            CriaturaMagica magica = (CriaturaMagica) criatura;
            if(magica.gastarMana(20)){
                reduccion +=3;
                System.out.println(criatura.getNombre()+" potencio su reduccion con Mana!");
            }
        }
        System.out.println(criatura.getNombre()+" a reducido "+reduccion+" puntos el ataque de "+enemigo.getNombre());
        EfectoTemporal efecto = new EfectoAletargador("tardador", 2, reduccion);
        enemigo.agregarEfecto(efecto);
    }

}
