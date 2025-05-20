import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Criatura {
    private String nombre;
    private int vidaMaxima;
    private int vida;
    private int ataque;
    private int ataqueTemporal;
    private int defensa;
    private boolean esquivaActiva;
    private EstrategiaBatalla estrategia;
    private List<EfectoTemporal>efectos;

    public Criatura(String nombre, int vida, int ataque, int defensa, EstrategiaBatalla estrategia){
        this.nombre = nombre;
        this.ataque = ataque;
        this.vida = vida;
        this.vidaMaxima = vida;
        this.defensa = defensa;
        this.estrategia = estrategia;
        this.esquivaActiva = false;
        this.ataqueTemporal =0;
        this.efectos = new ArrayList<>();
    }


    public void cambiarEstrategia(EstrategiaBatalla nuevaestrategia){
        this.estrategia = nuevaestrategia;
    }
    public void ejecutarAccion(Criatura enemigo){
        procesarEfectos();
        estrategia.actuar(this, enemigo);
    }

    public void reducirVida(int daño){
        if(esquivaActiva){
            System.out.println(nombre + " esquiva completamente el ataque");
            esquivaActiva = false;
            return;
        }
        int dañoReal = Math.max(daño - defensa, 0);
        vida -= dañoReal;
        System.out.println(nombre + " recibe "+ dañoReal + " de daño, vida restante: "+vida);

    }

    public void aumentarDefensa(int cantidad){
        defensa += cantidad;
    }

    public void aumentarVida(int cantidad){
        vida += cantidad;
    }

    public void activarEsquiva(){
        esquivaActiva = true;
    }

    public void agregarEfecto(EfectoTemporal efecto){
        efectos.add(efecto);
    }
    public void procesarEfectos(){
        Iterator<EfectoTemporal>i = efectos.iterator();
        while (i.hasNext()) {
            EfectoTemporal efecto = i.next();
            efecto.AplicarEfecto(this);
            System.out.println("estas afectado por el efecto "+efecto.getNombre());
            if(!efecto.estaActivo()){
                i.remove();
            }
        }
    }

    public void modificarAtaqueTemporal(int cambio){
        this.ataqueTemporal += cambio;
    }

    public boolean estaDerrotado(){
        if(vida >0){
            return false;
        }
        return true;
    }
    public int getVidaMaxima(){
        return vidaMaxima;
    }

    public String getNombre(){
        return nombre;
    }
    public int getAtaqueActual(){
        return ataque + ataqueTemporal;
    }

    public int getAtaque(){
        return ataque;
    }
    public int getVida(){
        return vida;
    }

    public EstrategiaBatalla getEstrategiaBatalla(){
        return estrategia;
    }

    public int getDefensa(){
        return defensa;
    }

    public int getAtaqueTemporal(){
        return ataqueTemporal;
    }

}
