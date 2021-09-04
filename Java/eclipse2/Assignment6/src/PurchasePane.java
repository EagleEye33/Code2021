// Assignment #: Arizona State University CSE205 #6
//         Name: Wyatt Colyn
//    StudentID: 121-547-4364
//      Lecture: TTh 4:30pm
//  Description: PurchasePane displays a list of available laptops
//  from which a user can select to buy. It also shows how many
//  laptops are selected and what is the total amount.


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.event.ActionEvent;	//**Need to import to handle event
import javafx.event.EventHandler;	//**Need to import to handle event
import javafx.geometry.Insets;

import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

import org.w3c.dom.events.EventException;

//import all other necessary javafx classes
//----

public class PurchasePane extends VBox
{
   //GUI components
   private ArrayList<Laptop> laptopList, selectedList;

   //laptopLV for top ListView; selectedLV for bottom ListView
   private ListView<Laptop> laptopLV, selectedLV;
   private Label label, l2, l3, l4;
   private Button btn1, btn2;
   private GridPane gp, gp2, gp3;
   int qty = 0;
   double amt = 0;
   //declare all other necessary GUI variables here
   //----

 //constructor
   public PurchasePane(ArrayList<Laptop> list)
   {
   	  //initialize instance variables
      this.laptopList = list;
      selectedList = new ArrayList<Laptop>();

      //set up the layout
      //----
      label = new Label("Available Laptops");
      l2 = new Label("Selected Laptops");
      l3 = new Label("Qty selected: ??");
      l4 = new Label("Total Amt: ??");
      btn1 = new Button("Pick a laptop");
      btn2 = new Button("Remove a laptop");
      laptopLV = new ListView<Laptop>();
      selectedLV = new ListView<Laptop>();

   	 //PurchasePane is a VBox - add the components here
   	 //----
      gp = new GridPane();
      gp2 = new GridPane();
      gp3 = new GridPane();
      gp.setHgap(10);
      gp.setVgap(1);
      gp.setPadding(new Insets(10, 10, 10, 10));
      gp2.setHgap(10);
      gp2.setVgap(1);
      gp2.setPadding(new Insets(10, 10, 10, 10));
      gp3.setHgap(10);
      gp3.setVgap(1);
      gp3.setPadding(new Insets(10, 10, 10, 10));
      gp.add(label, 0, 0);
      gp.add(laptopLV, 0, 2);
      gp2.add(btn1, 2, 3);
      gp2.add(btn2, 4, 3);
      gp3.add(l2, 0, 5);
      gp3.add(selectedLV, 0, 6);
      gp3.add(l3, 0, 7);
      gp3.add(l4, 1, 7);
      this.getChildren().add(gp);
      this.getChildren().add(gp2);
      this.getChildren().add(gp3);
      
      btn1.setOnAction(new ButtonHandler2());
      btn2.setOnAction(new ButtonHandler2());

	  //Step #3: Register the button with its handler class
	  //----

   } //end of constructor

 //This method refresh the ListView whenever there's new laptop added in InputPane
 //you will need to update the underline ObservableList object in order for ListView
 //object to show the updated laptop list
 public void updateLaptopList(Laptop newLoptop)
 {
	 ObservableList<Laptop> os = (FXCollections.observableArrayList(laptopList));
     laptopLV.setItems(os);
 } 
 

//Step #2: Create a ButtonHandler class
 private class ButtonHandler2 implements EventHandler<ActionEvent>
 {
  	//Override the abstact method handle()
    public void handle(ActionEvent e)
    {
    	ObservableList<Laptop> ol = (FXCollections.observableArrayList(selectedList));
    	Laptop selected = laptopLV.getSelectionModel().getSelectedItem();
    	Laptop selected2 = selectedLV.getSelectionModel().getSelectedItem();
    	btn1.setOnAction(this);
    	Button button = (Button) e.getSource();
		//When "Pick a Laptop" button is pressed and a laptop is selected from
		//the top list
        if (button == btn1)
        {
        	selectedList.add(selected);
        	ol.add(selected);		             //the selected laptop is added to the SelectedList arraylist and the selected laptop list view is updated 
        	selectedLV.setItems(ol);
        	qty++;
			amt = amt + selected.getPrice();

        }
        //when "Remove a Laptop" button is pushed and a laptop is selected from
        //the bottom list
        else if (button == btn2)
         {
        	 selectedList.remove(selected2);
             ol.remove(selected2);
             selectedLV.setItems(ol);			//The selected laptop is removed from the arraylist anf the list view is updated
             qty--;
             amt = amt - selected2.getPrice();
         }
         else //for all other cases
		 {
 
	     }
      	 l3.setText("Qty Selected " + qty);
      	 l4.setText("Total Amt " + amt);//update the QtySelect and AmtSelect labels
      	 //----
       }
   } //end of ButtonHandler class
} //end of PurchasePane class
