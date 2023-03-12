/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package session;

import java.util.HashMap;
import java.util.Map;
import model.Employee;

/**
 *
 * @author Somika
 */
public class Session {

    private static Session instance;
    private Map<String, Employee> data;

    private Session() {
        data = new HashMap<>();
    }

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public void put(String key, Employee value) {
        data.put(key, value);
    }

    public Employee get(String key) {
        if (data.containsKey(key)) {
            return data.get(key);
        }
        return null;
    }

    public void clear() {
        data.clear();
    }
}
