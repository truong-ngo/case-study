package manager;

import java.util.List;

public interface ManagerMap<E> {
    void add(E item);
    void update(int id);
    void delete(int id);
    void display(Object item);
}
