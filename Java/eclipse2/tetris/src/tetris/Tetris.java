package tetris;

/*
 *  We will be going over the java.awt and javax.swing APIs in chapter 6. Java keywords, package statements and
 *  imports are discussed in chapter 1 and are used throughout the course.
 */

import javax.swing.*;
import java.awt.*;

/*
 * Tetris game from zetcode.com
 * http://zetcode.com/gfx/java2d/tetris/
 */

/*
 * This is the driver class for this Tetris game.
 *
 * You'll be using driver classes throughout this course.
 * This class extends JFrame.  Inheritance is discussed in chapter 8, while JFrame objects are introduced in chapter 6.
 */
public class Tetris extends JFrame {

    /*
     * Static and instance variables - introduced in chapter 2, discussed further in chapter 5.
     */
    private static final long serialVersionUID = 1L;
    private JLabel statusbar;

    /*
     * Public no-arg constructor.
     *
     * These will be discussed in chapter 5
     */
    public Tetris() {

        initUI();
    }

    /*
     * Initialize UI
     */
    private void initUI() {

        statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);

        // Instantiating a new object type of Board.  This is discussed in chapter 3 & 5.
        Board board = new Board(this);
        add(board);
        board.start();

        // UI APIs are discussed in chapter 6.
        setSize(200, 400);
        setTitle("Tetris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /*
     * Returns status bar.
     */
    public JLabel getStatusBar() {

        return statusbar;
    }

    /*
     * This classes's main method or entry point.  All Java programs have at least one of these methods, and the
     * method header (signature) is always the same as shown below.
     */
    public static void main(String[] args) {

        /*
         * Thread example.  This is not covered in this course, but may be used in the semester project.
         */
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                Tetris game = new Tetris();
                game.setVisible(true);
            }
        });
    }
}

