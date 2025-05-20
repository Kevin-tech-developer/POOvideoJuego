import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class ArenaBatalla {
   
    


    public void IniciarBatalla(Criatura criatura, Criatura enemigo){
        //guarda la salida estandar original(System.out) en cosola original que es de tipo PrintStream que este permite reedirigir o manipular la salida y entrada
        PrintStream consolaOriginal = System.out;

        try {
            //se crea un nuevo PrintStream que escribirs en el archivo "batalla.txt"
            PrintStream archivoSalidad = new PrintStream(new File("batalla.txt"));
            //redirige la salidad estandar(System.out) al archivo
            //para todo lo que se imprima con System.out.println ira al archivo
            System.setOut(archivoSalidad);
        //todo lo que este entre el try-catch va al archivo
        System.out.println("comienza la batalla entre "+criatura.getNombre()+" y "+enemigo.getNombre()+"!");
        int turnos =1;
        while(!criatura.estaDerrotado() && !enemigo.estaDerrotado()){
            System.out.println("turno: "+turnos);

            System.out.println(criatura.getNombre()+" ATACA a "+enemigo.getNombre());
            criatura.ejecutarAccion(enemigo);

            if(enemigo.estaDerrotado()){
                System.out.println(enemigo.getNombre()+" ha sido derrotado.");
                System.out.println(criatura.getNombre()+" gana la batalla!");
                break;
            }

            System.out.println(enemigo.getNombre()+" ATACA a "+criatura.getNombre());
            enemigo.ejecutarAccion(criatura);

            if(criatura.estaDerrotado()){
                System.out.println(criatura.getNombre()+" ha sido derrotado.");
                System.out.println(enemigo.getNombre()+" gana la batalla!");
                break;
            }

            if(criatura.getVida()<50){
                criatura.cambiarEstrategia(new ComportamientoCurativo());
                System.out.println(criatura.getNombre()+" vamos a curarnos y a tratar de ganar");
            }
            else if(enemigo.getVida() <50){
                criatura.cambiarEstrategia(new ComportamientoCurativo());
                System.out.println(enemigo.getNombre()+" vamos a curarnos y a tratar de ganar");
            }
            turnos ++;
        }
    //si ocurre un error al crear el archivo, entoces imprime un mensaje en la consola
    }catch(FileNotFoundException e){
        consolaOriginal.println("Error al crear el archivo de batalla: "+e.getMessage());
    }finally{
        //siempre se ejecuta, ocurra o no un error
        //restaura la salida estandar a la consola original
        System.setOut(consolaOriginal);
    }
    //esto ya se imprime en la consola ya que esta por fuera del try-catch
    System.out.println("la batalla ha sido registrada en batalla.txt");
}
    

}
