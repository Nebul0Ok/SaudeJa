package Utility;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class Keybinds {

    public static StackPane Menu(){
	    StackPane background = new StackPane();
	    StackPane background2 = new StackPane();
	    StackPane background3 = new StackPane();
	    Label teste = new Label("Teste");
	    
	    background3.setMaxHeight(200);
	    background3.setMaxWidth(500);
	    
	    background2.setMaxHeight(2000);
	    background2.setMaxWidth(2000);
	    
	    background3.setOpacity(1);
	    background2.setOpacity(0.5);
	    
	    background2.setStyle("-fx-background-color: blue;");
	    background3.setStyle("-fx-background-color: white;");
	    teste.setStyle("-fx-text-fill: black;");
	    
	    background3.getChildren().add(teste);
	    background.getChildren().add(background2);
	    background.getChildren().add(background3);
    
	    return background;
    }
    
}
