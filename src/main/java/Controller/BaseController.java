package Controller;

import Utility.SceneSwitch;

public class BaseController {
    protected SceneSwitch sceneSwitch;
    
    public void setSceneSwitch(SceneSwitch sceneSwitch){
	this.sceneSwitch = sceneSwitch;
    }
    
}


/*
    javafx.application.Platform.runLater(() -> {
	    Scene scene = btnLogin.getScene();
	    
	    Stage stage = (Stage) scene.getWindow();
	    
	    stage.setOnCloseRequest(event -> {
		System.out.println("Hello World");
	    });
	    
	    scene.setOnKeyPressed(this::handleEnter);
	}); 
*/