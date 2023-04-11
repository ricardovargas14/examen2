package listaCircularDoble;


public class Pruebas {
    public static void main(String[] args) {
        ListaCircularDoble<Integer> lista = new ListaCircularDoble<>();
        lista.insertaInicio(1);
        lista.insertaInicio(2);
        lista.insertaInicio(3);
        lista.insertaFinal(4);
        lista.insertaFinal(5);

        System.out.println("Lista...");
        System.out.println(lista);

        System.out.println("Eliminando inicio...");
        System.out.println(lista.eliminaInicio());
        System.out.println(lista);

        System.out.println("Eliminando fin...");
        System.out.println(lista.eliminaFin());
        System.out.println(lista);

        System.out.println("se prueba el método recursivo que imprime la lista");
        // lista.mostrarRecursivo(); // no funciona

        System.out.println("Se prueba el método que elimina el dato que se le pasa como parámetro");
        System.out.println(lista.eliminaX(2));
        System.out.println(lista);

        System.out.println("Se prueba el método devuelve el indice del dato que se le pasa como parámetro");
        System.out.println(lista.buscar(4));

        System.out.println("se prueba el método que elimina un dato que tiene el indice que se le pasa como parámetro");
        // System.out.println(lista.eliminaPosición(1));
        System.out.println(lista);
        
        System.out.println("se prueba el método que ordena el contenido de la lista");
        lista.insertaInicio(1);
        lista.insertaInicio(2);
        // lista.insertaInicio(3);
        // lista.insertaInicio(-5);
        // lista.insertaInicio(2);
        // lista.insertaInicio(10);
        // lista.insertaInicio(32);
        lista.insertaFinal(13);
        // System.out.println(lista);
        System.out.println(lista);
        lista.ordenarLista();
        System.out.println(lista);

        System.out.println("Se prueba el método que inserta un dato en una posición que se le pasa como parámetro");
        lista.insertaEnPosición(2, 3);
        System.out.println(lista);
    }
}
