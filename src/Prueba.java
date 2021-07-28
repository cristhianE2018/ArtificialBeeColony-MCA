public class Prueba {
    public static void main(String[] args) {

        Aleatorios.setRseed(0.5f);
        Aleatorios.randomize();
        double val;
        for (int i = 0; i <=5; i++) {
            val = Aleatorios.rnd(-1.0,1.0);
            System.out.println(val);
        }
    }
}
