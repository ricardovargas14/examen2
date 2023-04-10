package listaDoble;

public class NodoDoble<T> {
    private T info;
    private NodoDoble<T> ant;
    private NodoDoble<T> sig;

    public NodoDoble(T info) {
        this.info = info;
        ant = null;
        sig = null;
    }

    public NodoDoble() {
        info = null;
        ant = null;
        sig = null;
    }

    public NodoDoble(T info, NodoDoble<T> ant, NodoDoble<T> sig) {
        this.info = info;
        this.ant = ant;
        this.sig = sig;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NodoDoble<T> getAnt() {
        return ant;
    }

    public void setAnt(NodoDoble<T> ant) {
        this.ant = ant;
    }

    public NodoDoble<T> getSig() {
        return sig;
    }

    public void setSig(NodoDoble<T> sig) {
        this.sig = sig;
    }

    @Override
    public String toString() {
        return "NodoDoble{" + "info=" + info + ", ant=" + ant + ", sig=" + sig + '}';
    }

    
}
