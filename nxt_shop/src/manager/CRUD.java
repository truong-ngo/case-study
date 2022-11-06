package manager;

public interface CRUD<E> {
    void add(E item);
    void update(int id, E obj);
    void delete(int id);
}
