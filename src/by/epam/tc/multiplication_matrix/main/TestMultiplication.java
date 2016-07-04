package by.epam.tc.multiplication_matrix.main;

import java.util.Scanner;

import by.epam.tc.multiplication_matrix.action.MatrixManager;
import by.epam.tc.multiplication_matrix.action.MultiplicationMatrixThread;

public class TestMultiplication {
	public static void main(String[] args) {
		// size of matrix
		int size = 10;
		int[][] matrixA = MatrixManager.create(size);
		int[][] matrixB = MatrixManager.create(size);

		MultiplicationMatrixThread.setSizeResultMatrix(size);

		System.out.println("Enter TWO_THREADS or  N_THREADS:");
		Scanner scanner = new Scanner(System.in);
		
		AmountThread amountThreads = AmountThread.valueOf(scanner.nextLine());
		

		int[][] resultMatrix = null;
		switch (amountThreads) {
		case N_THREADS:
			resultMatrix = MatrixManager.multiplicationNThread( matrixA, matrixB);
			break;

		case TWO_THREADS:
			resultMatrix = MatrixManager.multiplicationTwoThread(matrixA, matrixB);
			break;

		}

		if(resultMatrix == null) return;
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(resultMatrix[i][j] + " ");
			}
			System.out.println();
		}

	}

}
