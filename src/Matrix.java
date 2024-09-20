import java.io.IOException;
import java.util.Formatter;

public class Matrix {
    int[][] data;
    int numberOfLines, numberOfColumns;

    public int max() {
        int max = data[0][0];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (max < data[i][j]) {
                    max = data[i][j];
                }
            }
        }
        return max;
    }

    public static void printMatrixToFile(Matrix resultMatrix, String fileName) {
        if (resultMatrix == null)
            return;
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

    public static Matrix createSpiral(int n) {
        if (n < 1)
            return null;
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

    public Matrix(int numberOfLines, int numberOfColumns) {
        data = new int[numberOfLines][numberOfColumns];
        this.numberOfLines = numberOfLines;
        this.numberOfColumns = numberOfColumns;
    }
}
