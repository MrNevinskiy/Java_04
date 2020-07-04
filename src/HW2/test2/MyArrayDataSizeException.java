package HW2.test2;

public class MyArrayDataSizeException extends RuntimeException {
    public MyArrayDataSizeException(String message) { //создаем кончтруктор для вывода сообщения
        super(message);
    }
}
