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

    /*public double obtaintCantidadNectar(){
        double res = 0.0;
        for (int i = 0; i <=x.length-1; i++) {
            res = res + (Math.pow(x[i],2));
        }
        return res;
    }
     */




    //Funcion Step
    public double obtaintCantidadNectar(){
        double f = 0.0;
        for (int i = 0; i <=x.length-1; i++) {
            f = f + Math.pow((Math.abs(x[i] + 0.5)),2);
        }
        return f;
    }

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
            valorInverso = 1 / (1+calidad);
        }
        else{
            valorInverso = 1 / (Math.abs(calidad));
        }
    }
}
