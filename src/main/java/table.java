import java.util.Scanner;

public class table {

    public static int getCountsOfDigits(int number) {   //Метод вычисления количества цифр в числе
        int count = 0;
        if (number == 0) {
            return count = 1;
        }
        while (number != 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    static void printString(int maxCellSize, int index, int size, StringBuilder table) {    //Метод печати разделителя строк

        if (index == 0) {
            for (int k = 1; k <= getCountsOfDigits(size); k++) {
                table.append("-");
            }
        } else {
            for (int k = 1; k <= maxCellSize; k++) {
                table.append("-");
            }
        }
        if (index < size) {
            table.append("+");
        }
    }

    static void printSpaces(int maxCellSize, int size, int item, int index, StringBuilder table) {  //Метод печати пробелом перед числом в ячейке

        int countsOfSpaces;

        if (index == 0) {
            countsOfSpaces = getCountsOfDigits(size) - getCountsOfDigits(item);
            ;
            for (int i = 0; i < countsOfSpaces; i++) {
                table.append(" ");
            }
        } else {
            countsOfSpaces = maxCellSize - getCountsOfDigits(item);
            for (int i = 0; i < countsOfSpaces; i++) {
                table.append(" ");
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Введите размер таблицы: ");
        int size;

        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        int maxCellSize = getCountsOfDigits(size * size);
        int item;

        int capacity = ((maxCellSize + 1) * size + getCountsOfDigits(size)) * (size + 1) * 2 + (size + 1) * 2; //емкость stringbuilder

        StringBuilder table = new StringBuilder(capacity);

        for (int i = 0; i <= size; i++) {

            for (int j = 0; j <= size; j++) {

                if (j == 0) {

                    item = i;

                    printSpaces(maxCellSize, size, item, j, table);

                    if (item == 0) {
                        table.append(" ");
                    } else {
                        table.append(item);
                    }

                } else {

                    if (i == 0) {
                        item = j;
                    } else {
                        item = i * j;
                    }

                    table.append("|");
                    printSpaces(maxCellSize, size, item, j, table);
                    table.append(item);
                }

            }

            table.append("\n");

            for (int k = 0; k <= size; k++) {

                printString(maxCellSize, k, size, table);
            }

            table.append("\n");

        }
        System.out.print(table);
        System.out.println(capacity);
        System.out.println(table.length());

    }


}
