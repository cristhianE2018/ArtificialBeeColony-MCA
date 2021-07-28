
public class ABC {

    public FoodSource[] fuentesAlimento;
    public double li;
    public double ls;
    public int tamanio;
    public int dimension;
    public int genMaxima;
    public int[] trial;
    public static int MAX_TRIAL=1;
    public double[] p;
    public double fbest;
    public FoodSource mejor;
    public ABC(int tamanio,double li, double ls, int dimension,int genMaxima){
        this.tamanio = tamanio;
        this.dimension = dimension;
        this.fuentesAlimento = new FoodSource[this.tamanio];
        this.li = li;
        this.ls = ls;
        this.genMaxima = genMaxima;
        this.trial = new int[tamanio];
        this.p = new double[tamanio];
        Aleatorios.setRseed(0.5f);
        Aleatorios.randomize();
    }


    public void initFoodSource(){
        System.out.println("Se inicializan las fuentes de alimento");
        for (int i = 0; i <= fuentesAlimento.length-1; i++) {

            double[] aux = new double[dimension];
            for (int j = 0; j <=aux.length-1; j++) {
                double nRnd = this.li + Math.random() * (this.ls-this.li);
                nRnd = (double)Math.round(nRnd * 100d) / 100d;
                aux[j] = nRnd;
            }
            FoodSource fs = new FoodSource(aux);
            fuentesAlimento[i] = fs;
        }
    }

    public void mostrarFoodSource(){
        for (int i = 0; i <=fuentesAlimento.length-1; i++) {
            System.out.println(fuentesAlimento[i].toString());
        }
    }
    public void run(){
        initFoodSource();
        int ciclo = 0;
        while(ciclo < genMaxima){
            employedBeesPhase(); //En esta fase se ce
            onlookersBeesPhase();
            scoutBeesPhase();
            memorizeBest();
            ciclo++;
        }
        System.out.println(mejor.toString());
    }

    public void replaceFoodSource(int ind, FoodSource f){
        this.fuentesAlimento[ind] = f;
    }

    public void employedBeesPhase(){

        double phi;
        int k;

        for (int i = 0; i <=fuentesAlimento.length-1; i++) {
            do{
                k = (int)Math.floor(Math.random()* (tamanio + 0));
            }while (k==i);

            FoodSource aux;//La nueva fuente de alimento que se produce
            double[] v = new double[dimension];
            FoodSource fs = fuentesAlimento[i];
            double[] x = fs.getX();
            double valor;
            for (int j = 0; j <=x.length-1; j++) {   //tamanio = 200
                phi = Aleatorios.rnd(-1,1);
                valor = x[j] + phi * (x[j] - fuentesAlimento[k].getX()[j]);
                v[j] = valor;
            }
            aux = new FoodSource(v);
            //Aqui se compara la aptitud de X y V y se decide cual quedará en las soluciones
            if(aux.getCalidad() <= fs.getCalidad()){
                replaceFoodSource(i,aux);
                trial[i] = 0;
            }
            else{
                trial[i] = trial[i] + 1;
            }
        }

    }
    public void setFoodSourceProbabilities(){
        double sum=0;
        double[] fit = new double[tamanio];

        for (int i = 0; i <= fuentesAlimento.length-1; i++) {
            fit[i] = fuentesAlimento[i].getValorInverso();
            sum+=fit[i];
        }
        for (int i = 0; i <=fuentesAlimento.length-1; i++) {
            p[i] = fit[i] / sum;
        }
    }

    public void onlookersBeesPhase(){
        setFoodSourceProbabilities();

        int t = 0;
        int i = 0;
        double rnd;
        double phi; int k;
        FoodSource aux;
        double[] v = new double[dimension];
        double valor;
        while(t < tamanio){
            rnd = Aleatorios.rndreal(0f,1f);
            if(rnd < p[i]){
                //Inicio de movimiento
                do{
                    k = (int)Math.floor(Math.random()* (tamanio + 0));
                }while (k==i);

                FoodSource fs = fuentesAlimento[i];
                double[] x = fs.getX();
                for (int j = 0; j <=x.length-1; j++) {
                    phi = Aleatorios.rnd(-1,1);
                    valor = x[j] + phi * (x[j] - fuentesAlimento[k].getX()[j]);
                    v[j] = valor;
                }
                aux = new FoodSource(v);
                if(aux.getCalidad() <= fs.getCalidad()){
                    replaceFoodSource(i,aux);
                    trial[i] = 0;
                }
                else{
                    trial[i] = trial[i]+1;
                }
                //Fin de movimiento

            }
            t++;

            i = (i >= (tamanio-1)) ? 0 : i + 1;
        }
    }

    public void scoutBeesPhase(){
        int mayor= trial[0];
        int indice = 0;
        for (int i = 0; i <=trial.length-1; i++) {
            if(trial[i]>mayor){
                mayor = trial[i];
                indice = i;
            }
        }
        if(mayor > MAX_TRIAL){
            //Se crea una variación a la fuente de alimento
            FoodSource fs = fuentesAlimento[indice];
            FoodSource nuevo;
            double[] x = fs.getX();
            double[] v = new double[x.length];
            for (int i = 0; i <=x.length-1; i++) {
                double nRnd = this.li + Math.random() * (this.ls-this.li);
                nRnd = (double)Math.round(nRnd * 100d) / 100d;
                v[i] = nRnd;
            }
            nuevo = new FoodSource(v);
            fuentesAlimento[indice] = nuevo;
        }
    }
    public void memorizeBest(){
        fbest = fuentesAlimento[0].getCalidad();
        mejor = fuentesAlimento[0];
        for (int i = 0; i <= fuentesAlimento.length-1; i++) {
            if(fuentesAlimento[i].getCalidad() < fbest){
                fbest = fuentesAlimento[i].getCalidad();
                mejor = fuentesAlimento[i];
            }
        }

    }
    public void mostrarVector(double[] vector){
        for (int i = 0; i <= vector.length-1; i++) {
            System.out.print(vector[i] + " | ");
        }
    }
}
