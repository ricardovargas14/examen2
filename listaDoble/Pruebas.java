package listaDoble;

public class Pruebas {
    public static void main(String[] args) {
        ListaDoble<Integer> lista = new ListaDoble<>();
        lista.insertaInicio(1);
        lista.insertaInicio(2);
        lista.insertaInicio(3);
        lista.insertaInicio(4);
        lista.insertaInicio(5);
        lista.insertaFin(6);

        // se imprime la lista
        System.out.println("se imprime la lista");
        System.out.println(lista);

        // se elimina el inicio
        System.out.println("se elimina el inicio");
        System.out.println(lista.eliminaInicio());
        System.out.println(lista);

        // se elimina el final
        System.out.println("se elimina el final");
        System.out.println(lista.eliminaFin());

        // se imprime la lista
        System.out.println("se imprime la lista");
        System.out.println(lista);

        // se prueba el método mostrarRecursivo
        System.out.println("se prueba el método mostrarRecursivo");
        lista.mostrarRecursivo();

        // se prueba el método que elimina el nodo que contiene el dato
        System.out.println("se prueba el método que elimina el nodo que contiene el dato");
        System.out.println(lista.eliminarX(3));
        System.out.println(lista);
        lista.mostrarRecursivo();
        System.out.println(lista.eliminarX(5));

        // se prueba el método que encuentra el indice del dato que se le pasa
        // como parámetro
        System.out.println("se prueba el método que encuentra el indice del dato que se le pasa como parámetro");
        System.out.println(lista.buscar(4));
        System.out.println(lista.buscar(6));
        System.out.println(lista.buscar(1));

        // se prueba el método que elimina dato que tiene el indice que se le pasa
        // como parámetro
        System.out.println("se prueba el método que elimina dato que tiene el indice que se le pasa como parámetro");
        System.out.println(lista.eliminarPosición(0));
        System.out.println(lista);
        System.out.println(lista.eliminarPosición(1));
        System.out.println(lista);
        System.out.println(lista.eliminarPosición(1));

        // se agregan datos a la lista
        System.out.println("se agregan datos a la lista");
        lista.insertaInicio(1);
        lista.insertaInicio(2);
        lista.insertaInicio(3);
        lista.insertaInicio(4);
        lista.insertaInicio(5);
        lista.insertaFin(-10);

        // se imprime la lista
        System.out.println("se imprime la lista");
        System.out.println(lista);

        // se prueba el método que ordena la lista
        System.out.println("se prueba el método que ordena la lista");
        lista.ordenarLista();

        // se imprime la lista
        System.out.println("se imprime la lista");
        System.out.println(lista);

        // se prueba el método que inserta un dato en la posición que se le pasa
        // como parámetro
        System.out.println("se prueba el método que inserta un dato en la posición que se le pasa como parámetro");
        lista.insertaEnPosición(0, 3);

        // se imprime la lista
        System.out.println("se imprime la lista");
        System.out.println(lista);
    }

}
