public class FoodSource {

    public double[] x;
    public double calidad;
    public double valorInverso;
    public FoodSource(double[] x){
        this.x=x;
        setCalidad();
        funcionInversa();
    }
    public double[] getX(){
        return this.x;
    }
    public double getValorInverso(){
        return  this.valorInverso;
    }

    //Funcion Step
    /*public double obtaintCantidadNectar(){
        double f = 0.0;
        for (int i = 0; i <=x.length-1; i++) {
            f = f + Math.pow((Math.abs(x[i] + 0.5)),2);
        }
        return f;
    }
    */

    //Funcion Scewfel
    public double obtaintCantidadNectar(){
        double aux=0.0;
        double sum =0.0;
        for (int i = 0; i <= x.length-1; i++) {
            sum = 0;
            for (int j = 0; j <=i; j++) {
                sum = sum + x[j];
            }
            aux = aux + Math.pow(sum,2);
        }
        return aux;
    }
    //Funcion rastrining
    /*public double obtaintCantidadNectar(){
        double aux=0.0;
        for (int i = 0; i <=x.length-1; i++) {
            aux = aux + (Math.pow(x[i],2) - 10 * Math.cos(2 * Math.PI *  x[i]) + 10);
        }
        return aux;
    }*/


    public void setCalidad(){

        this.calidad=obtaintCantidadNectar();
    }

    public double getCalidad(){
        return this.calidad;
    }

    @Override
    public String toString(){

        String resultado = "";
        for (int i = 0; i <=x.length-1; i++) {
            resultado = resultado + " |x"+(i+1) + "= " + x[i];
        }
        resultado = resultado + " | calidad " + calidad;

        return resultado;
    }

    public void funcionInversa(){
        if(calidad >= 0){
            this.valorInverso = 1 / (1+this.calidad);
        }
        else{
            this.valorInverso = 1 / (Math.abs(this.calidad));
        }
    }
}
