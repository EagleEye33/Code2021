package tetris;

import java.util.Random;

/*This class represents a generic tetris shape.  Custom classes are discussed in chapter 5.
*/
public class Shape {

//Enums are discussed briefly in chapter 3.
protected enum Tetrominoes {
   NoShape, ZShape, SShape, LineShape, TShape, SquareShape, LShape, MirroredLShape
};

/*
* Example of enum declaration
* These are discussed in chapter 3.
*/
private Tetrominoes pieceShape;

/*
* Examples of multi-dimensional arrays.
* These are discussed in chapter 7.
*/
private int coords[][];
private int[][][] coordsTable;

/*
* Public no-arg constructor.
* Constructors are gone over in more detail in chapter 5.
*/
public Shape() {

   coords = new int[4][2];
   setShape(Tetrominoes.NoShape);
}

public void setShape(Tetrominoes shape) {

   /*
    * Initialization of a multi-dimensional array.
    * This is discussed in chapter 7.
    */
   coordsTable = new int[][][]{
           {{0, 0}, {0, 0}, {0, 0}, {0, 0}},
           {{0, -1}, {0, 0}, {-1, 0}, {-1, 1}},
           {{0, -1}, {0, 0}, {1, 0}, {1, 1}},
           {{0, -1}, {0, 0}, {0, 1}, {0, 2}},
           {{-1, 0}, {0, 0}, {1, 0}, {0, 1}},
           {{0, 0}, {1, 0}, {0, 1}, {1, 1}},
           {{-1, -1}, {0, -1}, {0, 0}, {0, 1}},
           {{1, -1}, {0, -1}, {0, 0}, {0, 1}}};

   /*
    * Double nested for loop.  These are discussed in chapter 4.
    */
   for (int i = 0; i < 4; i++) {

       for (int j = 0; j < 2; ++j) {

           coords[i][j] = coordsTable[shape.ordinal()][i][j];
       }
   }

   pieceShape = shape;
}

/*
* Getters and setters - these are discussed in chapter 5.
*/
private void setX(int index, int x) {
   coords[index][0] = x;
}

private void setY(int index, int y) {
   coords[index][1] = y;
}

public int x(int index) {
   return coords[index][0];
}

public int y(int index) {
   return coords[index][1];
}

public Tetrominoes getShape() {
   return pieceShape;
}

/*
* This method uses both the Random object and Math object.  Both are discussed in chapter 3.
*/
public void setRandomShape() {

   Random r = new Random();
   int x = Math.abs(r.nextInt()) % 7 + 1;

   // Object arrays are discussed in chapter 7.
   Tetrominoes[] values = Tetrominoes.values();
   setShape(values[x]);
}

public int minX() {

   int m = coords[0][0];

   // for loops are discussed in chapter 4.
   for (int i = 0; i < 4; i++) {

       m = Math.min(m, coords[i][0]);
   }

   return m;
}

public int minY() {

   int m = coords[0][1];

   // for loops are discussed in chapter 4.
   for (int i = 0; i < 4; i++) {

       m = Math.min(m, coords[i][1]);
   }

   return m;
}

public Shape rotateLeft() {

   // if statements are discussed more in chapter 4.
   if (pieceShape == Tetrominoes.SquareShape)
       return this;

   Shape result = new Shape();
   result.pieceShape = pieceShape;

   // for loops are discussed in chapter 4.
   for (int i = 0; i < 4; ++i) {

       result.setX(i, y(i));
       result.setY(i, -x(i));
   }

   return result;
}

public Shape rotateRight() {

   // if statements are discussed more in chapter 4.
   if (pieceShape == Tetrominoes.SquareShape)
       return this;

   Shape result = new Shape();
   result.pieceShape = pieceShape;

   // for loops are discussed in chapter 4.
   for (int i = 0; i < 4; ++i) {

       result.setX(i, -y(i));
       result.setY(i, x(i));
   }

   return result;
}
}