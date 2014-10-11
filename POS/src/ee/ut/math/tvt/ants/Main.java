package ee.ut.math.tvt.ants;
	
import java.io.File;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;


public class Main extends Application {
	public void start(Stage stage) {
        // load the image
        File file = new File("/Users/Tanel/Documents/tudeng/Tarkvaratehnika/workspace/POS/beerhouse.jpg");
		Image image = new Image(file.toURI().toString());

        // simple displays ImageView the image as is
        ImageView iv1 = new ImageView();
        iv1.setImage(image);
        iv1.setFitWidth(100);
        iv1.setPreserveRatio(true);
        iv1.setSmooth(true);
        iv1.setCache(true);
        
        Group root = new Group();
        Scene scene = new Scene(root, 450, 100);
        scene.setFill(Color.ANTIQUEWHITE);
        HBox box = new HBox();
        box.getChildren().add(iv1);
        box.getChildren().addAll(new Label(""
        		+ "Team name: \n"
        		+ "Team leader: \n"
        		+ "Team leader email: \n"
        		+ "Team members: \n"
        		+ "Software version:"),
        new Label(""
        		+ "ANTS \n"
        		+ "Tanel Aamer \n"
        		+ "tanel.aamer@eesti.ee \n"
        		+ "Toomas Õunmaa, Umar Zarip, Tanel Aamer \n"
        		+ "TBA")
        		);
        root.getChildren().add(box);

        stage.setTitle("Intro screen");
        stage.setWidth(415);
        stage.setHeight(200);
        stage.setScene(scene); 
        stage.sizeToScene(); 
        stage.show(); 
	 
	}
	
	public static void main(String[] args) {
		System.out.println("C:\\Users\\Tanel\\Documents\\tudeng\\Tarkvaratehnika\\workspace\\POS\\beerhouse.jpg");
		launch(args);
	}
}
