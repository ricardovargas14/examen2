package listaCircularDoble;

import listaDoble.NodoDoble;

public class ListaCircularDoble<T> {

    private NodoDoble<T> inicio;
    private NodoDoble<T> fin;

    public void insertaInicio(T dato) {
        NodoDoble<T> n = new NodoDoble<>();
        n.setInfo(dato);
        if (inicio == null) {
            inicio = fin = n;
            n.setSig(inicio);
            n.setAnt(inicio);
        } else {
            n.setSig(inicio);
            inicio.setAnt(n);
            inicio = n;
            fin.setSig(inicio);
            n.setAnt(fin);
        }
    }

    public void insertaFinal(T dato) {
        NodoDoble<T> n = new NodoDoble<>();
        n.setInfo(dato);
        if (inicio == null) {
            inicio = fin = n;
            n.setSig(inicio);
            n.setAnt(inicio);
        } else {
            n.setSig(inicio);
            inicio.setAnt(n);
            fin.setSig(n);
            n.setAnt(fin);
            fin = n;
        }
    }

    public T eliminaInicio() {
        T dato = null;
        if (inicio == null) {
            System.out.println("Lista vacía");
        } else {
            dato = inicio.getInfo();
            if (inicio == fin) {
                inicio = fin = null;
            } else {
                fin.setSig(inicio.getSig());
                inicio = inicio.getSig();
                inicio.setAnt(fin);
            }
        }
        return dato;
    }

    public T eliminaFin() {
        T dato = null;
        if (inicio == null) {
            System.out.println("Lista vacía");
        } else {
            dato = fin.getInfo();
            if (inicio == fin) {
                inicio = fin = null;
            } else {
                NodoDoble<T> r = fin.getAnt();
                r.setSig(inicio);
                inicio.setAnt(r);
                fin = r;
            }
        }
        return dato;
    }

    @Override
    public String toString() {
        String s = "ListaCircularDoble{";
        if (inicio != null) {
            NodoDoble<T> r = inicio;
            do {
                s += r.getInfo();
                r = r.getSig();
                if (r != inicio) {
                    s += ", ";
                }
            } while (r != inicio);
        }
        s += "}";
        return s;
    }

    // requisitos de examen:

    // método recursivo que muestre la lista
    private String mostrarRecursivo(NodoDoble<T> x) {
        if (x == null) {
            return "";
        } else {
            String s = x.getInfo().toString();
            if (x.getSig() != null) {
                s += ", ";
            }
            return s + mostrarRecursivo(x.getSig());
        }
    }

    public void mostrarRecursivo() {
        System.out.println(mostrarRecursivo(inicio));
    }

    // método que elimina el dato que se le pasa como parámetro
    public T eliminaX(T x) {
        T dato = null;
        if (inicio != null) {
            if (inicio.getInfo().equals(x)) {
                dato = eliminaInicio();
            } else if (fin.getInfo().equals(x)) {
                dato = eliminaFin();
            } else {
                NodoDoble<T> r = inicio.getSig();
                while (r != inicio && !r.getInfo().equals(x)) {
                    r = r.getSig();
                }
                if (r != inicio) {
                    dato = r.getInfo();
                    r.getAnt().setSig(r.getSig());
                    r.getSig().setAnt(r.getAnt());
                }
            }
        }
        return dato;
    }

    // método que busca el indice de un dato que se le pasa como parámetro
    public int buscar(T x) {
        int indice = -1;
        if (inicio != null) {
            NodoDoble<T> r = inicio;
            int i = 0;
            while (r != fin && !r.getInfo().equals(x)) {
                r = r.getSig();
                i++;
            }
            if (r.getInfo().equals(x)) {
                indice = i;
            }
        }
        return indice;
    }

    // método que elimina el dato que se encuentra en la posición que se le pasa
    // como parámetro
    public T eliminaPosición(int posición) {
        T dato = null;
        // si la posición es 0, se elimina el inicio
        if (posición == 0) {
            dato = eliminaInicio();
        } else {
            // si es la última posición, se elimina el final
            if (inicio == fin) {
                dato = eliminaInicio();
            } else {
                // si no es la primera ni la última posición, se busca el nodo
                // anterior a la posición
                NodoDoble<T> r = inicio;
                int i = 0;
                while (r != fin && i < posición - 1) {
                    r = r.getSig();
                    i++;
                }
                // si se encontró el nodo anterior a la posición, se elimina el
                // nodo que sigue
                if (r != fin) {
                    dato = r.getSig().getInfo();
                    r.setSig(r.getSig().getSig());
                    r.getSig().setAnt(r);
                }
            }
        }
        return dato;
    }

    // método que ordena la lista con método de la burbuja
    public void ordenarLista() {
        if (inicio != null) {
            NodoDoble<T> r = inicio;
            do {
                NodoDoble<T> s = r.getSig();
                do {
                    if (((Comparable) r.getInfo()).compareTo(s.getInfo()) > 0) {
                        T aux = r.getInfo();
                        r.setInfo(s.getInfo());
                        s.setInfo(aux);
                    }
                    s = s.getSig();
                } while (s != inicio);
                r = r.getSig();
            } while (r != fin);
        }
    }

    // método que inserta un dato en la posición que se le pasa como parámetro
    public void insertaEnPosición(T dato, int posición) {
        NodoDoble<T> n = new NodoDoble<>();
        n.setInfo(dato);
        if (posición == 0) {
            insertaInicio(dato);
        } else {
            NodoDoble<T> r = inicio;
            int i = 0;
            while (r != fin && i < posición - 1) {
                r = r.getSig();
                i++;
            }
            if (r != fin) {
                n.setSig(r.getSig());
                r.getSig().setAnt(n);
                r.setSig(n);
                n.setAnt(r);
            }
        }
    }
}
