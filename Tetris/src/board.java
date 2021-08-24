package tetris;

import tetris.Shape.Tetrominoes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*
 * This class represents the game board.  It extends (chapter 8) JPanel (chapter 6) and implements a listener, which
 * is discussed in chapter 6.
 */
public class Board extends JPanel implements ActionListener {

    // primitive types are discussed in chapter 2.
    private static final long serialVersionUID = 1L;
    private final int BoardWidth = 10;
    private final int BoardHeight = 22;

    // Custom objects (classes) are discussed in chapter 5.
    private Timer timer;
    private boolean isFallingFinished = false;
    private boolean isStarted = false;
    private boolean isPaused = false;
    private int numLinesRemoved = 0;
    private int curX = 0;
    private int curY = 0;
    private JLabel statusbar;
    private Shape curPiece;
    private Tetrominoes[] board;

    /*
     * no-arg constructor.  These are discussed in chapter 5.
     */
    public Board(Tetris parent) {

        initBoard(parent);
    }

    private void initBoard(Tetris parent) {

        /*
         * UI components and their methods are discussed in chapter 6.
         */
        setFocusable(true);
        curPiece = new Shape();
        timer = new Timer(400, this);
        timer.start();

        statusbar = parent.getStatusBar();
        board = new Tetrominoes[BoardWidth * BoardHeight];
        addKeyListener(new TAdapter());
        clearBoard();
    }

    /*
     * Annotations (@Override) will be mentioned briefly in chapter 8, although they aren't required to be used and
     * are not on the test.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (isFallingFinished) {

            isFallingFinished = false;
            newPiece();
        } else {

            oneLineDown();
        }
    }

    /*
     * Method calls will be discussed in chapter 3 and beyond.
     */
    private int squareWidth() {
        return (int) getSize().getWidth() / BoardWidth;
    }

    /*
     * Various algorithms will be used throughout this class in nearly all chapters.
     */
    private int squareHeight() {
        return (int) getSize().getHeight() / BoardHeight;
    }

    private Tetrominoes shapeAt(int x, int y) {
        return board[(y * BoardWidth) + x];
    }

    /*
     * This start method is used in a Java Thread.  Threads are an advanced Java topic and won't be discussed in this
      * class.  You may, however, use them in your semester project if you can figure them out.
     */
    public void start() {

        if (isPaused)
            return;

        isStarted = true;
        isFallingFinished = false;
        numLinesRemoved = 0;
        clearBoard();

        newPiece();
        timer.start();
    }

    private void pause() {

        if (!isStarted)
            return;

        isPaused = !isPaused;

        if (isPaused) {

            timer.stop();
            statusbar.setText("paused");
        } else {

            timer.start();
            statusbar.setText(String.valueOf(numLinesRemoved));
        }

        // This is a UI method call.  These are discussed in chapter 6.
        repaint();
    }

