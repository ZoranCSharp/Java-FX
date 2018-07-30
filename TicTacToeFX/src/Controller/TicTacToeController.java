package Controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;


public class TicTacToeController {

    @FXML
    private MenuItem Play;

    @FXML
    private MenuItem Quit;

    @FXML
    private MenuItem HowToPlay;

    @FXML
    private MenuItem About;

    @FXML
    private Button b7;

    @FXML
    private Button b8;

    @FXML
    private Button b9;

    @FXML
    private Button b4;

    @FXML
    private Button b1;

    @FXML
    private Button b5;

    @FXML
    private Button b6;

    @FXML
    private Button b2;

    @FXML
    private Button b3;
    
    @FXML
    GridPane gameBoard;
    
    private boolean isFirstPlayer = true;

    @FXML
    public void buttonClickedHandler(ActionEvent event) {
    	
    	Button clickedButton = (Button) event.getTarget();
    	String buttonLable = clickedButton.getText();
    	
    	if("".equals(buttonLable) && isFirstPlayer) {
    		
    		clickedButton.setText("X");
    		isFirstPlayer = false;
    	}else if("".equals(buttonLable) && !isFirstPlayer) {
    		
    		clickedButton.setText("O");
    		isFirstPlayer = true;
    	}
    	find3InARow();

    }

    private boolean find3InARow(){
 	   //Row 1
 	   if (""!=b1.getText() && b1.getText() == b2.getText() 
 		   && b2.getText() == b3.getText()){
 		   highlightWinningCombo(b1,b2,b3);
 		   return true;
 	   }
 	   //Row 2
 	   if (""!=b4.getText() && b4.getText() == b5.getText() 
 		   && b5.getText() == b6.getText()){
 		   highlightWinningCombo(b4,b5,b6);
 		   return true;
 	   }
 	   //Row 3
 	   if (""!=b7.getText() && b7.getText() == b8.getText() 
 		   && b8.getText() == b9.getText()){
 		   highlightWinningCombo(b7,b8,b9);
 		   return true;
 	   }
 	   //Column 1
 	   if (""!=b1.getText() && b1.getText() == b4.getText() 
 		   && b4.getText() == b7.getText()){
 		   highlightWinningCombo(b1,b4,b7);
 		   return true;
 	   }
 	   //Column 2
 	   if (""!=b2.getText() && b2.getText() == b5.getText() 
 		   && b5.getText() == b8.getText()){
 		   highlightWinningCombo(b2,b5,b8);
 		   return true;
 	   }
 	   //Column 3
 	   if (""!=b3.getText() && b3.getText() == b6.getText() 
 		   && b6.getText() == b9.getText()){
 		   highlightWinningCombo(b3,b6,b9);
 		   return true;
 	   }
 	   //Diagonal 1
 	   if (""!=b1.getText() && b1.getText() == b5.getText() 
 		   && b5.getText() == b9.getText()){
 		   highlightWinningCombo(b1,b5,b9);
 		   return true;
 	   }
 	   //Diagonal 2
 	   if (""!=b3.getText() && b3.getText() == b5.getText() 
 		   && b5.getText() == b7.getText()){
 		   highlightWinningCombo(b3,b5,b7);
 		   return true;
 	   }	   
 	   return false;
    }
    
    private void highlightWinningCombo(Button first, Button second, Button third){
        first.getStyleClass().add("winning-button");
        second.getStyleClass().add("winning-button");
        third.getStyleClass().add("winning-button");

    }
    
    
    //MENU ITEM
    
    @FXML
    public void menuClickHandler(ActionEvent evt){
 		MenuItem clickedMenu = (MenuItem) evt.getTarget();
 		String menuLabel = clickedMenu.getText();
 		
 		if ("Play".equals(menuLabel)){
 			
 			ObservableList<Node> buttons = gameBoard.getChildren();
 			
 			buttons.forEach(btn -> {
 				
 				((Button) btn).setText("");
 				 btn.getStyleClass().remove("winning-button");
 			});
 			
 			isFirstPlayer = true;
 		}else if("Quit".equals(menuLabel)) {
 			
 			Platform.exit();
 			
 		}else if("About".equals(menuLabel)) {
 			
 			Desktop d = Desktop.getDesktop();
 			try {
				d.browse(new URI("https://github.com/ZoranKJava"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 			
 			
 						
 		}else if("How To Play".equals(menuLabel)) {
 			
 			Desktop b = Desktop.getDesktop();
 			try {
				b.browse(new URI("https://en.wikipedia.org/wiki/Tic-tac-toe#Strategy"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 			
 		}
    }  
    
   
 }
















