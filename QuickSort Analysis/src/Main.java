import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File out = new File("random.txt");
        FileWriter wrt = null;
        int n = 100; // кол-во элементов
        int m = n;

        try {
            wrt = new FileWriter(out);
            BufferedWriter writer = new BufferedWriter(wrt);
            int line;
            Random random = new Random();
            while (n > 0) {
                line = random.nextInt(1000);
                writer.write(line + "\n");
                n--;
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
        // Считываем и записываем числа в массив
        Scanner scanner = new Scanner(new File("random.txt"));
        int [] arr = new int [m];// массив размера кол-ва всех элементов
        int i = 0;
        while(scanner.hasNextInt()){
            arr[i++] = scanner.nextInt();
        }
        // Определяем границы для сортировки
        int min = 0;
        int max = arr.length - 1;

        long startTime = System.nanoTime();
        System.out.println("Кол-во итераций: " + QuickSort.quickSort(arr, min, max));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000000;
        System.out.println("Время затраченное на сортировку: " + duration + " ms");
    }
}