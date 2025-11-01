package Classes;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Card {
    public int id;
    public String nome;
    public String urlImagem;
    public Label nomeProduto;
    public Button acessar;
    public VBox card;
    
    public VBox cardGen(String nome, String urlImagem){
	VBox carta = new VBox(10);
	carta.setMaxHeight(220);
	carta.setMaxWidth(220);
	carta.setStyle("-fx-background-color: lightgray; -fx-padding: 15; -fx-background-radius:7;");
	
	try {
	    
	    String url = urlImagem;
	    Label nomeLabel = new Label(nome);
	    nomeLabel.setStyle("-fx-font-size:15; -fx-font-wight:bold; -fx-text-fill:black;");

	    Image imagemCarta = new Image(url);
	    ImageView imageView = new ImageView(imagemCarta);
	    imageView.setFitWidth(200);
	    imageView.setFitHeight(200);
	    imageView.setPreserveRatio(false);

	    Button preco = new Button("Preços");

	    carta.getChildren().addAll(imageView, nomeLabel, preco);
	    
	} catch (Exception e) {
	    System.out.println("Erro ao carregar imagem: " + e.getMessage());
	}
	
	
	return carta;
    }
    
}
