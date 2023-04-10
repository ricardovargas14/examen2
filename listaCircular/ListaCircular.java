package listaCircular;

import listaSimple.Nodo;

public class ListaCircular<T> {
    private Nodo<T> inicio;
    private Nodo<T> fin;

    public ListaCircular() {
        inicio = null;
        fin = null;
    }

    public void insertaInicio(T dato) {
        Nodo<T> n = new Nodo<>();
        n.setInfo(dato);
        if (inicio == null) {
            inicio = fin = n;
            n.setSig(inicio);
        } else {
            n.setSig(inicio);
            inicio = n;
            fin.setSig(inicio);
        }
    }

    public void insertaFin(T dato) {
        Nodo<T> n = new Nodo<>();
        n.setInfo(dato);
        if (inicio == null) {
            inicio = fin = n;
            n.setSig(inicio);
        } else {
            n.setSig(inicio);
            fin.setSig(n);
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
            }
        }
        return dato;
    }

    public T eliminaFinal() {
        T dato = null;
        if (inicio == null) {
            System.out.println("Lista vacía");
        } else {
            dato = fin.getInfo();
            if (inicio == fin) {
                inicio = fin = null;
            } else {
                Nodo<T> r = inicio;
                while (r.getSig() != fin) {
                    r = r.getSig();
                }
                fin = r;
                fin.setSig(inicio);
            }
        }
        return dato;
    }

    @Override
    public String toString() {
        String s = "ListaCircular{";
        if (inicio == null) {
            s += "vacía";
        } else {
            Nodo<T> r = inicio;
            do {
                s += r.getInfo();
                if (r != fin) {
                    s += ", ";
                }
                r = r.getSig();
            } while (r != inicio);
        }
        s += '}';
        return s;
    }

    // métodos de requisito de examen

    // método recursivo que imprime los datos de la lista circular
    private String mostrarRecursivo(Nodo<T> x) {
        String s = "";
        if (x != fin) {
            s += x.getInfo() + ", ";
            s += mostrarRecursivo(x.getSig());
        } else {
            s += x.getInfo();
        }
        return s;
    }

    public void mostrarRecursivo() {
        System.out.println(mostrarRecursivo(inicio));
    }

    // método que elimina el dato que se pasa como parámetro
    public T eliminaX(T x) {
        T dato = null;
        if (inicio != null) {
            if (inicio == fin) {
                if (inicio.getInfo().equals(x)) {
                    dato = inicio.getInfo();
                    inicio = fin = null;
                }
            } else {
                if (inicio.getInfo().equals(x)) {
                    dato = inicio.getInfo();
                    fin.setSig(inicio.getSig());
                    inicio = inicio.getSig();
                } else {
                    Nodo<T> r = inicio;
                    while (r.getSig() != fin && !r.getSig().getInfo().equals(x)) {
                        r = r.getSig();
                    }
                    if (r.getSig() != fin) {
                        dato = r.getSig().getInfo();
                        r.setSig(r.getSig().getSig());
                    } else {
                        if (fin.getInfo().equals(x)) {
                            dato = fin.getInfo();
                            fin = r;
                            fin.setSig(inicio);
                        }
                    }
                }
            }
        }
        return dato;
    }

    // método que recibe un dato como parámetro y devuelve el indice de la lista
    public int buscar(T x) {
        int indice = -1;
        if (inicio != null) {
            Nodo<T> r = inicio;
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

    // método que recibe un entero como parámetro y elimina el dato de la lista
    // que se encuentra en esa posición
    public T eliminaPosición(int posición) {
        T dato = null;
        if (inicio != null) {
            if (posición == 0) {
                dato = inicio.getInfo();
                if (inicio == fin) {
                    inicio = fin = null;
                } else {
                    fin.setSig(inicio.getSig());
                    inicio = inicio.getSig();
                }
            } else {
                Nodo<T> r = inicio;
                int i = 0;
                while (r != fin && i < posición - 1) {
                    r = r.getSig();
                    i++;
                }
                if (r != fin) {
                    dato = r.getSig().getInfo();
                    r.setSig(r.getSig().getSig());
                }
            }
        }
        return dato;
    }

    // método que ordena la lista 
    public void ordenarLista() {
        if (inicio != null) {
            Nodo<T> r = inicio;
            while (r != fin) {
                Nodo<T> s = r.getSig();
                while (s != fin.getSig()) {
                    if (r.getInfo().toString().compareTo(s.getInfo().toString()) > 0) {
                        T aux = r.getInfo();
                        r.setInfo(s.getInfo());
                        s.setInfo(aux);
                    }
                    s = s.getSig();
                }
                r = r.getSig();
            }
        }
    }

    // método que inserta un dato en la posición que se pasa como parámetro
    public void insertaEnPosición(T dato, int posición) {
        Nodo<T> n = new Nodo<>();
        n.setInfo(dato);
        if (inicio == null) {
            inicio = fin = n;
            n.setSig(inicio);
        } else {
            if (posición == 0) {
                n.setSig(inicio);
                inicio = n;
                fin.setSig(inicio);
            } else {
                Nodo<T> r = inicio;
                int i = 0;
                while (r != fin && i < posición - 1) {
                    r = r.getSig();
                    i++;
                }
                if (r != fin) {
                    n.setSig(r.getSig());
                    r.setSig(n);
                } else {
                    n.setSig(inicio);
                    fin.setSig(n);
                    fin = n;
                }
            }
        }
    }
}
