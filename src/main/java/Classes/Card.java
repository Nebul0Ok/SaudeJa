package Classes;

import Utility.SceneSwitch;
import Classes.ProdutoCarrinho;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class Card {
    public int id;
    public String nome;
    public String urlImagem;
    public Label nomeProduto;
    public Button acessar;
    public VBox card;
    
    public VBox cardGen(String nome, String urlImagem, SceneSwitch sceneSwitch){
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

	    Button preco = new Button("Consultar Preços");
	    
	    preco.setOnAction(e -> {	
		try {
		Gson gson = new Gson();
		FileWriter fw = new FileWriter("src/main/resources/UserLogged/ProdutoClickado.json");  
		
		String objJson = gson.toJson(nome);
		
		fw.write(objJson);
		fw.close();
		} catch (Exception ex) {
		    System.out.println("Erro: " + ex.getMessage());
		}
		
		sceneSwitch.telaProduto();
		
	    });

	    carta.getChildren().addAll(imageView, nomeLabel, preco);
	    
	} catch (Exception e) {
	    System.out.println("Erro ao carregar imagem: " + e.getMessage());
	}
	
	
	return carta;
    }
    
     public static HBox medcardGen(String nomeMed, String urlImagem, String tipo, String numTel){
	HBox carta = new HBox(10);
	carta.setMaxHeight(180);
	carta.setMaxWidth(360);
	carta.setStyle("-fx-background-color: lightgray; -fx-padding: 15; -fx-background-radius:7;");

	 try {
	     Image imagem = new Image(urlImagem);
	     ImageView imageview = new ImageView(imagem);
	     imageview.setFitHeight(150);
	     imageview.setFitWidth(150);
	     Label nomes = new Label(nomeMed);
	     Label tipoMed = new Label(tipo);
	     Label numero = new Label(numTel);
	     Button marcar = new Button("Marcar Consulta");
	     
	     marcar.setOnAction(e -> {
		 try {
		Gson gson = new Gson();
		FileWriter fw = new FileWriter("src/main/resources/UserLogged/MedicoClickado.json");  
		
		String objJson = gson.toJson(nomeMed);
		
		fw.write(objJson);
		fw.close();
		} catch (Exception ex) {
		    System.out.println("Erro: " + ex.getMessage());
		}
	     });
	     
	     
	     VBox layout = new VBox();
	     layout.setAlignment(Pos.CENTER_RIGHT);
	     
	     nomes.setStyle("-fx-text-fill:black; -fx-font-size:25;");
	     tipoMed.setStyle("-fx-text-fill:black; -fx-font-size:20;");
	     numero.setStyle("-fx-text-fill:black;  -fx-font-size:15;");
	     marcar.setStyle("-fx-font-size:15");
	     
	     
	     carta.getChildren().add(imageview);
	     
	     layout.getChildren().add(nomes);
	     layout.getChildren().add(tipoMed);
	     layout.getChildren().add(numero);
	     layout.getChildren().add(marcar);
	     
	     carta.getChildren().add(layout);
	     
	 } catch (Exception e) {
	     System.out.println("Erro: "+ e.getMessage());
	 }
	 
	 return carta;
    }
     
     public static GridPane cardLojas(int id, String nome, String nomeprod, float preco){
	 GridPane carta = new GridPane();
	 
	 carta.setHgap(10);
	 
	 Label nomes = new Label(nomeprod);
	 Label precos = new Label("Preço: R$" + String.valueOf(preco));
	 Button adicionar = new Button ("Adicionar");
	 
	 ProdutoCarrinho produto = new ProdutoCarrinho(id, nome, nomeprod, preco); 
	 
	 Gson gson = new Gson();
	 adicionar.setOnAction((event) -> {
	     try (FileWriter fw = new FileWriter("src/main/resources/UserLogged/Carrinho.json", true)){
		 
		 String json = gson.toJson(produto);
		 
		 fw.write(json);
		 fw.write("\n");
		 
		 
	     } catch (Exception e) {
		 System.out.println("Erro: "+ e.getMessage());
	     }
	     
	 });
	 
	 carta.add(nomes, 0, 0);
	 carta.add(precos, 1, 0);
	 carta.add(adicionar, 2, 0);
	 
	 //HBox.setHgrow(carta, Priority.NEVER);
	 //VBox.setVgrow(carta, Priority.NEVER);
	 
	 GridPane.setHalignment(nomes, HPos.LEFT);
	 GridPane.setHalignment(precos, HPos.CENTER);
	 GridPane.setHalignment(adicionar, HPos.RIGHT);
	 
	 GridPane.setValignment(nomes, VPos.CENTER);
	 GridPane.setValignment(precos, VPos.CENTER);
	 GridPane.setValignment(adicionar, VPos.CENTER);
	 
	 ColumnConstraints col0= new ColumnConstraints();
	 ColumnConstraints col1= new ColumnConstraints();
	 ColumnConstraints col2= new ColumnConstraints();
	 
	 col0.setPercentWidth(33.3);
	 col1.setPercentWidth(33.3);
	 col2.setPercentWidth(33.3);
	 
	 nomes.setMaxWidth(Double.MAX_VALUE);
	 precos.setMaxWidth(Double.MAX_VALUE);
	 adicionar.setMaxWidth(Double.MAX_VALUE);
	 
	 carta.getColumnConstraints().addAll(col0, col1, col2);
	 
	 carta.setPrefWidth(400);
	 
	 return carta;
     }
     
     
    
}
