package co.edu.uniquindio.programacion3.diurna;

public class Parqueadero {
    public static char[][] parqueo={
            {'L', ' ', 'L', 'D', '1','L',' '},
            {'L', ' ', 'L', 'C', ' ','L',' '},
            {' ', ' ', ' ', 'C', ' ',' ',' '},
            {'C', ' ', ' ', 'C', 'D','D',' '},
            {'C', ' ', ' ', ' ', ' ','L',' '},
            {'C', ' ', 'C', ' ', ' ','L',' '},
            {'C', ' ', 'C', ' ', 'C','C',' '},
            {' ', ' ', 'C', ' ', ' ',' ',' '},
            {'C', ' ', 'C', ' ', 'C',' ',' '},
            {'C', ' ', 'R', ' ', 'C',' ','R'},
            {' ', ' ', 'R', ' ', 'C','C','R'},
            {' ', ' ', 'R', ' ', ' ',' ','2'},


    };


    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
    public static void main(String[] args) {
        Parqueadero camilo = new Parqueadero();
        camilo.resuelve(11, 0);
        imprimirRecorridoActual();

    }

    /* ----------------- IMPLEMENTACI�N DEL ALGORITMO ----------------- */
    public void resuelve(int x, int y){ 				// permite introducir unas coordenadas (x, y)
        if (paso(x, y)) { 								// intentar� resolver el laberinto en estas coordenadas
            parqueo[x][y] = 'S'; 						// introduce en las coordenadas (x, y) la entrada
        }
    }

    private boolean paso(int x, int y)
    {
        if(!esPasoValido(x, y)){
            return false;
        }


        if ((parqueo[x][y] == '1'))
        { // si hemos llegado a X quiere decir que hemos encontrado soluci�n
            System.out.println("Se ha parquedo el primer carro");
            imprimirRecorridoActual();
            return true;
            // luego, el algoritmo termina
        }

        if ((parqueo[x][y] == '2'))
        { // si hemos llegado a X quiere decir que hemos encontrado soluci�n
            System.out.println("Se ha parquedo el segundo carro");
            imprimirRecorridoActual();// luego, el algoritmo termina
            return true;
        }


        if (parqueo[x][y]=='C') { // si llegamos a una pared o al mismo punto,
            return false; // entonces el laberinto no puede resolverse y termina.
        }

        if (parqueo[x][y]=='L') { // si llegamos a una pared o al mismo punto,
            return false; // entonces el laberinto no puede resolverse y termina.
        }

        if (parqueo[x][y]=='D') { // si llegamos a una pared o al mismo punto,
            return false; // entonces el laberinto no puede resolverse y termina.
        }
        if (parqueo[x][y]=='R') { // si llegamos a una pared o al mismo punto,
            return false; // entonces el laberinto no puede resolverse y termina.
        }
        if ((parqueo[x][y]=='1')||parqueo[x][y]=='2') { // si llegamos a una pared o al mismo punto,
            return false; // entonces el laberinto no puede resolverse y termina.
        }

        if (parqueo[x][y]=='*') { // si llegamos a una pared o al mismo punto,
            return false; // entonces el laberinto no puede resolverse y termina.
        }

        // si no se cumple ninguna de estas dos situaciones, quiere decir que nos encontramos en un
        // caso intermedio, por lo tanto, que empezamos a recorrer o todav�a no hemos llegado a nada
        parqueo[x][y]='*'; // marcamos la posici�n como visitada (si es la primera, en las coordenadas x e y

        boolean result; // se coloca S de START)

        result=paso(x, y+1); // intentamos ir hacia la DERECHA. Primera llamada recursiva
        result=paso(x+1, y); // intentamos ir hacia ABAJO. Cuarta llamada recursiva
        result=paso(x-1, y); // intentamos ir hacia ARRIBA. Segunda llamada recursiva
        result=paso(x, y-1); // intentamos ir hacia la IZQUIERDA. Tercera llamada recursiva
        parqueo[x][y]=' '; // en el caso de no ser el resultado, se marca con +. Ya fue pisado
        return false; // vuelta atr�s si la soluci�n no se encuentra aqu�
    }

    public static void imprimirRecorridoActual() {
        String salida = "";    // un m�todo toString para arrays bidimensionales, lo programamos a mano
        for (int h=0; h<parqueo.length; h++) { // recorremos filas
            for (int m=0; m<parqueo[h].length; m++) { // recorremos columnas
                salida += parqueo[h][m] + " "; // output es nuestra variable que va almacenando los valores a imprimir
            }
            salida += "\n"; // devolvemos esta variable con un salto de l�nea
        }
        System.out.println("Soluci�n");
        System.out.println(salida);
    }

    private boolean esPasoValido(int x, int y) {
        if(x >= 0 && x <= parqueo.length-1 && y >= 0 && y<= parqueo[x].length-1){
            return true;
        }else{
            return false;
        }
    }
}
