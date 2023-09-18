package co.edu.uniquindio.programacion3.parciales.parcial1_22;

public class Laberinto{


    public String[][] laberinto={
            {"L"    , " "    , "L"    , "d", " "            , "L"            , "ENTRADA"      },
            {"L"    , " "    , "L"    , "c"        , " "            , "L"            , " "            },
            {" "    , " "    , " "    , "c"        , " "            , " "            , " "            },
            {"c", " "    , "c", "c"        , "d", "d", " "            },
            {" "    , " "    , " "    , " "            , " "            , "L"            , " "            },
            {" "    , "c", "c", " "            , " "            , "L"            , " "            },
            {" "    , "c", "c", " "            , " "            , "L"            , " "            },
            {" "    , " "    , "c", " "            , " "            , " "            , " "            },
            {" "    , "c", "c", " "            , "c"        , " "            , "c"        },
            {" "    , " "    , "R2"   , " "            , "c"        , " "            , "R"            },
            {"c", " "    , "R"    , " "            , "c"        , "c"        , "R"            },
            {"R1"   , " "    , "R"    , " "            , " "            , " "            , "d"},
    };


    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
    public static void main(String[] args) {
        Laberinto m = new Laberinto(); 												// construimos un objeto de la clase Laberinto por defecto
//        m.laberinto[8][1] = "X"; 													// introducimos en este caso, la salida (X) en las coorden//adas (1,1)
        m.resuelve(0, 6); 													// ahora, introducimos la entrada (S) en las coordenadas (8,1) y llamamos al algoritmo
        m.resuelve(0, 6);
    }


    /* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
    public void resuelve(int x, int y){ 				// permite introducir unas coordenadas (x, y)
        if (paso(x, y)) { 								// intentará resolver el laberinto en estas coordenadas
            laberinto[x][y] = "E"; 						// introduce en las coordenadas (x, y) la entrada
            System.out.println("---------");
        }
    }

    private boolean paso(int x, int y)
    {

        if (laberinto.length-1 < x || x < 0){ //Valida que se encuentre en un rango valido la matriz en el eje vertical
            return false;
        }

        if (laberinto[x].length-1 < y || y < 0){ //Valida que se encuentre en un rango valido la matriz en el eje horizontal
            return false;
        }

        if (laberinto[x][y]=="R1" || laberinto[x][y]=="R2"){ // si hemos llegado a X quiere decir que hemos encontrado solución
            laberinto[x][y] = "c";
            System.out.println(imprimirLaberintoRecursivo(0,0, ""));
            return true; // luego, el algoritmo termina
        }

        if (laberinto[x][y]=="c"||laberinto[x][y]=="L"||laberinto[x][y]=="d"||laberinto[x][y]=="R"||laberinto[x][y]=="+" ||laberinto[x][y]=="f"||laberinto[x][y]=="c") { // si llegamos a una pared o al mismo punto,
            return false; // entonces el laberinto no puede resolverse y termina.
        }

        // si no se cumple ninguna de estas dos situaciones, quiere decir que nos encontramos en un
        // caso intermedio, por lo tanto, que empezamos a recorrer o todavía no hemos llegado a nada
        laberinto[x][y]="+"; // marcamos la posición como visitada (si es la primera, en las coordenadas x e y

        boolean result; // se coloca S de START)

        result=paso(x, y-1); // intentamos ir hacia la IZQUIERDA. Primera llamada recursiva
        if (result){
            laberinto[x][y]=" ";
            return true;
        }; // si el resultado es el final, entonces el algoritmo termina

        result=paso(x, y+1); // intentamos ir hacia la DERECHA. Primera llamada recursiva
        if (result){
            laberinto[x][y]=" ";
            return true;
        }; // si el resultado es el final, entonces el algoritmo termina

        result=paso(x+1, y); // intentamos ir hacia ABAJO. Tercera llamada recursiva
        if (result){
            laberinto[x][y]=" ";
            return true;
        }; // si el resultado es el final, entonces el algoritmo termina termina

        result=paso(x-1, y); // intentamos ir hacia ARRIBA. Cuarta llamada recursiva
        if (result){
            laberinto[x][y]=" ";
            return true;
        }; // si el resultado es el final, entonces el algoritmo termina

        // si no hemos encontrado la solución en estos cuatros movimientos, volvemos atrás, aunque hay que
        // considerar que en este punto, todas las llamadas recursivas han finalizado. Si en ninguna de ellas
        // se ha conseguido el éxito, entonces el algoritmo termina y devuelve false.
        laberinto[x][y]="f"; // en el caso de no ser el resultado, se marca con +. Ya fue pisado
        return false; // vuelta atrás si la solución no se encuentra aquí
    }

    private String imprimirLaberintoRecursivo(int x, int y, String salida){ //Se imprime el laberinto de manera recurisva

        if (x < laberinto.length){
            if (y < laberinto[x].length){

                salida += laberinto[x][y] + " ";

                if (y == laberinto[x].length-1){
                    x++;
                    y = 0;
                    salida += "\n";
                } else {
                    y++;
                }

                return imprimirLaberintoRecursivo(x, y, salida);
            }
            return salida;
        } else {
            return salida;
        }
    }
}