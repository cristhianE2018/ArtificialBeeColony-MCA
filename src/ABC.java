
public class ABC {

    public double[][] listFoodSource;
    public double li;
    public double ls;
    public int tamanio;
    public ABC(int tamanio,double li, double ls){
        this.tamanio = tamanio;
        this.listFoodSource = new double[tamanio][10];
        this.li = li;
        this.ls = ls;
    }

    public void initFoodSource(){
        //for each food
        for (int i = 0; i <= listFoodSource.length-1; i++) {

            for (int j = 0; j <= listFoodSource[i].length-1; j++) {
                double nRnd = this.li + Math.random() * (this.ls-this.li);
                listFoodSource[i][j] = nRnd;
            }

        }

    }
    public void setFSToEmployedBees(){
        EmployedBee bee;
        for (int i = 0; i <=this.listFoodSource.length-1; i++) {
            bee = new EmployedBee();
            //La asignación debe ser aleatoria
            bee.setFoodSource(this.listFoodSource[i]);
        }
    }

    public void showFoodSource(){
        for (int i = 0; i <=this.listFoodSource.length-1 ; i++) {
            for (int j = 0; j <= this.listFoodSource[i].length-1; j++) {
                System.out.print(this.listFoodSource[i][j] + " | ");
            }
            System.out.println("");
        }
    }
}
