
public class Alessandra {

    static int numero = 0;

    public static void main(String[] args) {

        Alessandra alessandra = new Alessandra();

        System.out.println("Wello world!");

        alessandra.dormi();
        alessandra.contador();
        alessandra.contador();
        alessandra.contador();

    }

    public void dormi() {
        System.out.println("Doormindo");
    }

    public void contador() {
        this.numero++;
        System.out.println(numero);
    }
}