    /*
     * Graphics and UI objects are discussed in chapter 6.
     */
    private void doDrawing(Graphics g) {

        Dimension size = getSize();
        int boardTop = (int) size.getHeight() - BoardHeight * squareHeight();

        for (int i = 0; i < BoardHeight; ++i) {

            for (int j = 0; j < BoardWidth; ++j) {

                Tetrominoes shape = shapeAt(j, BoardHeight - i - 1);

                if (shape != Tetrominoes.NoShape)
                    drawSquare(g, 0 + j * squareWidth(), boardTop + i
                            * squareHeight(), shape);
            }
        }

        if (curPiece.getShape() != Tetrominoes.NoShape) {

            for (int i = 0; i < 4; ++i) {

                int x = curX + curPiece.x(i);
                int y = curY - curPiece.y(i);
                drawSquare(g, 0 + x * squareWidth(), boardTop
                                + (BoardHeight - y - 1) * squareHeight(),
                        curPiece.getShape());
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    private void dropDown() {

        int newY = curY;

        while (newY > 0) {

            if (!tryMove(curPiece, curX, newY - 1))
                break;
            --newY;
        }

        pieceDropped();
    }

    private void oneLineDown() {

        if (!tryMove(curPiece, curX, curY - 1))
            pieceDropped();
    }

    private void clearBoard() {

        for (int i = 0; i < BoardHeight * BoardWidth; ++i)
            board[i] = Tetrominoes.NoShape;
    }

    private void pieceDropped() {

        for (int i = 0; i < 4; ++i) {

            int x = curX + curPiece.x(i);
            int y = curY - curPiece.y(i);
            board[(y * BoardWidth) + x] = curPiece.getShape();
        }

        removeFullLines();

        if (!isFallingFinished)
            newPiece();
    }

    private void newPiece() {

        curPiece.setRandomShape();
        curX = BoardWidth / 2 + 1;
        curY = BoardHeight - 1 + curPiece.minY();

        if (!tryMove(curPiece, curX, curY)) {

            curPiece.setShape(Tetrominoes.NoShape);
            timer.stop();
            isStarted = false;
            statusbar.setText("game over");
        }
    }

    private boolean tryMove(Shape newPiece, int newX, int newY) {

        for (int i = 0; i < 4; ++i) {

            int x = newX + newPiece.x(i);
            int y = newY - newPiece.y(i);

            if (x < 0 || x >= BoardWidth || y < 0 || y >= BoardHeight)
                return false;

            if (shapeAt(x, y) != Tetrominoes.NoShape)
                return false;
        }

        curPiece = newPiece;
        curX = newX;
        curY = newY;

        repaint();

        return true;
    }

    private void removeFullLines() {

        int numFullLines = 0;

        for (int i = BoardHeight - 1; i >= 0; --i) {
            boolean lineIsFull = true;

            for (int j = 0; j < BoardWidth; ++j) {
                if (shapeAt(j, i) == Tetrominoes.NoShape) {
                    lineIsFull = false;
                    break;
                }
            }

            if (lineIsFull) {
                ++numFullLines;
                for (int k = i; k < BoardHeight - 1; ++k) {
                    for (int j = 0; j < BoardWidth; ++j)
                        board[(k * BoardWidth) + j] = shapeAt(j, k + 1);
                }
            }
        }

        if (numFullLines > 0) {

            numLinesRemoved += numFullLines;
            statusbar.setText(String.valueOf(numLinesRemoved));
            isFallingFinished = true;
            curPiece.setShape(Tetrominoes.NoShape);
            repaint();
        }
    }

    private void drawSquare(Graphics g, int x, int y, Tetrominoes shape) {

        Color colors[] = {new Color(0, 0, 0), new Color(204, 102, 102),
                new Color(102, 204, 102), new Color(102, 102, 204),
                new Color(204, 204, 102), new Color(204, 102, 204),
                new Color(102, 204, 204), new Color(218, 170, 0)};

        Color color = colors[shape.ordinal()];

        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);

        g.setColor(color.brighter());
        g.drawLine(x, y + squareHeight() - 1, x, y);
        g.drawLine(x, y, x + squareWidth() - 1, y);

        g.setColor(color.darker());
        g.drawLine(x + 1, y + squareHeight() - 1, x + squareWidth() - 1, y
                + squareHeight() - 1);
        g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1, x
                + squareWidth() - 1, y + 1);

    }

    /*
     * This is an inner class.  These are first introduced in chapter 5 and will be expanded on in chapter 6 a little
     * more. The extends keyword is part of inheritance, which will be discussed in chapter 8.
     */
    class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            if (!isStarted || curPiece.getShape() == Tetrominoes.NoShape) {
                return;
            }

            int keycode = e.getKeyCode();

            if (keycode == 'p' || keycode == 'P') {
                pause();
                return;
            }

            if (isPaused)
                return;

            // switch statements are discussed in chapter 4.
            switch (keycode) {

                case KeyEvent.VK_LEFT:
                    tryMove(curPiece, curX - 1, curY);
                    break;

                case KeyEvent.VK_RIGHT:
                    tryMove(curPiece, curX + 1, curY);
                    break;

                case KeyEvent.VK_DOWN:
                    tryMove(curPiece.rotateRight(), curX, curY);
                    break;

                case KeyEvent.VK_UP:
                    tryMove(curPiece.rotateLeft(), curX, curY);
                    break;

                case KeyEvent.VK_SPACE:
                    dropDown();
                    break;

                case 'd':
                    oneLineDown();
                    break;

                case 'D':
                    oneLineDown();
                    break;
            }
        }
    }
}
