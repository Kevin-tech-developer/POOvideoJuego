public class ComportamientoEnvenenador implements EstrategiaBatalla{
    @Override
    public void actuar(Criatura criatura, Criatura enemigo){
        System.out.println(criatura.getNombre()+" a envenenado a "+enemigo.getNombre()+" por tres turnos");
        int daño = 15+ (int)(Math.random()*5);
        enemigo.agregarEfecto(new EfectoVeneno("envenenamiento", 3, daño));
    }

}
