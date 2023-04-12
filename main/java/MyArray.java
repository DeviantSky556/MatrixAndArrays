import java.util.Arrays;
import java.util.Scanner;

public class MyArray {
    private double[] array;

    public MyArray() {
        this.array = initArray();
    }
    static Scanner scanner = new Scanner(System.in);

    public double[] initArray(){
        System.out.println("Введите размер массива");
        int sizeArray = scanner.nextInt();
        double[] array = new double[sizeArray];
        for (int i = 0; i < sizeArray; i++) {
            array[i] = random(-10,10);
        }
        return array;
    }

    public double random(int min, int max){
        return Math.random()*((max - min) + min);}

    @Override
    public String toString() {
        return "MyArray{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public double[] getArray() {
        return array;
    }

    public void setArray(double[] array) {
        this.array = array;
    }

    public static MyArray sortArrayAscend(MyArray myArray) {
        double[] array = myArray.getArray();
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    double buf = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = buf;
                    isSorted = false;
                }
            }
        }
        myArray.setArray(array);
        return myArray;
    }

    public static MyArray sortArrayDescend(MyArray myArray){
        double[] array = myArray.getArray();
        boolean isSorted = false;
        while (!isSorted){
            isSorted = true;
            for (int i = array.length - 1; i > 0; i--) {
                if (array[i] > array[i - 1]){
                    double buf = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = buf;
                    isSorted = false;
                }
            }
        }
        return myArray;
    }

    public static void counterNumberInArray(MyArray myArray){
        int counter = 0;
        int index = 0;
        double number = input("Введите искомое число: ");
        double[] array = sortArrayAscend(myArray).getArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number){
                counter += 1;
                index = i;
            }
            System.out.println("Количество вхождений элемента " + number  + " : " + " в нашем массиве: " + counter);
            System.out.println("Индекс последнего вхождения: "+ index);
        }
    }

    static public double input(String text){
        System.out.println(text);
        return scanner.nextDouble();
    }

    public static void searchMaxElementAndIndex(MyArray myArray){
        double[] array =  sortArrayAscend(myArray).getArray();
        System.out.println("Максимальный элемент: " + array[array.length-1]
                + " Его индекс: " + ((array.length)-1));
    }
}
