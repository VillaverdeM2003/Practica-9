public class Roca extends Elemento implements Destruible {

    public Roca(Escenario escenario, Posicion posicion) {
        super(escenario, posicion);
    }

    @Override
    public void destruir() {
        System.out.println("La roca en " + posicion + " ha sido destruida.");
    }

}
