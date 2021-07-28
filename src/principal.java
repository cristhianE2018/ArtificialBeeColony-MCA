
public class principal {
    public static void main(String[] args) {
        ABC eb = new ABC(
                100, //Numero de fuentes de alimento
                -3,   //Limite inferior
                3,   //Limite superior
                5,
                500
        );
        eb.run();

    }
}
