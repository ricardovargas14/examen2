package listaSimple;

public class Pruebas {
    public static void main(String[] args) {
        Pruebas pruebas = new Pruebas();
        // pruebas.pruebaNodo();
        pruebas.pruebaLista();
    }

    private void pruebaNodo() {
        Nodo<Integer> nodo1 = new Nodo<>(1);
        Nodo<Integer> nodo2 = new Nodo<>(2);
        Nodo<Integer> nodo3 = new Nodo<>();
        Nodo<Integer> nodo4 = new Nodo<>(4, nodo2);
        // nodo4.setSig(null);

        // se muestra el contenido de los nodos
        System.out.println("Contenido de los nodos:");
        System.out.println("nodo1: " + nodo1);
        System.out.println("nodo2: " + nodo2);
        System.out.println("nodo3: " + nodo3);
        System.out.println("nodo4: " + nodo4);

        // se prueba el método setInfo
        System.out.println("Al nodo1 se le asigna el valor 10");
        nodo1.setInfo(10);
        System.out.println("Al nodo3 se le asigna el valor 20");
        nodo3.setInfo(20);

        // se muestra el contenido de los nodos
        System.out.println("Contenido de los nodos:");
        System.out.println("nodo1: " + nodo1);
        System.out.println("nodo2: " + nodo2);
        System.out.println("nodo3: " + nodo3);
        System.out.println("nodo4: " + nodo4);

        // se prueba el método setSig
        System.out.println("Al nodo1 se le asigna como siguiente nodo al nodo2");
        nodo1.setSig(nodo2);
        System.out.println("Al nodo2 se le asigna como siguiente nodo al nodo3");
        nodo2.setSig(nodo3);
        // System.out.println("Al nodo3 se le asigna como siguiente nodo al nodo4");
        // nodo3.setSig(nodo4);
        /*
         * La linea anterior genera una excepción StackOverflowError, porque el nodo3
         * ya tiene como siguiente nodo al nodo4, y el nodo4 ya tiene como siguiente
         * el nodo2 y el nodo2 ya tiene como siguiente el nodo3. Esto se invoca de forma
         * recursiva hasta que se llena la pila de llamadas y se produce un error.
         */
        System.out.println("Al nodo4 se le asigna como siguiente nodo al nodo1");
        nodo4.setSig(nodo1);

        // se muestra el contenido de los nodos
        System.out.println("Contenido de los nodos:");
        System.out.println("nodo1: " + nodo1);
        System.out.println("nodo2: " + nodo2);
        System.out.println("nodo3: " + nodo3);
        System.out.println("nodo4: " + nodo4);

        // se prueba el método getInfo
        System.out.println("Se prueba el método getInfo");
        System.out.println("Contenido de los nodos:");
        System.out.println("nodo1: " + nodo1.getInfo());
        System.out.println("nodo2: " + nodo2.getInfo());
        System.out.println("nodo3: " + nodo3.getInfo());
        System.out.println("nodo4: " + nodo4.getInfo());

        // se prueba el método getSig
        System.out.println("Se prueba el método getSig");
        System.out.println("Contenido de los nodos:");
        System.out.println("nodo1: " + nodo1.getSig());
        System.out.println("nodo2: " + nodo2.getSig());
        System.out.println("nodo3: " + nodo3.getSig());
        System.out.println("nodo4: " + nodo4.getSig());
    }

    private void pruebaLista() {
        ListaSimple<Integer> lista = new ListaSimple<>();
        lista.insertaInicio(1);
        lista.insertaInicio(2);
        lista.insertaFin(3);
        lista.insertaFin(4);

        System.out.println("Contenido de la lista:");
        System.out.println(lista);

        System.out.println("Se elimina el primer elemento de la lista");
        System.out.println(lista.eliminaInicio());

        System.out.println("Contenido de la lista:");
        System.out.println(lista);

        System.out.println("Se elimina el último elemento de la lista");
        System.out.println(lista.eliminaFin());

        System.out.println("Contenido de la lista:");
        System.out.println(lista);

        System.out.println("Se prueba el método mostrarRecursivo");
        System.out.println(lista.mostrarRecursivo());

        System.out.println("Se prueba el método eliminarX");
        System.out.println(lista.eliminarX(2));
        System.out.println(lista.eliminarX(3));

        System.out.println("Contenido de la lista:");
        System.out.println(lista);
        System.out.println(lista.mostrarRecursivo());

        // se añaden elementos a la lista:
        System.out.println("Se añaden elementos a la lista");
        lista.insertaInicio(0);
        lista.insertaFin(2);

        // se muestra el contenido de la lista
        System.out.println("Contenido de la lista:");
        System.out.println(lista);
        System.out.println(lista.mostrarRecursivo());

        // se prueba el método buscar
        System.out.println("Se prueba el método buscar");
        System.out.println("Se busca el elemento 0");
        System.out.println(lista.buscar(0));
        System.out.println("Se busca el elemento 1");
        System.out.println(lista.buscar(1));
        System.out.println("Se busca el elemento 2");
        System.out.println(lista.buscar(2));
        System.out.println("Se busca el elemento 3");
        System.out.println(lista.buscar(3));

        // se prueba el método eliminarPosición
        System.out.println("Se prueba el método eliminarPosición");
        System.out.println("Se elimina el elemento de la posición 2");
        System.out.println(lista.eliminarPosición(2));
        System.out.println("Se elimina el elemento de la posición 0");
        System.out.println(lista.eliminarPosición(0));
        System.out.println("Se elimina el elemento de la posición 3");
        System.out.println(lista.eliminarPosición(3));

        // se muestra el contenido de la lista
        System.out.println("Contenido de la lista:");
        System.out.println(lista);

        // se añaden elementos a la lista:
        System.out.println("Se añaden elementos a la lista");
        lista.insertaInicio(0);
        lista.insertaInicio(1);
        lista.insertaInicio(2);
        lista.insertaInicio(2);
        lista.insertaInicio(2);
        lista.insertaInicio(3);
        lista.insertaFin(-5);

        // se muestra el contenido de la lista
        System.out.println("Contenido de la lista:");
        System.out.println(lista);

        // se prueba el método ordenarLista
        System.out.println("Se prueba el método ordenarLista");
        lista.ordenarLista();
        System.out.println("Contenido de la lista:");
        System.out.println(lista);

        // se prueba el método insertaEnPosición
        System.out.println("Se prueba el método insertaEnPosición");
        System.out.println("Se inserta el elemento 4 en la posición 2");
        lista.insertaEnPosición(4, 2);

        // se muestra el contenido de la lista
        System.out.println("Contenido de la lista:");
        System.out.println(lista);
    }
}
