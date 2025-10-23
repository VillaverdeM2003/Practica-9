import java.util.ArrayList;

public class Escenario {
    private String nombre;
    private ArrayList<Elemento> campoDeBatalla;
    private final int TAMANIO = 10; // 10x10

    public Escenario(String nombre) {
        this.nombre = nombre;
        this.campoDeBatalla = new ArrayList<>();
    }

    public void addElemento(Elemento elemento) {
        campoDeBatalla.add(elemento);
    }

    public void destruirElementos(Posicion centro, int radio) {
        System.out.println("Verificando elementos dentro del radio de " + radio + " desde " + centro);
        for (Elemento e : new ArrayList<>(campoDeBatalla)) {
            if (e instanceof Destruible) {
                int dx = Math.abs(e.getPosicion().getRenglon() - centro.getRenglon());
                int dy = Math.abs(e.getPosicion().getColumna() - centro.getColumna());
                if (dx <= radio && dy <= radio) {
                    ((Destruible) e).destruir();
                }
            }
        }
    }

    @Override
    public String toString() {
        String[][] matriz = new String[TAMANIO][TAMANIO];
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                matriz[i][j] = "0";
            }
        }
        for (Elemento e : campoDeBatalla) {
            int r = e.getPosicion().getRenglon();
            int c = e.getPosicion().getColumna();

            if (r >= 0 && r < TAMANIO && c >= 0 && c < TAMANIO) {
                if (e instanceof Terricola) matriz[r][c] = "T";
                else if (e instanceof Extraterrestre) matriz[r][c] = "E";
                else if (e instanceof Roca) matriz[r][c] = "R";
                else if (e instanceof Bomba) matriz[r][c] = "B";
            }
        }

        String texto = "";

for (int i = 0; i < TAMANIO; i++) {
    for (int j = 0; j < TAMANIO; j++) {
        texto += matriz[i][j] + " ";
    }
    texto += "\n";
}

return texto;
    }
}