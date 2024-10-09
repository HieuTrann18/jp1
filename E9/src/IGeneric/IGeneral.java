package IGeneric;

import java.util.List;

public interface IGeneral <T>{
    void update(T object);
    List<T> sort();
    List <T> getById(int id);
    List<T> getByName(String name);
}
