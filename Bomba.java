public class Bomba extends Elemento {
    private int radio;

    public Bomba(Escenario escenario, Posicion posicion, int radio) {
        super(escenario, posicion);
        this.radio = radio;
    }

    public void explotar() {
        System.out.println("La bomba explota en " + posicion + " con radio " + radio);
        escenario.destruirElementos(posicion, radio);
    }

}
