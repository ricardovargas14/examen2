package listaCircular;

public class Pruebas {
    public static void main(String[] args) {
        ListaCircular<Integer> listaCircular = new ListaCircular<>();
        listaCircular.insertaInicio(1);
        listaCircular.insertaInicio(2);
        listaCircular.insertaInicio(3);
        listaCircular.insertaInicio(4);
        listaCircular.insertaFin(7);
        listaCircular.insertaFin(8);

        System.out.println("Lista circular:");
        System.out.println(listaCircular);

        System.out.println("Eliminando el inicio:");
        System.out.println(listaCircular.eliminaInicio());
        System.out.println(listaCircular);

        System.out.println("Eliminando el final:");
        System.out.println(listaCircular.eliminaFinal());
        System.out.println(listaCircular);

        System.out.println("Se prueba el método mostrarRecursivo:");
        listaCircular.mostrarRecursivo();

        System.out.println("Se prueba el método que elimina un elemento que se pasa como parámetro:");
        System.out.println(listaCircular.eliminaX(1));
        System.out.println(listaCircular);

        System.out.println("Se prueba el método que busca el indice de un elemento que se pasa como parámetro:");
        System.out.println(listaCircular.buscar(8));

        System.out.println("se prueba el método que elimina el dato que se encuentra en la posición que se pasa como parámetro:");
        System.out.println(listaCircular.eliminaPosición(5));
        System.out.println(listaCircular);

        System.out.println("se prueba el método que ordena la lista:");
        listaCircular.ordenarLista();
        System.out.println(listaCircular);

        System.out.println("se prueba el método que inserta un dato en la posición que se pasa como parámetro:");
        listaCircular.insertaEnPosición(5, 1);
        System.out.println(listaCircular);

    }
}
