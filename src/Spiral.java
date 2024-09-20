import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Formatter;

public class Spiral {

    private static int readDataFromFile(String file) {
        int size = 0;
        try(BufferedReader input = new BufferedReader(new FileReader(file))) {
            size = Integer.parseInt(input.readLine());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return size;
    }

    private static void writeResultToFile(Matrix resultMatrix, String fileName) {
        int max = resultMatrix.max(), numberOfDigits = 0;
        while (max > 0) {
            max /= 10;
            numberOfDigits++;
        }
        try(Formatter output = new Formatter(fileName)) {
            for (int i = 0; i < resultMatrix.numberOfLines; i++) {
                for (int j = 0; j < resultMatrix.numberOfColumns; j++) {
                    if (j == resultMatrix.numberOfColumns - 1)
                        output.format("%" + String.valueOf(numberOfDigits) + "d", resultMatrix.data[i][j]);
                    else
                        output.format("%" + String.valueOf(numberOfDigits) + "d ", resultMatrix.data[i][j]);
                }
                if (i != resultMatrix.numberOfLines - 1)
                    output.format(System.getProperty("line.separator"));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private static Matrix createSpiral(int n) {
        Matrix m = new Matrix(n, n);
        int numberOfLoops = 0, rest = n, number = 1;
        while (rest > 1) {
            rest -= 2;
            numberOfLoops++;
        }
        for (int k = 0; k < numberOfLoops; k++) {
            for (int j = k; j < n - k; j++) {
                m.data[k][j] = number;
                number++;
            }
            for (int i = k + 1; i < n - k; i++) {
                m.data[i][n - 1 - k] = number;
                number++;
            }
            for (int j = k + 1; j < n - k; j++) {
                m.data[n - 1 - k][n - 1 - j] = number;
                number++;
            }
            for (int i = k + 1; i < n - k - 1; i++) {
                m.data[n - 1 - i][k] = number;
                number++;
            }
        }
        if (rest == 1)
            m.data[n / 2][n / 2] = number;
        return m;
    }

    public static void main(String[] args) {
        int data = readDataFromFile("input.txt");
        //
        writeResultToFile(createSpiral(data), "output.txt");
    }
}