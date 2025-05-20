
// importa las clases necesarias para trabajar con flujos de entrda/salida
import java.io.*;

//esta clase hereda de PrintStream: esto permite personalizar el comportamiento al imprimir
public class RegistroBatalla extends PrintStream {
    //guarda un tipo al PrintStream original(Generalmente System.out)
    private final PrintStream consolaOriginal;

    //este constructor de la clase gurada un OutputStream(como un archivo) y como se menciono arriba PrintStrean la consola Original
    public RegistroBatalla(OutputStream archivo, PrintStream consolaOriginal) throws IOException {
        //llama al constructor de PrintStream con el archivo t activa autoFlush
        //autoFlush =true significa que se escribe el archivo de inmediato (sin buffer)
        super(archivo, true);
        //guarda la referencia a la consola original para seguir mostrando mensajes ahi
        this.consolaOriginal = consolaOriginal;
    }
    //sobrescribe el metodo println que imprime cadenas de texto
    @Override
    public void println(String mensaje){
        //primero escribe el mensaje en la consola original
        consolaOriginal.println(mensaje);
        //luego imprime el mensaje usando PrintStream Original(archivo)
        super.println(mensaje);
    }


}
