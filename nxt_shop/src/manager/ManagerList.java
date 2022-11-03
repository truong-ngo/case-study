package manager;

import java.util.List;

public interface ManagerList<E> {
    void add(E item);
    void update(int id);
    void delete(int id);
}
