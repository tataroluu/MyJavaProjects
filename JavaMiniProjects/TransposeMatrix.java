package ExamplesBilgeAdam;

public class TransposeMatrix {
    public static void main(String[] args) {

        int[][] reverseMatrixNumbers = {
                 {1, 2, 3}
                ,{4, 5, 6}
                ,{7, 8, 9}
                ,{10,11,12}
                ,{13,13,13}
        };


        for (int i = 0; i <=reverseMatrixNumbers[0].length-1 ; i++) {
            for (int j = 0; j <=reverseMatrixNumbers.length-1 ; j++) {

                System.out.print(reverseMatrixNumbers[j][i]+ " ");

            }
            System.out.println();
        }

    }

}
