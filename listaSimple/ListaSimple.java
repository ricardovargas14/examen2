package listaSimple;

public class ListaSimple<T> {
    private Nodo<T> inicio;

    public void insertaInicio(T dato) {
        Nodo<T> n = new Nodo<>();
        n.setInfo(dato);
        n.setSig(inicio);
        inicio = n;

    }

    public T eliminaInicio() {
        T dato = inicio.getInfo();
        if (inicio == null) {
            System.out.println("Lista vacía");
        } else {
            inicio = inicio.getSig();
        }
        return dato;
    }

    public void insertaFin(T dato) {
        Nodo<T> n = new Nodo<>();
        n.setInfo(dato);
        // si la lista está vacía, el nuevo nodo será el primero
        if (inicio == null) {
            n.setSig(inicio);
            inicio = n;
        } else { // si no está vacía, se busca el último nodo
            Nodo<T> r = inicio;
            while (r.getSig() != null) {
                r = r.getSig();
            }
            // se inserta el nuevo nodo al final
            r.setSig(n);
            n.setSig(null);
        }
    }

    public T eliminaFin() {
        T dato = null;
        if (inicio == null) {
            System.out.println("Lista vacía");
        } else {
            if (inicio.getSig() == null) {
                dato = inicio.getInfo();
                inicio = null;
            } else {
                Nodo<T> r = inicio;
                Nodo<T> a = r;
                while (r.getSig() != null) {
                    a = r;
                    r = r.getSig();
                }
                dato = r.getInfo();
                a.setSig(null);
            }
        }
        return dato;
    }

    @Override
    public String toString() {
        String s = "ListaSimple{";
        if (inicio != null) {
            Nodo<T> r = inicio;
            while (r != null) {
                s += r.getInfo();
                r = r.getSig();
                if (r != null) {
                    s += ", ";
                }
            }
        } else {
            s += "vacía";
        }
        s += '}';
        return s;
    }

    // requisitos para examen:

    // método recursivo que regresa un String con los datos de la lista
    private String mostrarRecursivo(Nodo<T> x) {
        String s = "";
        if (x != null) {
            s += x.getInfo();
            if (x.getSig() != null) {
                s += ", ";
            }
            s += mostrarRecursivo(x.getSig());
        }
        return s;
    }

    public String mostrarRecursivo() {
        return mostrarRecursivo(inicio);
    }

    // método que recibe un dato y lo elimina de la lista
    public T eliminarX(T x) {
        T dato = null;
        if (inicio != null) {
            if (inicio.getInfo().equals(x)) {
                dato = inicio.getInfo();
                inicio = inicio.getSig();
            } else {
                Nodo<T> r = inicio;
                Nodo<T> a = r;
                while (r != null) {
                    if (r.getInfo().equals(x)) {
                        dato = r.getInfo();
                        a.setSig(r.getSig());
                    }
                    a = r;
                    r = r.getSig();
                }
            }
        }
        return dato;
    }

    // método que recibe un dato y regresa la posición en la que se encuentra
    public int buscar(T x) {
        int posición = 0;
        if (inicio != null) {
            Nodo<T> r = inicio;
            while (r != null) {
                if (r.getInfo().equals(x)) {
                    return posición;
                }
                posición++;
                r = r.getSig();
            }
        }
        return -1;
    }

    // método que recibe un número y elimina el dato que se encuentra en esa
    // posición
    public T eliminarPosición(int posición) {
        T dato = null;
        if (inicio != null) {
            if (posición == 0) { 
                dato = inicio.getInfo();
                inicio = inicio.getSig();
   
            } else {
                Nodo<T> r = inicio;
                Nodo<T> a = r;
                int i = 0;
                while (r != null) {
                    if (i == posición) {
                        dato = r.getInfo();
                        a.setSig(r.getSig());   
                    }
                    a = r;
                    r = r.getSig();
                    i++;
                }
            }
        }
        return dato;
    }

    // método que ordena la lista
    public void ordenarLista() {
        if (inicio != null) {
            Nodo<T> r = inicio;
            while (r != null) {
                Nodo<T> a = r;
                while (a != null) {
                    if (a.getInfo().toString().compareTo(r.getInfo().toString()) < 0) {
                        T aux = r.getInfo();
                        r.setInfo(a.getInfo());
                        a.setInfo(aux);
                    }
                    a = a.getSig();
                }
                r = r.getSig();
            }
        }
    }

    // método que recibe un dato y un número y lo inserta en la posición
    // indicada
    public void insertaEnPosición(T dato, int posición) {
        Nodo<T> n = new Nodo<>();
        n.setInfo(dato);
        if (inicio == null) {
            n.setSig(inicio);
            inicio = n;
        } else {
            if (posición == 0) {
                n.setSig(inicio);
                inicio = n;
            } else {
                Nodo<T> r = inicio;
                Nodo<T> a = r;
                int i = 0;
                while (r != null) {
                    if (i == posición) {
                        n.setSig(r);
                        a.setSig(n);
                    }
                    a = r;
                    r = r.getSig();
                    i++;
                }
            }
        }
    }
}
