
public class principal {
    public static void main(String[] args) {
        ABC eb = new ABC(
                //Estos valores obtienes buenos resultados
                5000, //Numero de fuentes de alimento
                -100,   //Limite inferior
                100,   //Limite superior
                10,
                15000
        );
        eb.run();

    }
}
