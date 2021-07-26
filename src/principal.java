
public class principal {
    public static void main(String[] args) {
        EmployedBee eb = new EmployedBee(
                5, //Numero de fuentes de alimento
                -3,   //Limite inferior
                3,   //Limite superior
                10  //Numero de variables
        );

        eb.initFoodSource();
        eb.mostrarFoodSource();
        System.out.println("Inicia el proceso!");
        int gen=1, genM=1;
        while(gen <= genM){
            /* Buscar nuevas fuentes de alimento */
            int tamanio = eb.getListFoodSource().length;

            for (int i = 0; i <=tamanio-1; i++) {
                double phi = Math.random();
                int indexAbeja = 0; //Seleccionar abaje aleatoriamente de las soluciones entre -1 y 1
            }

            //Enviar abejas exploradoras al área de búsqueda para descubrir nuevas fuentes de alimento
            gen++;
        }
        //Las abejas empleadoras aplican método de selección

        //Se aplicará selección por torneo
    }
}
