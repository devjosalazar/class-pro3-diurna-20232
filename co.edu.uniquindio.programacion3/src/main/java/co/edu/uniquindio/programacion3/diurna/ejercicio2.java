package co.edu.uniquindio.programacion3.diurna;

import java.util.ArrayList;

public class ejercicio2 {

    public static void main(String[] args) {


    }


    private static void recorrerMatriz(String[][] matriz, int i, int j, ArrayList<Integer> lista){
        if(i <= matriz.length-1){
            if(j <=matriz[i].length-1){

                int valor = sumaN_Enteros(Integer.parseInt(matriz[i][j]));
                if(valor > 10){
                    lista.add(valor);
                }


                if(j == matriz[i].length-1)	{
                    i++;
                    j=0;
                    System.out.println();
                }else{
                    j++;
                }
                recorrerMatriz(matriz, i, j, lista);
            }
        }
    }

    public static int sumaN_Enteros(int n)
    {
        int resultado = 0;
        if(n == 1)
        {
            return 1;
        }
        else
        {
            resultado = sumaN_Enteros(n-1) + n;
            return resultado;
        }
    }
}
