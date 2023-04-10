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
    private String mostrarRecursivo(NodoDoble x) {
        String s = "";
        if (x == null) {
            return s;
        } else {
            s += x.getInfo();
            if (x.getSig() != inicio) {
                s += ", ";
            }
            s += mostrarRecursivo(x.getSig());
        }
        return s;
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
    
}
