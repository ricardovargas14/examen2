package listaDoble;

public class ListaDoble<T> {
    NodoDoble<T> inicio;

    public void insertaInicio(T dato) {
        NodoDoble<T> n = new NodoDoble<>();
        n.setInfo(dato);
        n.setSig(inicio);
        n.setAnt(null);
        if (inicio != null) {
            inicio.setAnt(n);
        }
        inicio = n;
    }

    public T eliminaInicio() {
        T dato = null;
        if (inicio == null) {
            System.out.println("Lista vacía");
        } else {
            dato = inicio.getInfo();
            if (inicio.getSig() == null) {
                inicio = null;
            } else {
                inicio = inicio.getSig();
                inicio.setAnt(null);
            }
        }
        return dato;
    }

    public void insertaFin(T dato) {
        NodoDoble<T> n = new NodoDoble<>();
        n.setInfo(dato);
        n.setSig(null);
        if (inicio == null) {
            n.setAnt(inicio);
            inicio = n;
        } else {
            NodoDoble<T> r = inicio;
            while (r.getSig() != null) {
                r = r.getSig();
            }
            r.setSig(n);
            n.setAnt(r);
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
                NodoDoble<T> r = inicio;
                while (r.getSig() != null) {
                    r = r.getSig();
                }
                dato = r.getInfo();
                r.getAnt().setSig(null);
            }
        }
        return dato;
    }

    @Override
    public String toString() {
        String s = "ListaDoble{";
        if (inicio == null) {
            s += "vacía";
        } else {
            NodoDoble<T> r = inicio;
            while (r != null) {
                s += r.getInfo();
                r = r.getSig();
                if (r != null) {
                    s += ", ";
                }
            }
        }
        s += '}';
        return s;
    }

    // requisitos para el examen

    // método recursivo que muestre el contenido de la lista
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

    // método que recibe un dato como parámetro y lo elimina de la lista
    public T eliminarX(T x) {
        T dato = null;
        if (inicio != null) {
            if (inicio.getInfo().equals(x)) {
                dato = inicio.getInfo();
                if (inicio.getSig() == null) {
                    inicio = null;
                } else {
                    inicio = inicio.getSig();
                    inicio.setAnt(null);
                }
            } else {
                NodoDoble<T> r = inicio;
                while (r.getSig() != null && !r.getSig().getInfo().equals(x)) {
                    r = r.getSig();
                }
                if (r.getSig() != null) {
                    dato = r.getSig().getInfo();
                    if (r.getSig().getSig() == null) {
                        r.setSig(null);
                    } else {
                        r.setSig(r.getSig().getSig());
                        r.getSig().setAnt(r);
                    }
                }
            }
        }
        return dato;
    }

    // método que recibe un dato como parámetro y regresa en qué posición se
    // encuentra
    public int buscar(T x) {
        int pos = 0;
        if (inicio != null) {
            NodoDoble<T> r = inicio;
            while (r != null) {
                if (r.getInfo().equals(x)) {
                    return pos;
                }
                r = r.getSig();
                pos++;
            }
        }
        return -1;
    }

    // método que elimina el dato que se encuentra en la posición dada como
    // parámetro
    public T eliminarPosición(int posición) {
        T dato = null;
        if (inicio != null) {
            if (posición == 0) {
                dato = inicio.getInfo();
                if (inicio.getSig() == null) {
                    inicio = null;
                } else {
                    inicio = inicio.getSig();
                    inicio.setAnt(null);
                }
            } else {
                NodoDoble<T> r = inicio;
                int pos = 0;
                while (r.getSig() != null && pos < posición - 1) {
                    r = r.getSig();
                    pos++;
                }
                if (r.getSig() != null) {
                    dato = r.getSig().getInfo();
                    if (r.getSig().getSig() == null) {
                        r.setSig(null);
                    } else {
                        r.setSig(r.getSig().getSig());
                        r.getSig().setAnt(r);
                    }
                }
            }
        }
        return dato;
    }

    // método que ordena la lista
    public void ordenarLista() {
        if (inicio != null) {
            NodoDoble<T> r = inicio;
            while (r.getSig() != null) {
                NodoDoble<T> s = r.getSig();
                while (s != null) {
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

    // método que inserta un dato en la posición dada como parámetro
    public void insertaEnPosición(T dato, int posición) {
        NodoDoble<T> n = new NodoDoble<>();
        n.setInfo(dato);
        if (inicio == null) {
            n.setAnt(inicio);
            inicio = n;
        } else {
            if (posición == 0) {
                n.setSig(inicio);
                inicio.setAnt(n);
                inicio = n;
            } else {
                NodoDoble<T> r = inicio;
                int pos = 0;
                while (r.getSig() != null && pos < posición - 1) {
                    r = r.getSig();
                    pos++;
                }
                if (r.getSig() == null) {
                    r.setSig(n);
                    n.setAnt(r);
                } else {
                    n.setSig(r.getSig());
                    r.getSig().setAnt(n);
                    r.setSig(n);
                    n.setAnt(r);
                }
            }
        }
    }
}
