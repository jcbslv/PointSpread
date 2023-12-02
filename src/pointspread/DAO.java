/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pointspread;

/**
 *
 * @author jcb
 */
import java.util.List;

public interface DAO<T> {
    T get(String code);
    List<T> getAll();
    boolean add(T t);
    boolean update(T t);
    boolean delete(T t);
}
