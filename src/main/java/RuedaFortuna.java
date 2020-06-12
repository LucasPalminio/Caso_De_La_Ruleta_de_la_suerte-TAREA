public class RuedaFortuna {
    private int[] casillas;

    //Este metodo inicializa la rueda, con un numero de casillas ingresado por parametro,
    //ademas cada casilla se le asigna un valor entre 1 y 100
    public void inicializarRueda(int numeroCasillas){
        if(numeroCasillas>= 4 && numeroCasillas<=100){
            casillas = new int[numeroCasillas];
            for (int i = 0; i < numeroCasillas; i++) {
                casillas[i] = (int) (Math.random()*99.0 + 1.0);
            }
        }else{
            System.out.println("Error: el largo de las ruedas debe ser mayor o igual a 4 y menor o igual a 100");
        }

    }

    public int lanzarRueda() {
        if (casillas != null) {
            int indice = (int) (Math.random() * casillas.length);
            return casillas[indice];
        }else{
            System.out.println("Error: la rueda aun no se ha inicializado");
            return -1;
        }

    }

    public int cantidadDeCasillas(){
        return casillas.length;
    }
}

