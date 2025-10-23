public abstract class Personaje extends Elemento implements Destruible {
    protected String nombre;
    

    public Personaje(String nombre, Escenario escenario, Posicion posicion) {
        super(escenario, posicion);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void destruir() {
        
        System.out.println(nombre + " ha sido destruido");
    }

}
