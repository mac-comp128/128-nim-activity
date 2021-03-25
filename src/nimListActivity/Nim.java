package nimListActivity;

import edu.macalester.graphics.*;
import edu.macalester.graphics.events.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by bjackson on 3/2/2016.
 */
public class Nim {

    public static final int NUM_COINS = 11;
    public static final double COIN_DIAMETER = 75;
    public static final double COINS_Y = 100;
    public static final double STARTING_X = 20;
    public static final double DISTANCEBETWEEN = 10;
    public static final String PLAYER1_TEXT = "Player 1's turn:";
    public static final String PLAYER2_TEXT = "Player 2's turn:";

    private CanvasWindow canvas;
    private GraphicsText label;
    private ArrayList<Ellipse> coins;
    private int selectedIndex; //the index into the coins array for the coin that was selected when the mouse is pressed.
    // It contains the value of -1 if a coin is not selected with the mouse press.


    /**
     * Initialize instance variables
     */
    public Nim(){
        canvas = new CanvasWindow("Nim", 1000, 375);
        selectedIndex = -1;
        label = new GraphicsText(PLAYER1_TEXT, (float)STARTING_X, 50.0f);
        label.setFont(FontStyle.PLAIN, 24);
        canvas.add(label);

        //TODO: initialize the coins ArrayList.


        createCoins();
        canvas.onMouseDown(this::mousePressed);
        canvas.onMouseUp(this::mouseReleased);
    }

    /**
     * Creates a row of Ellipse objects representing coins, placed DISTANCEBETWEEN apart. The circle's size should be determined
     * by the COIN_DIAMETER instance variable. The placement of the first circle's upper left corner is determined by the values
     * of the STARTING_X and COINS_Y instance variables. The circles should be added to the arraylist and the canvas.
     */
    private void createCoins(){
        for (int i = 0; i<NUM_COINS; i++) {
            Ellipse coin = new Ellipse(
                    (STARTING_X+i*(COIN_DIAMETER+DISTANCEBETWEEN)),
                    COINS_Y, COIN_DIAMETER, COIN_DIAMETER
            );
            coin.setFillColor(Color.CYAN);
            coin.setFilled(true);
            canvas.add(coin);
            //TODO: store the coin in the coins data structure


        }
    }

    /**
     * Changes the value of the label based on who's turn it currently is.
     */
    private void advanceTurn(){
        if (label.getText().equals(PLAYER1_TEXT)){
            label.setText(PLAYER2_TEXT);
        }
        else {
            label.setText(PLAYER1_TEXT);
        }
    }

    /**
     * Checks for two conditions:
     * (1) The current player removed all the coins in which case they lose.
     * (2) There is only one coin left meaning the current player has won.
     * @return true if one of the players wins (i.e. there are zero or one coins left)
     */
    private boolean checkForWin(){
        //current player removed last coin
        if (coins.size() == 0){
            label.setText("You Lose!");
            return true;
        }
        else if (coins.size() == 1){
            if (label.getText().equals(PLAYER1_TEXT)){
                label.setText("Player 1 wins!");
            }
            else {
                label.setText("Player 2 wins!");
            }
            return true;
        }
        return false;
    }

    /**
     * Sets the fill color of the coins in the coins array from index to the end of the list to color.
     * @param index starting index to set the color
     * @param color color to set
     */
    private void colorCoins(int index, Color color){
        //TODO: Set the fill color for the coins in the array from index to the end of the list


    }

    /**
     * Removed all the coins in the coins array from index to the end of the list and remove them from the canvas.
     * @param index starting index
     */
    private void removeCoins(int index){
        //TODO: remove the coins starting at index to the end of the list from the array and the canvas.
        // Hint: think carefully about which iteration method you should use.

    }

    /**
     * Responds to mouse press down events
     * @param event
     */
    public void mousePressed(MouseButtonEvent event){
        //TODO: If the mouse was clicked on a coin object, find the index of that coin in the coins arraylist (HINT: look
        // at the ArrayList javadoc).
        // If the index is within the last three coins in the arraylist, then set selectedIndex to be
        // the index you have found, and color the coins red.


    }

    /**
     * Responds to mouse button released events
     * @param event
     */
    public void mouseReleased(MouseButtonEvent event){
        //TODO: If an index was selected, remove the coins, set selectedIndex
        // back to -1, and check if anyone has won (HINT: look at the existing methods in the class).
        // If nobody has won so far then advance to the next player's turn.


    }

    public static void main(String[] args){
        Nim game = new Nim();
    }

}
