import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
  ///////////////////// constructors //////////////////////////////////

  /**
   * Constructor that takes no arguments
   */
  public Picture() {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor
     */
    super();
  }

  /**
   * Constructor that takes a file name and creates the picture
   *
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName) {
    // let the parent class handle this fileName
    super(fileName);
  }

  /**
   * Constructor that takes the width and height
   *
   * @param height the height of the desired picture
   * @param width  the width of the desired picture
   */
  public Picture(int height, int width) {
    // let the parent class handle this width and height
    super(width, height);
  }

  /**
   * Constructor that takes a picture and creates a
   * copy of that picture
   *
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture) {
    // let the parent class do the copy
    super(copyPicture);
  }

  /**
   * Constructor that takes a buffered image
   *
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image) {
    super(image);
  }

  ////////////////////// methods ///////////////////////////////////////

  /**
   * Method to return a string with information about this picture.
   *
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString() {
    String output = "Picture, filename " + getFileName() +
            " height " + getHeight()
            + " width " + getWidth();
    return output;

  }

  /**
   * Method to set the blue to 0
   */
  public void zeroBlue() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        pixelObj.setBlue(0);
      }
    }
  }

  /**
   * keeps only the blue values
   */
  public void keepOnlyBlue() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        pixelObj.setGreen(0);
        pixelObj.setRed(0);
      }
    }

  }

  /**
   * inverts the colors of theh picture
   */
  public void negate() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        pixelObj.setGreen(255 - pixelObj.getGreen());
        pixelObj.setRed(255 - pixelObj.getRed());
        pixelObj.setBlue(255 - pixelObj.getBlue());
      }
    }

  }


  public void grayscale() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        int average = (pixelObj.getGreen() + pixelObj.getRed() + pixelObj.getBlue()) / 3;

        pixelObj.setGreen(average);
        pixelObj.setRed(average);
        pixelObj.setBlue(average);
      }
    }
  }


  //makes the fish more visible in in water.jpg
  public void fixUnderwater() {

    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        pixelObj.setBlue(pixelObj.getBlue() - 70);
        pixelObj.setRed(pixelObj.getRed() + 90);
        pixelObj.setGreen(pixelObj.getGreen() - 70);


      }

    }
  }


  /**
   * Method that mirrors the picture around a
   * vertical mirror in the center of the picture
   * from left to right
   */
  public void mirrorVertical() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < width / 2; col++) {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }

  /**
   * mirrors the right side onto the left side of the picture
   */
  public void mirrorVerticalRightToLeft() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++) {
      for (int col = width / 2; col < width; col++) {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }

  /**
   * mirrors the top onto the bottom
   */
  public void mirrorHorizontal() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel botPixel = null;
    int height = pixels.length;

    for (int row = 0; row < height / 2; row++) {
      for (int col = 0; col < getWidth(); col++) {
        topPixel = pixels[row][col];
        botPixel = pixels[height - 1 - row][col];
        botPixel.setColor(topPixel.getColor());
      }
    }
  }

  //mirror from bottom to top
  public void mirrorHorizontalBotToTop() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int height = pixels.length;

    for (int column = 0; column < pixels[0].length; column++) {

      for (int row = 0; row < height / 2; row++) {
        topPixel = pixels[row][column];
        bottomPixel = pixels[height - 1 - row][column];
        topPixel.setColor(bottomPixel.getColor());
      }
    }
  }

  //mirrors the diagonally
  public void mirrorDiagonal() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int length;

    if (pixels[0].length < pixels.length)
      length = pixels[0].length;
    else
      length = pixels.length;

    for (int column = 0; column < length; column++) {

      for (int row = 0; row < length; row++) {
        topPixel = pixels[row][column];
        bottomPixel = pixels[column][row];
        bottomPixel.setColor(topPixel.getColor());
      }
    }
  }


  /**
   * Mirror just part of a picture of a temple
   */
  public void mirrorTemple() {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();

    // loop through the rows
    for (int row = 27; row < 97; row++) {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++) {
        count++;

        leftPixel = pixels[row][col];
        rightPixel = pixels[row]
                [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }

    System.out.println("The nested loop in mirrorTemple executes " + count + " times.");

  }


  /**
   * Mirror just the bird
   */
  public void mirrorGull() {
    int mirrorPoint = 347;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();

    for (int row = 229; row < 334; row++) {

      for (int col = 228; col < mirrorPoint; col++) {
        count++;

        leftPixel = pixels[row][col];
        rightPixel = pixels[row]
                [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }

    System.out.println("The nested loop in mirrorGull executes " + count + " times.");

  }

  /**
   * Mirror just the arms of the snowman, to make 4 arms
   */
  public void mirrorArms() {
    int mirrorPoint = 190;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();


    for (int row = 104; row < mirrorPoint; row++) {

      for (int col = 157; col < 196; col++) {
        count++;

        leftPixel = pixels[col][row];
        rightPixel = pixels[mirrorPoint - col + mirrorPoint]
                [row];
        rightPixel.setColor(leftPixel.getColor());
      }
    }

    mirrorPoint = 200;
    leftPixel = null;
    rightPixel = null;

    for (int row = 235; row < 293; row++) {

      for (int col = 172; col < mirrorPoint; col++) {


        leftPixel = pixels[col][row];
        rightPixel = pixels[mirrorPoint - col + mirrorPoint]
                [row];
        rightPixel.setColor(leftPixel.getColor());
      }
    }

    System.out.println("The nested loop in mirrorArms executes " + count + " times.");

  }


  /**
   * copy from the passed fromPic to the
   * specified startRow and startCol in the
   * current picture
   *
   * @param fromPic  the picture to copy from
   * @param startRow the start row to copy to
   * @param startCol the start col to copy to
   */
  public void copy(Picture fromPic,
                   int startRow, int startCol) {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow;
         fromRow < fromPixels.length &&
                 toRow < toPixels.length;
         fromRow++, toRow++) {
      for (int fromCol = 0, toCol = startCol;
           fromCol < fromPixels[0].length &&
                   toCol < toPixels[0].length;
           fromCol++, toCol++) {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }
  }

  //Copy method, but you can just copy a part of the picture
  public void copy(Picture fromPic,
                   int fromStartRow, int fromStartCol, int fromEndRow, int fromEndCol, int toStartRow, int toStartCol) {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = fromStartRow, toRow = toStartRow;
         fromRow < fromEndRow &&
                 toRow < toPixels.length;
         fromRow++, toRow++) {
      for (int fromCol = fromStartCol, toCol = toStartCol;
           fromCol < fromEndCol &&
                   toCol < toPixels[0].length;
           fromCol++, toCol++) {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }
  }

  /**
   * Method to create a collage of several pictures
   */
  public void createCollage() {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1, 0, 0);
    this.copy(flower2, 100, 0);
    this.copy(flower1, 200, 0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue, 300, 0);
    this.copy(flower1, 400, 0);
    this.copy(flower2, 500, 0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }

  /**
   * Method to create a collage of several pictures
   */
  public void myCollage() {
    Picture collage = new Picture("640x480.jpg");

    Picture flower = new Picture("flower1.jpg");
    Picture swan = new Picture("swan.jpg");

    flower.keepOnlyBlue();
    this.copy(flower, 1, 1, 40, 54, 86, 32);

    flower.grayscale();
    this.copy(flower, 1, 1, 40, 54, 50, 32);

    flower.mirrorHorizontalBotToTop();
    this.copy(flower, 1, 1, 40, 54, 10, 32);


  }


  /**
   * Method to show large changes in color
   *
   * @param edgeDist the distance for finding edges
   */
  public void edgeDetection(int edgeDist) {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;


    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0;
           col < pixels[0].length - 1; col++) {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col + 1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) >
                edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }


  }

  /**
   * Method to replace the green background with
   * the pixels in the newBack picture
   *
   * @param newBack the picture to copy from
   */
  public void chromakey(Picture newBack) {
    Pixel fromPixel = null;
    Pixel toPixel = null;

    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = newBack.getPixels2D();

    int width = toPixels[0].length;

    for (int row = 0; row < toPixels.length; row++) {

      for (int col = 0 ; col < width; col++) {

        fromPixel = fromPixels[row][col];
        toPixel = toPixels[row][col];

        if(!((fromPixel.getGreen() > 90 && fromPixel.getGreen() < 223) && (fromPixel.getRed() > 10 && fromPixel.getRed() < 184) && (fromPixel.getGreen() > fromPixel.getRed()) ))
            toPixel.setColor(fromPixel.getColor());

      }
    }
  }

  /** Hide a black and white message in t
   he current
   * picture by changing the red to even and then
   * setting it to odd if the message pixel is black
   * @param messagePict the picture with a message
   */
  public void encode(Picture messagePict)
  {
    Pixel[][] messagePixels = messagePict.getPixels2D();
    Pixel[][] currPixels = this.getPixels2D();
    Pixel currPixel = null;
    Pixel messagePixel = null;

    //Makes all of the red values of the picture even
    for (Pixel[] rowArray : currPixels) {
      for (Pixel pixelObj : rowArray) {

        if(! (pixelObj.getRed() % 2 == 0))
        pixelObj.setRed(pixelObj.getRed() - 1);

      }

    }

    //Encodes the message

    int width = messagePixels[0].length;

    for (int row = 0; row < currPixels.length; row++) {

      for (int col = 0; col < width; col++) {

        messagePixel = messagePixels[row][col];
        currPixel = currPixels[row][col];

        if ((messagePixel.getRed() < 200) && (messagePixel.getGreen() < 200) && (messagePixel.getBlue() < 200))
          currPixel.setRed(currPixel.getRed() + 1);

      }
    }

  }

  /**
   * Method to decode a message hidden in the
   * red
   value of the current picture
   * @return the picture with the hidden message
   */
  public Picture decode()
  {
    Pixel[][] pixels = this.getPixels2D();
    int height = this.getHeight();
    int width = this.getWidth();
    Pixel currPixel = null;
    Pixel messagePixel = null;
    Picture messagePicture = new Picture(height,width);
    Pixel[][] messagePixels = messagePicture.getPixels2D();

    //If a pixel has an odd red value make it black

    for (int row = 0; row < pixels.length; row++) {

      for (int col = 0; col < pixels[0].length; col++) {



        messagePixel = messagePixels[row][col];
        currPixel = pixels[row][col];

        if (!(currPixel.getRed() % 2 == 0))
          messagePixel.setColor(Color.BLACK);


      }
    }

    return messagePicture;
  }




}

  /* Main method for testing - each class in Java can have a main 
   * method 
   */
    //public static void main (String[]args)
   // {
    //  Picture beach = new Picture("beach.jpg");
     // beach.explore();
      //beach.zeroBlue();
      //beach.explore();
    //}
  
 // this } is the end of class Picture, put all new methods before this