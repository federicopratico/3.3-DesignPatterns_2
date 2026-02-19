package observerpattern;

public interface Observable<T> {
    void attach(T o);
    void detach(T o);
    void notifyObservers();
}
