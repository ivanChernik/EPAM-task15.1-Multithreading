package by.epam.tc.multiplication_matrix.action;

public class MultiplicationMatrixThread extends Thread {
	private static final String MULTIPLICATION_MATRIX_THREAD = "MultiplicationMatrixThread";
	private static int[][] resultMatrix;
	private int[] row;
	private int[] column;
	private int x;
	private int y;

	public MultiplicationMatrixThread(int[] row, int[] column, int x, int y, ThreadGroup group) {
		super(group, MULTIPLICATION_MATRIX_THREAD);
		this.row = row;
		this.column = column;
		this.x = x;
		this.y = y;
	}

	public static void setSizeResultMatrix(int orderMatrix) {
		resultMatrix = new int[orderMatrix][orderMatrix];
	}

	public static int[][] getResultMatrix() {
		return resultMatrix;
	}

	public void run() {
		int result = 0;
		for (int index = 0; index < row.length; index++) {
			int resultMultiplication = row[index] * column[index];
			result = result + resultMultiplication;
		}
		resultMatrix[x][y] = result;
	}

}
