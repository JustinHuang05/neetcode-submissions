class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rowSet = new HashSet<>();
        Set<Character> colSet = new HashSet<>();
        Map<String, List<Character>> subBoxMap = new HashMap<>();
        int curRow = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (curRow != i) {
                    rowSet = new HashSet<>();
                    colSet = new HashSet<>();
                    curRow = i;
                } 
                if (board[i][j] != '.') {
                    if (rowSet.contains(board[i][j])) {
                        return false;
                    } else {
                        rowSet.add(board[i][j]);
                    }
                }
                if (board[j][i] != '.') {
                    if (colSet.contains(board[j][i])) {
                        return false;
                    } else {
                        colSet.add(board[j][i]);
                    }
                }
                int boxX = i/3;
                int boxY = j/3;
                String key = "" + boxX + boxY;
                if (subBoxMap.containsKey(key)) {
                    if (board[i][j] != '.') {
                        if (subBoxMap.get(key).contains(board[i][j])) {
                            return false;
                        } else {
                            List<Character> curList = subBoxMap.get(key);
                            curList.add(board[i][j]);
                            subBoxMap.put(key, curList);
                        }
                    } 
                } else {
                    List<Character> list = new ArrayList<>();
                    list.add(board[i][j]);
                    subBoxMap.put(key, list);
                }
            }
        }

        return true;
    }
}
