package ExamplesBilgeAdam;

public class ReverseMatrix {

    public static void main(String[] args) {

        int[][] reverseMatrixNumbers = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        for (int i = reverseMatrixNumbers.length-1; i >=0 ; i--) {
            for (int j = reverseMatrixNumbers.length-1; j >=0 ; j--) {

                System.out.print(reverseMatrixNumbers[i][j]+ " ");

           }
            System.out.println();
        }


    }

}
