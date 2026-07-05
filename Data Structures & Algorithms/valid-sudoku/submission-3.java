class Solution {
    public boolean isValidSudoku(char[][] board) {

        int[][] newBoard = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    newBoard[i][j] = 0;
                } else {
                    newBoard[i][j] = Integer.valueOf(board[i][j]);
                }
            }
        }

        HashMap<String, ArrayList<Integer>> nineSquares = new HashMap<String, ArrayList<Integer>>();

        for (int i = 0; i < 9; i++) {
            ArrayList<Integer> rowList = new ArrayList<Integer>();
            ArrayList<Integer> colList = new ArrayList<Integer>();
            for (int j = 0; j < 9; j++) {

                int row = i / 3;
                int col = j / 3;
                String squareKey = row + "," + col;

                if (nineSquares.get(squareKey) != null) {
                    if (nineSquares.get(squareKey).contains(newBoard[i][j])) {
                        return false;
                    }
                }

                if (rowList.contains(newBoard[i][j]) || colList.contains(newBoard[j][i])) {
                    return false;
                } 

                if (newBoard[i][j] != 0) {
                    rowList.add(newBoard[i][j]);
                    
                    ArrayList<Integer> newList = new ArrayList<Integer>();
                    if (nineSquares.get(squareKey) != null) {
                        newList = nineSquares.get(squareKey);
                    } 

                    newList.add(newBoard[i][j]);
                    nineSquares.put(squareKey, newList);
                }
                if (newBoard[j][i] != 0) {
                    colList.add(newBoard[j][i]);
                }

                
            }
        }

        return true;
    }
}
