package by.epam.tc.multiplication_matrix.action;

import java.util.Random;

public class MatrixManager {
	private static final String MATRIX_GROUP = "matrix group";
	private static Random random = new Random();

	public static int[][] create(int size) {
		int[][] matrix = new int[size][size];

		for (int x = 0; x < size; x++)
			for (int y = 0; y < size; y++) {
				matrix[x][y] = 2;// random.nextInt(11);
			}

		return matrix;
	}

	public static int[][] multiplicationNThread(int[][] matrixA, int[][] matrixB) {
		int size = matrixA.length;
		MultiplicationMatrixThread thread = null;
		ThreadGroup group = new ThreadGroup(MATRIX_GROUP);

		for (int row = 0; row < size; row++)
			for (int column = 0; column < size; column++) {
				thread = new MultiplicationMatrixThread(matrixA[row],
						turnColumnToRow(matrixB, column), row, column, group);
				thread.start();

			}

		while (group.activeCount() != 0) {
			System.out.println("Some threads are running");
		}

		return MultiplicationMatrixThread.getResultMatrix();
	}

	public static int[][] multiplicationTwoThread(int[][] matrixA,
			int[][] matrixB) {
		int size = matrixA.length;
		MultiplicationMatrixThread thread = null;
		ThreadGroup groupTwoTreads = new ThreadGroup(MATRIX_GROUP);

		for (int row = 0; row < size; row++)
			for (int column = 0; column < size; column++) {
				if (column % 2 == 0) {
					//checking first column = 0
					if (column != 0)
						while (groupTwoTreads.activeCount() != 0) {
						}
				}

				thread = new MultiplicationMatrixThread(matrixA[row],
						turnColumnToRow(matrixB, column), row, column,
						groupTwoTreads);
				thread.start();

			}

		while (groupTwoTreads.activeCount() != 0) {
			System.out.println("Some threads are running");
		}

		return MultiplicationMatrixThread.getResultMatrix();
	}

	private static int[] turnColumnToRow(int[][] matrix, int column) {
		int[] row = new int[matrix.length];
		for (int index = 0; index < matrix.length; index++) {
			row[index] = matrix[index][column];
		}
		return row;
	}

}
