package by.epam.tc.multiplication_matrix.main;

import by.epam.tc.multiplication_matrix.action.MatrixManager;
import by.epam.tc.multiplication_matrix.action.MultiplicationMatrixThread;

public class TestMultiplication {
	public static void main(String[] args) {
		// size of matrix
		int size = 10;
		int[][] matrixA = MatrixManager.create(size);
		int[][] matrixB = MatrixManager.create(size);

		MultiplicationMatrixThread.setSizeResultMatrix(size);

		AmountThread amountThreads = AmountThread.TWO_THREADS;
		

		int[][] resultMatrix = null;
		switch (amountThreads) {
		case N_THREADS:
			resultMatrix = MatrixManager.multiplicationNThread( matrixA, matrixB);
			break;

		case TWO_THREADS:
			resultMatrix = MatrixManager.multiplicationTwoThread(matrixA, matrixB);
			break;

		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(resultMatrix[i][j] + " ");
			}
			System.out.println();
		}

	}

}
