import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SudokuGUI {

    private JFrame frame;
    private JTextField[][] cells = new JTextField[9][9];
    private boolean[][] userInput = new boolean[9][9];

    public SudokuGUI() {
        frame = new JFrame("Sudoku Solver");
        frame.setSize(520, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        JPanel gridPanel = new JPanel(new GridLayout(9, 9, 2, 2));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        gridPanel.setBackground(Color.BLACK);

        Font font = new Font("Segoe UI", Font.BOLD, 20);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                JTextField tf = new JTextField();
                tf.setHorizontalAlignment(JTextField.CENTER);
                tf.setFont(font);
                tf.setBackground(Color.WHITE);

                final int r = i, c = j;

                tf.addKeyListener(new KeyAdapter() {
                    public void keyReleased(KeyEvent e) {
                        userInput[r][c] = true;
                        validateCell(r, c);
                    }
                });

                cells[i][j] = tf;
                gridPanel.add(tf);
            }
        }

        JPanel btnPanel = new JPanel();
        JButton solveBtn = new JButton("Solve");
        JButton clearBtn = new JButton("Clear");

        solveBtn.setPreferredSize(new Dimension(120, 40));
        clearBtn.setPreferredSize(new Dimension(120, 40));

        btnPanel.add(solveBtn);
        btnPanel.add(clearBtn);

        frame.add(gridPanel, BorderLayout.CENTER);
        frame.add(btnPanel, BorderLayout.SOUTH);

        solveBtn.addActionListener(e -> solve());
        clearBtn.addActionListener(e -> clear());

        frame.setVisible(true);
    }

    // 🔴 Validate input → RED box if invalid
    private void validateCell(int r, int c) {
        try {
            String text = cells[r][c].getText();

            if (text.isEmpty()) {
                cells[r][c].setBackground(Color.WHITE);
                return;
            }

            int val = Integer.parseInt(text);

            if (val < 1 || val > 9) {
                cells[r][c].setBackground(Color.PINK);
                return;
            }

            int[][] board = getBoard();

            if (!canPlace(board, r, c, val)) {
                cells[r][c].setBackground(Color.PINK); // RED
            } else {
                cells[r][c].setBackground(Color.WHITE);
            }

        } catch (Exception e) {
            cells[r][c].setBackground(Color.PINK);
        }
    }

    private int[][] getBoard() {
        int[][] board = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                try {
                    String t = cells[i][j].getText();
                    board[i][j] = t.isEmpty() ? 0 : Integer.parseInt(t);
                } catch (Exception e) {
                    board[i][j] = 0;
                }
            }
        }
        return board;
    }

    // 🟢 Solve → fill green boxes
    private void solve() {
        int[][] board = getBoard();

        if (solveSudoku(board, 0, 0)) {

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {

                    cells[i][j].setText(String.valueOf(board[i][j]));

                    if (!userInput[i][j]) {
                        cells[i][j].setBackground(new Color(144, 238, 144)); // light green
                    } else {
                        cells[i][j].setBackground(Color.WHITE);
                    }
                }
            }

        } else {
            JOptionPane.showMessageDialog(frame, "No solution exists");
        }
    }

    private void clear() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cells[i][j].setText("");
                cells[i][j].setBackground(Color.WHITE);
                userInput[i][j] = false;
            }
        }
    }

    // Sudoku logic
    private boolean solveSudoku(int[][] mat, int i, int j) {
        if (i == 9) return true;
        if (j == 9) return solveSudoku(mat, i + 1, 0);

        if (mat[i][j] != 0)
            return solveSudoku(mat, i, j + 1);

        for (int num = 1; num <= 9; num++) {
            if (canPlace(mat, i, j, num)) {
                mat[i][j] = num;

                if (solveSudoku(mat, i, j + 1))
                    return true;
            }
        }

        mat[i][j] = 0;
        return false;
    }

    private boolean canPlace(int[][] mat, int x, int y, int val) {

        for (int i = 0; i < 9; i++) {
            if ((mat[x][i] == val && i != y) || (mat[i][y] == val && i != x))
                return false;
        }

        int sx = (x / 3) * 3;
        int sy = (y / 3) * 3;

        for (int i = sx; i < sx + 3; i++) {
            for (int j = sy; j < sy + 3; j++) {
                if (mat[i][j] == val && (i != x || j != y))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        new SudokuGUI();
    }
}