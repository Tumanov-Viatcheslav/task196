import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    public static void main(String[] args) {
        int data = readDataFromFile("input.txt");
        Matrix.printMatrixToFile(Matrix.createSpiral(data), "output.txt");
    }
}