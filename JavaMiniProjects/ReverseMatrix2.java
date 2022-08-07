package ExamplesBilgeAdam;

public class ReverseMatrix2 {

    public static void main(String[] args) {

        int[][] reverseMatrixNumbers = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}

        };


       for (int i = 0; i <=reverseMatrixNumbers.length-1 ; i++) {
            for (int j = reverseMatrixNumbers[i].length-1; j >=0 ; j--) {

                System.out.print(reverseMatrixNumbers[j][i]+ " ");

            }
            System.out.println();
        }

    }


}
