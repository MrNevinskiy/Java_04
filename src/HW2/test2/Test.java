package HW2.test2;

public class Test {

    private static int ARRAY_SIZE = 4; // Нужный нам размер массива

    private static final String[][] CORRECT = {
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"}
    };
    private static final String[][] INCORRECT_SIZE = {
            {"2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"}
    };

    private static final String[][] INCORRECT_SIZE_2 =
            new String[3][3]; // дополнительный массив для проверки

    private static final String[][] INCORRECT_DATA = {
            {"O", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"}
    };

    public static void main(String[] args) {
        // Выбираем нужный нам массив для проверки.
        testSum(INCORRECT_DATA);
        //testSum(INCORRECT_SIZE);
        //testSum(INCORRECT_SIZE_2);
        //testSum(CORRECT);
    }


    public static void testSum(String[][] array) {
        if (array.length != ARRAY_SIZE) { // Проверяем размер массива
            throw new MyArrayDataSizeException("Массив не равняется 4Х4"); // Объявляем ошибку
        } else {
            for (String[] arr : array) { // Проверяем двумерный массива, на размер каждого массива (Запутался как правильно сформулировать)
                if (arr.length != ARRAY_SIZE) { // На данном этапе мы проверяем что каждый входящий массив в двумерный массив имеет 4 элемента
                    throw new MyArrayDataSizeException("Массив не равняется 4Х4"); // Объявляем ошибку
                }
            }
        }
        int sum = 0; //Сумма массива
        for (int i = 0; i < array.length; i++) { // Горизонтально
            for (int j = 0; j < array[i].length; j++) { // Вертикально
                try { // Начинаем поиск возможной ошибки
                    sum = sum + Integer.parseInt(array[i][j]); // складываем все объекты массива
                } catch (NumberFormatException exception) { // ловим ошибку
                    throw new MyArrayDataException(i, j); // выводим номер неправильный объект массива
                }
            }
        }
        System.out.println("Сумма = " + sum); //Выводим сумму
    }
}