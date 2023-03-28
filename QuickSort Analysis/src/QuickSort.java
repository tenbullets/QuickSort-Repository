public class QuickSort {
    static int k = 0; // кол-во итераций
    public static int quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return k;//завершить выполнение, если длина массива равна 0

        if (low >= high)
            return k;//завершить выполнение если уже нечего делить

        // выбрать основной элемент
        int middle = low + (high - low) / 2;
        int found = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            k++;
            while (array[i] < found) {
                i++;
            }

            while (array[j] > found) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой частей
        if (low < j)
            quickSort(array, low, j);


        if (high > i)
            quickSort(array, i, high);

        return k;
    }
}



