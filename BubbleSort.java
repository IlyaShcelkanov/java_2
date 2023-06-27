import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2};
        int n = arr.length;
        boolean swapped;

        try {
            File logFile = new File("sort.log");
            FileWriter writer = new FileWriter(logFile);

            for (int i = 0; i < n - 1; i++) {
                swapped = false;
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        swapped = true;
                    }
                }

                writer.write("After iteration " + (i + 1) + ": ");
                for (int k = 0; k < n; k++) {
                    writer.write(arr[k] + " ");
                }
                writer.write("\n");

                if (!swapped) {
                    break;
                }
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}