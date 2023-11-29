import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("algorytm plecakowy ogólny");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe rodzajow pakowanyh rzeczy");
        int size = scanner.nextInt();
        System.out.println("Wpisz kolejno element tablicy wartosci potem tablicy wagi");
        int[] valueArray = new int[size];
        int[] weightArray = new int[size];
        for(int i=0;i<size;i++){
            System.out.println("wartosc");
            valueArray[i] = scanner.nextInt();
            System.out.println("waga");
            weightArray[i] = scanner.nextInt();
        }
        sortArrays(valueArray,weightArray);
        for(int i=0;i < size;i++){System.out.print(valueArray[i]+" ");}
        System.out.println();
        for(int i=0;i < size;i++){System.out.print(weightArray[i]+" ");}
        System.out.println();
        System.out.println("Podaj wage plecaka");
        int weight = scanner.nextInt();
        int[] numberOfUserProducts = new int[size];
        int value = packBackpack(valueArray,weightArray,weight,numberOfUserProducts);
        System.out.println("Wartosc plecaka to:");
        System.out.println(value);
        System.out.println("Ilość kolejnych elementow w plecaku");
        for(int i=0;i<size;i++){
            System.out.println(numberOfUserProducts[i]+" ");
        }
    }

    public static int packBackpack(int[] valueArray, int[] weightArray, int weight, int[] numberOfUserProducts) {
        int size = valueArray.length;
        int result = 0;
        for (int i = 0; i < size; i++) {
            numberOfUserProducts[i] = Math.min(weight / weightArray[i], 1);
            weight -= numberOfUserProducts[i] * weightArray[i];
            result += numberOfUserProducts[i] * valueArray[i];
        }
        return result;
    }
    public static void sortArrays(int[] valueArray, int[] weightArray) {
        int size = valueArray.length;

        for (int i = 1; i < size; i++) {
            int valueTemp = valueArray[i];
            int weightTemp = weightArray[i];
            int j = i - 1;

            double ratio1 = (double) valueArray[j] / weightArray[j];
            double ratio2 = (double) valueTemp / weightTemp;

            while (j >= 0 && ratio1 < ratio2) {
                valueArray[j + 1] = valueArray[j];
                weightArray[j + 1] = weightArray[j];
                j = j - 1;

                if (j >= 0) {
                    ratio1 = (double) valueArray[j] / weightArray[j];
                }
            }

            valueArray[j + 1] = valueTemp;
            weightArray[j + 1] = weightTemp;
        }
    }


}