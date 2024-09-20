public class Matrix {
    int[][] data;
    int numberOfLines, numberOfColumns;

    public static Matrix sum(Matrix m1, Matrix m2) {
        Matrix res = new Matrix(m1.data.length, m1.data[0].length);
        for (int i = 0; i < m1.data.length; i++) {
            for (int j = 0; j < m2.data[i].length; j++) {
                res.data[i][j] = m1.data[i][j] + m2.data[i][j];
            }
        }
        return res;
    }

    public Matrix add(Matrix m) {
        Matrix res = new Matrix(data.length, data[0].length);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < m.data[i].length; j++) {
                res.data[i][j] = data[i][j] + m.data[i][j];
            }
        }
        return res;
    }

    public static Matrix subtraction(Matrix m1, Matrix m2) {
        Matrix res = new Matrix(m1.data.length, m1.data[0].length);
        for (int i = 0; i < m1.data.length; i++) {
            for (int j = 0; j < m2.data[i].length; j++) {
                res.data[i][j] = m1.data[i][j] - m2.data[i][j];
            }
        }
        return res;
    }

    public Matrix subtract(Matrix m) {
        Matrix res = new Matrix(data.length, data[0].length);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < m.data[i].length; j++) {
                res.data[i][j] = data[i][j] - m.data[i][j];
            }
        }
        return res;
    }
    
    public int sumAllMatrix() {
        int res = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                res += data[i][j];
            }
        }
        return res;
    }

    public static int sumAllMatrix(Matrix m) {
        int res = 0;
        for (int i = 0; i < m.data.length; i++) {
            for (int j = 0; j < m.data[i].length; j++) {
                res += m.data[i][j];
            }
        }
        return res;
    }

    public boolean contains(int k) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] == k)
                    return true;
            }
        }
        return false;
    }
    
    public Matrix translate() {
        Matrix res = new Matrix(data[0].length, data.length);
        for (int i = 0; i < res.data.length; i++) {
            for (int j = 0; j < res.data[i].length; j++) {
                res.data[i][j] = data[j][i];
            }
        }
        return res;
    }

    public static Matrix translate(Matrix m) {
        Matrix res = new Matrix(m.data[0].length, m.data.length);
        for (int i = 0; i < res.data.length; i++) {
            for (int j = 0; j < res.data[i].length; j++) {
                res.data[i][j] = m.data[j][i];
            }
        }
        return res;
    }
    
    public void matrixBubbleSort() {
        int tmp;
        for (int i1 = 0; i1 < data.length; i1++) {
            for (int j1 = 0; j1 < data[0].length; j1++) {
                for (int i2 = 0; i2 < data.length; i2++) {
                    for (int j2 = 0; j2 < data[0].length; j2++) {
                        if (!((i2 == data.length - 1) && (j2 == (data[0].length - 1)))
                                && (data[i2][j2] > data[i2 + (j2 + 1) / data[0].length][(j2 + 1) % data[0].length])) {
                            tmp = data[i2][j2];
                            data[i2][j2] = data[i2 + (j2 + 1) / data[0].length][(j2 + 1) % data[0].length];
                            data[i2 + (j2 + 1) / data[0].length][(j2 + 1) % data[0].length] = tmp;
                        }
                    }
                }
            }
        }
    }

    public static void matrixBubbleSort(Matrix m) {
        int tmp;
        for (int i1 = 0; i1 < m.data.length; i1++) {
            for (int j1 = 0; j1 < m.data[0].length; j1++) {
                for (int i2 = 0; i2 < m.data.length; i2++) {
                    for (int j2 = 0; j2 < m.data[0].length; j2++) {
                        if (!((i2 == m.data.length - 1) && (j2 == (m.data[0].length - 1)))
                                && (m.data[i2][j2] > m.data[i2 + (j2 + 1) / m.data[0].length][(j2 + 1) % m.data[0].length])) {
                            tmp = m.data[i2][j2];
                            m.data[i2][j2] = m.data[i2 + (j2 + 1) / m.data[0].length][(j2 + 1) % m.data[0].length];
                            m.data[i2 + (j2 + 1) / m.data[0].length][(j2 + 1) % m.data[0].length] = tmp;
                        }
                    }
                }
            }
        }
    }

    public int maxLineIndex() {
        int maxLineIndexRes = 0, max = data[0][0];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (max < data[i][j]) {
                    max = data[i][j];
                    maxLineIndexRes = i;
                }
            }
        }
        return maxLineIndexRes;
    }

    public static int maxLineIndex(Matrix m) {
        int maxLineIndexRes = 0, max = m.data[0][0];
        for (int i = 0; i < m.data.length; i++) {
            for (int j = 0; j < m.data[i].length; j++) {
                if (max < m.data[i][j]) {
                    max = m.data[i][j];
                    maxLineIndexRes = i;
                }
            }
        }
        return maxLineIndexRes;
    }

    public int max() {
        int maxLineIndexRes = 0, max = data[0][0];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (max < data[i][j]) {
                    max = data[i][j];
                    maxLineIndexRes = i;
                }
            }
        }
        return max;
    }

    public Matrix(int numberOfLines, int numberOfColumns) {
        data = new int[numberOfLines][numberOfColumns];
        this.numberOfLines = numberOfLines;
        this.numberOfColumns = numberOfColumns;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = (int)(Math.random() * 100);
            }
        }
    }

    public Matrix(int[][] matrix) {
        data = new int[matrix.length][matrix[0].length];
        numberOfLines = matrix.length;
        numberOfColumns = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, data[i], 0, matrix[i].length);
        }
    }
}
