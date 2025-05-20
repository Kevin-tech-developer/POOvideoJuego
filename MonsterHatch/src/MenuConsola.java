import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuConsola {
  private List<InfoCriatura>Criaturas;
  private List<InfoComportamiento>Comportamiento;
  private Criatura criatura1;
  private Criatura criatura2;

  public MenuConsola() {
    this.Criaturas = new ArrayList<>();
    Criaturas.add(new InfoCriatura("Criatura camaleon", 100, 20, 15, "Copia la estrategia del enemigo y la usa en su siguiente turno"));
    Criaturas.add(new InfoCriatura("Criatura Magica", 100, 20, 15, "usa maná para potenciar estrategias"));
    Criaturas.add(new InfoCriatura("Criatura Tanque", 130, 20, 22, "Defensa alta, reduce daño si esta con suficiente vida"));
    Criaturas.add(new InfoCriatura("Criatura Veloz", 80, 20, 10, "Ataca dos veces en el mismo turno"));

    this.Comportamiento = new ArrayList<>();
    Comportamiento.add(new InfoComportamiento("comportamiento Agresivo", "Ataca al enemigo agresivamente reduciendo su vida"));
    Comportamiento.add(new InfoComportamiento("comportamiento Aletargador", "Reduce el ataque del enemigo en una cantidad porcentual durante 2 turnos"));
    Comportamiento.add(new InfoComportamiento("comportamiento Curativo", "La criatura recupera entre 10 o 20 puntos de vida al usar su turno"));
    Comportamiento.add(new InfoComportamiento("comportamiento Defensivo", "La criatura aumenta su defensa al usar su turno"));
    Comportamiento.add(new InfoComportamiento("comportamiento Envenenador", "El enemigo pierde entre 5 y 10 puntos de vida por turno durante los proximos tres turnos"));
    Comportamiento.add(new InfoComportamiento("comportamiento Evasivo", "La criatura Evita el siguiente ataque recibido"));
  }

  public void AgregarCriatura(InfoCriatura criatura){
    Criaturas.add(criatura);
  }

  public void verCriaturas(){
    for(int i =0; i<Criaturas.size(); i++){
      System.out.println((i+1)+"."+Criaturas.get(i).getNombre());
    }
  }

  public void verComportamientos(){
    for(int i =0; i<Comportamiento.size(); i++){
      System.out.println((i+1)+". "+Comportamiento.get(i).getNombre());
      System.out.println(Comportamiento.get(i).getDescripcion());
    }
  }
  public String buscarComportamiento(int indice){
    return Comportamiento.get(indice).getNombre();
  }

  public void agregarComportamiento(InfoComportamiento comportamiento){
    Comportamiento.add(comportamiento);
  }

  public void verInfoCriaturas(){
    for( int i=0; i<Criaturas.size(); i++){
      System.out.println((i+1)+"."+Criaturas.get(i).getNombre()+" - vida. "+Criaturas.get(i).getVida()+" -Ataque: "+Criaturas.get(i).getAtaque()+" -Defensa: "+Criaturas.get(i).getDefensa());
      System.out.println(Criaturas.get(i).getDescripcion());
    }
  }

  public void CrearCriatura(int opcion1, String nombre, int comportamiento, int numeroCriatura){
    EstrategiaBatalla estrategia = null;
    
    if(comportamiento ==1){
      estrategia = new ComportamientoAgresivo();
    }
    else if(comportamiento ==2){
      estrategia = new ComportamientoAletargador();
    }
    else if(comportamiento ==3){
      estrategia = new ComportamientoCurativo();
    }
    else if(comportamiento ==4){
      estrategia = new ComportamientoDefensivo();
    }
    else if(comportamiento ==5){
      estrategia = new ComportamientoEnvenenador();
    }
    else if(comportamiento ==6){
      estrategia = new ComportamientoEvasivo();
    }
    else{
      System.out.println("opcion de comportamiento invalido");
    }

    switch (opcion1) {
      case 1:
        if(numeroCriatura ==1){
        criatura1 = new CriaturaCamaleon(nombre, estrategia);
        System.out.println(criatura1.getNombre()+" se creo la Criatura de tipo camaleon");
        }
        else if(numeroCriatura ==2){
          criatura2 = new CriaturaCamaleon(nombre, estrategia);
        System.out.println(criatura2.getNombre()+" se creo la Criatura de tipo camaleon");
        }
        else{
          System.out.println("solo se pueden crear 2 criatura, no mas de dos");
        }
        break;
      case 2:
        if(numeroCriatura ==1){
        criatura1 = new CriaturaMagica(nombre, estrategia);
        System.out.println(criatura1.getNombre()+" se creo la Criatura de tipo Magica");
        }
        else if(numeroCriatura ==2){
          criatura2 = new CriaturaMagica(nombre, estrategia);
        System.out.println(criatura2.getNombre()+" se creo la Criatura de tipo Magica");
        }
        else{
          System.out.println("solo se pueden crear 2 criaturas, no mas de dos");
        }
        break;
      case 3:
        if(numeroCriatura ==1){
        criatura1 = new CriaturaTanque(nombre, estrategia);
        System.out.println(criatura1.getNombre()+" se creo la Criatura de tipo Tanque");
        }
        else if(numeroCriatura ==2){
          criatura2 = new CriaturaTanque(nombre, estrategia);
        System.out.println(criatura2.getNombre()+" se creo la Criatura de tipo Tanque");
        }
        else{
          System.out.println("solo se pueden crear 2 criaturas, no mas de dos");
        }
        break;
      case 4:
        if(numeroCriatura ==1){
        criatura1 = new CriaturaVeloz(nombre, estrategia);
        System.out.println(criatura1.getNombre()+" se creo la Criatura de tipo Veloz");
        }
        else if(numeroCriatura ==2){
          criatura2 = new CriaturaVeloz(nombre, estrategia);
        System.out.println(criatura2.getNombre()+" se creo la Criatura de tipo Veloz");
        }
        break;
    
      default:
        System.out.println("La opcion de la criatura no es validad");
        break;
    }
  }

  public Criatura getCriatura1(){
    return criatura1;
  }

  public Criatura getCriatura2(){
    return criatura2;
  }

    public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(System.in);
      int opcion;

      MenuConsola menu = new MenuConsola();

      System.out.println("bienvenidos a MonsterHatch, juega y compite con las mejores Criaturas");
      do{
        System.out.println("1. escoger Criaturas");
        System.out.println("2. ver informacion Criaturas");
        System.out.println("3. ver informacion Comportamientos");
        System.out.println("4. Iniciar Batalla");
        System.out.println("5. Salir");

        System.out.println("Digite la opcion escogida: ");
        opcion = Integer.parseInt(sc.nextLine());
        switch (opcion) {
          case 1:
            menu.verCriaturas();
            int numeroCriatura =1;
            if(numeroCriatura ==1){
            System.out.println("digite la opcion de la criatura 1: ");
            int opcion1= Integer.parseInt(sc.nextLine());
            System.out.println("digite el nombre de la criatura: ");
            String nombre= sc.nextLine();
            System.out.println("comportamiento para escoger a la criatura");
            menu.verComportamientos();
            System.out.println("Digite la opcion del comportamiento que quieres que tenga: ");
            int comportamiento = Integer.parseInt(sc.nextLine());
            menu.CrearCriatura(opcion1, nombre, comportamiento, 1);
            System.out.println("se creo la criatura 1");
            }
            numeroCriatura =2;
            if(numeroCriatura==2){
            System.out.println("digite la opcion de la criatura 2: ");
            int opcion1= Integer.parseInt(sc.nextLine()); 
            System.out.println("digite el nombre de la criatura: ");
            String nombre = sc.nextLine();
            System.out.println("comportamiento para escoger a la criatura");
            menu.verComportamientos();
            System.out.println("Digite la opcion del comportamiento que quieres que tenga: ");
            int comportamiento = Integer.parseInt(sc.nextLine());
            menu.CrearCriatura(opcion1, nombre, comportamiento, 2);
            System.out.println("se creo la criatura 1");
            }
            break;
          case 2:
            System.out.println("las criaturas disponibles son: ");
            menu.verInfoCriaturas();

            break;
          case 3:
            System.out.println("los comportamientos disponibles son: ");
            menu.verComportamientos();
            break;
          case 4:
            if(menu.getCriatura1() !=null && menu.getCriatura2() !=null){
              ArenaBatalla arena = new ArenaBatalla();
              arena.IniciarBatalla(menu.getCriatura1(), menu.getCriatura2());
            }
            else{
              System.out.println("debes crear ambas criaturas antes de iniciar la batalla");
            }
            break;
          case 5:
            System.out.println("saliendo del juego");
            break;

        
          default:
            System.out.println("opcion del menu invalidad");
            break;
        }


      }
      while(opcion != 5);
      sc.close();


         



    }
}
