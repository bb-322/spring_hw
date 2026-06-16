package hw5.task4.exceptions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Tests {

    public int divide(int a, int b) {
        return a / b;
    }

    @Test
    public void divideByZero() {
        assertThrows(ArithmeticException.class, () -> divide(1, 0));
    }

    int[] array = {1, 2, 3, 4};

    public int getNumber(int[] arr, int idx) {
        return arr[idx];
    }

    @Test
    public void outOfRange() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> getNumber(array, array.length));
    }


}