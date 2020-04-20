package HW2.test2;

public class MyArrayDataException extends IndexOutOfBoundsException {
    public MyArrayDataException(int i, int j) { // создаем конструктор с параметрами какого-то объект массива
        super("Ошибка в : " + i + " " + j);
    }
}
