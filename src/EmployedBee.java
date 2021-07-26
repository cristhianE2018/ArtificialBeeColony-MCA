

public class EmployedBee {

    public FoodSource[] listFoodSource;
    public double li;
    public double ls;
    public int tamanio;
    public int dimension;
    public EmployedBee(int tamanio,double li, double ls,int dimension){
        this.tamanio = tamanio;
        this.dimension = dimension;
        this.listFoodSource = new FoodSource[tamanio];
        this.li = li;
        this.ls = ls;
    }

    //Función a evaluar
    public double obtaintCantidadNectar(double[] x){
        double res = 0.0;
        for (int i = 0; i <=x.length-1; i++) {
                res = res + (Math.pow(x[i],2));
        }
        return res;
    }

    public FoodSource[] getListFoodSource() {
        return listFoodSource;
    }

    public void initFoodSource(){
        //for each food
        for (int i = 0; i <= listFoodSource.length-1; i++) {

            double[] aux = new double[dimension];
            for (int j = 0; j <=aux.length-1; j++) {
                double nRnd = this.li + Math.random() * (this.ls-this.li);
                nRnd = (double)Math.round(nRnd * 100d) / 100d;
                aux[j] = nRnd;
            }
            FoodSource fs = new FoodSource(aux);
            fs.setCalidad(obtaintCantidadNectar(aux));
            listFoodSource[i] = fs;
        }
    }

    public void mostrarFoodSource(){
        for (int i = 0; i <=listFoodSource.length-1; i++) {
            System.out.println(listFoodSource[i].toString());
        }
    }


}
