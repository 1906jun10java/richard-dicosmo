
public class Iterating2DArrays {

	public static void main(String[] args) {
		int[][] productTable = new int[11][11];
		
		for (int i = 0; i < productTable.length; i++) {
			for (int j = 0; j < productTable[i].length; j++) {
				productTable[i][j] = i * j;
			}
		}
		for (int i = 0; i < productTable.length; i++) {
			for (int j = 0; j < productTable[i].length; j++) {
				System.out.print(productTable[i][j] + " ");	
			}
			System.out.print("\n");
		}

	}

}
