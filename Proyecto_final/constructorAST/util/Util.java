package util;

import java.math.BigDecimal;

public class Util {
    /**
     * Suma dos números teniendo en cuenta sus tipos. Prioridad: Double -> Float ->
     * Long -> Integer
     * 
     * @param a
     * @param b
     * @return
     */
    public static Number addNumbers(Number a, Number b) {
        if (a instanceof Double || b instanceof Double) {
            return a.doubleValue() + b.doubleValue();
        } else if (a instanceof Float || b instanceof Float) {
            return a.floatValue() + b.floatValue();
        } else if (a instanceof Long || b instanceof Long) {
            return a.longValue() + b.longValue();
        } else {
            return a.intValue() + b.intValue();
        }
    }

    /**
     * Resta dos números teniendo en cuenta sus tipos. Prioridad: Double -> Float ->
     * Long -> Integer
     * 
     * @param a
     * @param b
     * @return
     */
    public static Number substractNumbers(Number a, Number b) {
        if (a instanceof Double || b instanceof Double) {
            return a.doubleValue() - b.doubleValue();
        } else if (a instanceof Float || b instanceof Float) {
            return a.floatValue() - b.floatValue();
        } else if (a instanceof Long || b instanceof Long) {
            return a.longValue() - b.longValue();
        } else {
            return a.intValue() - b.intValue();
        }
    }

    /**
     * Multiplica dos números teniendo en cuenta sus tipos. Prioridad: Double ->
     * Float -> Long -> Integer
     * 
     * @param a
     * @param b
     * @return
     */
    public static Number multiplyNumbers(Number a, Number b) {
        if (a instanceof Double || b instanceof Double) {
            return a.doubleValue() * b.doubleValue();
        } else if (a instanceof Float || b instanceof Float) {
            return a.floatValue() * b.floatValue();
        } else if (a instanceof Long || b instanceof Long) {
            return a.longValue() * b.longValue();
        } else {
            return a.intValue() * b.intValue();
        }
    }

    /**
     * Divide dos números teniendo en cuenta sus tipos. Prioridad: Double -> Float
     * -> Long -> Integer
     * 
     * @param a
     * @param b
     * @return
     */
    public static Number divideNumbers(Number a, Number b) {
        if (a instanceof Double || b instanceof Double) {
            return a.doubleValue() * b.doubleValue();
        } else if (a instanceof Float || b instanceof Float) {
            return a.floatValue() * b.floatValue();
        } else if (a instanceof Long || b instanceof Long) {
            return a.longValue() * b.longValue();
        } else {
            return a.intValue() * b.intValue();
        }
    }

    /**
     * Compara dos números teniendo en cuenta sus tipos. Prioridad: Double -> Float
     * -> Long -> Integer
     * 
     * @param a
     * @param b
     * @return 1 si a > b, -1 si a < b, 0 si a == b;
     */
    public static int compareNumbers(Number a, Number b) {
        if (a instanceof Double || b instanceof Double) {
            if (a.doubleValue() > b.doubleValue()) {
                return 1;
            } else if (a.doubleValue() < b.doubleValue()) {
                return -1;
            } else
                return 0;
        } else if (a instanceof Float || b instanceof Float) {
            if (a.floatValue() > b.floatValue()) {
                return 1;
            } else if (a.floatValue() < b.floatValue()) {
                return -1;
            } else
                return 0;
        } else if (a instanceof Long || b instanceof Long) {
            if (a.longValue() > b.longValue()) {
                return 1;
            } else if (a.longValue() < b.longValue()) {
                return -1;
            } else
                return 0;
        } else {
            if (a.intValue() > b.intValue()) {
                return 1;
            } else if (a.intValue() < b.intValue()) {
                return -1;
            } else
                return 0;
        }
    }
}
