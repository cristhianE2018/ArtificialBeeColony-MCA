# ArtificialBeeColony-MCA
Implementación del algoritmo de la colonia de abejas artificiales para la resolución de problemas de optimización utilizando el lenguaje de programación Java.
# Descripción
Se plantea una estructura en la cual se puedan abarcar la mayor parte de funciones que busquen optimización y
solo indicarle al algoritmo cual se desea resolver.
# Instancia
Se hace una instancia de la clase ABC pasandole como argumentos los siguientes valores: 
```
 ABC eb = new ABC(
                5000, //Numero de fuentes de alimento
                -100,   //Limite inferior
                100,   //Limite superior
                10,
                15000
        );
        eb.run();
```
## En el archivo src/FoodSource hay una función llamada: obtainCantidadNectar, ese método se modifica dependiendo la función que se quiera optimizar.
### Ejemplo con la función Step
```
public double obtaintCantidadNectar(){
        double f = 0.0;
        for (int i = 0; i <=x.length-1; i++) {
            f = f + Math.pow((Math.abs(x[i] + 0.5)),2);
        }
        return f;
    }
```
