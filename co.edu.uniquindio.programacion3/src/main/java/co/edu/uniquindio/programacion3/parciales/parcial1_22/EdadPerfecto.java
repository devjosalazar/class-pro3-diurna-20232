package co.edu.uniquindio.programacion3.parciales.parcial1_22;


import java.util.List;

public class EdadPerfecto {
    public Cliente[][] clientes = {
            {new Cliente(5), new Cliente(7), new Cliente(1), new Cliente(3), new Cliente(31)},
            {new Cliente(6), new Cliente(45), new Cliente(13), new Cliente(89), new Cliente(37)},
            {new Cliente(2), new Cliente(28), new Cliente(496), new Cliente(8128), new Cliente(43)},
            {new Cliente(11), new Cliente(4), new Cliente(8), new Cliente(89), new Cliente(10)},
    };

    public List<Cliente> listaPerfectos;
    public List<Cliente> listaMenores;


    public static void main(String[] args) {

        EdadPerfecto ep = new EdadPerfecto();
        recorrerMatriz(ep.clientes,0,0, ep.listaPerfectos, ep.listaMenores);

    }

    public static void recorrerMatriz(Cliente[][] clientes, int i, int j, List<Cliente> listaPerfectos, List<Cliente> listaMenores) {

        if (i <= clientes.length-1){
            if (j < clientes[i].length-1){

//                validarEdad(Cliente[i][j],0);

                if (j == clientes[i].length-1){
                    i++;
                    j=0;
                } else {
                    j++;
                }

                recorrerMatriz(clientes,i,j,listaPerfectos,listaMenores);
            }
        }
    }

//    public static Cliente[][] validarEdad(Cliente clientes, int i){
//        int edad;
//
//        return
//    }
}
