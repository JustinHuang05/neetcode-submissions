class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> rowSet = new HashSet();
            Set<Character> colSet = new HashSet();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && rowSet.contains(board[i][j])) {
                    System.out.print("1");
                    return false;
                }
                if (board[j][i] != '.' && colSet.contains(board[j][i])) {
                    System.out.print("2");
                    return false;
                }
                rowSet.add(board[i][j]);
                colSet.add(board[j][i]);
            }
        }

        Map<String, Set> map = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                String key = "" + (i / 3) + (j / 3);
                map.putIfAbsent(key, new HashSet<>());
                if (board[i][j] != '.' && map.get(key).contains(board[i][j])) {
                    System.out.print("3");
                    return false;
                } else {
                    map.get(key).add(board[i][j]);
                }
            }
        }

        return true;
    }
}
