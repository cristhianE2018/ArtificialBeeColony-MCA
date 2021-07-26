public class FoodSource {

    public double[] x;
    public double calidad;

    public FoodSource(double[] x){
        this.x=x;

    }

    public void setCalidad(double calidad){
        this.calidad=calidad;
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
}
