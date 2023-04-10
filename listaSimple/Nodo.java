package listaSimple;

public class Nodo<T> {
    private T info;
    private Nodo<T> sig;

    public Nodo() {
        this.info = null;
        this.sig = null;
    }

    public Nodo(T info) {
        this.info = info;
        this.sig = null;
    }

    public Nodo(T info, Nodo<T> sig) {
        this.info = info;
        this.sig = sig;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Nodo<T> getSig() {
        return sig;
    }

    public void setSig(Nodo<T> sig) {
        this.sig = sig;
    }

    @Override
    public String toString() {
        return "Nodo{" + "info=" + info + ", sig=" + sig + '}';
    }
    
}
