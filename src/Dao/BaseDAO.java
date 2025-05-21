package Dao;

import java.util.List;

public interface BaseDAO <T> {
  T obtenerPorId(int id);
    List<T> obtenerTodos();
    boolean insertar(T entidad);
    boolean actualizar(T entidad);
    boolean eliminar(int id);
}
