import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.util.Random;

/**
 * This program runs the application
 *
 * @author Simran Macwan, 000820719
 *
 */
public class AppStart extends Application {
    /**
     * the width of the window
     */
    private double width = 1200;
    /**
     * the height of the window
     */
    private double height = 700;
    /**
     * the mountain name
     */
    private  String mtName;
    /**
     * the secondary stage initialization
     */
    private final Stage secondaryStage = new Stage();


    /**
     * The method is called on the first initialization
     * @param primaryStage JavaFX stage
     * @throws Exception on failure to launch the main window
     */

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane pane = new AnchorPane();
        pane.setPrefHeight(146);
        pane.setPrefWidth(386);
        Label label = new Label("Enter Mountain Name");
        label.setLayoutX(10);
        label.setLayoutY(52);
        TextField textField = new TextField();
        textField.setLayoutX(130);
        textField.setLayoutY(48);
        Button btn = new Button();
        btn.setText("OK");

        btn.setOnAction(event -> {
           mtName = textField.getText();
            stageLauncher();
            primaryStage.close();
        });

        btn.setLayoutX(278);
        btn.setLayoutY(97);
        pane.getChildren().addAll(label,textField,btn);
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();

        primaryStage.setOnCloseRequest(event -> {
            mtName =" ";

            stageLauncher();
        });
    }

    /**
     * Game window launcher
     */
    private  void stageLauncher(){
        secondaryStage.setTitle(" Alien Landers Game");
        Group group = new Group();
        Canvas canvas = new Canvas(width, height);

        GraphicsContext gc = canvas.getGraphicsContext2D();
       GraphicEngine graphicEngine =  new GraphicEngine(gc, width, height);

        group.getChildren().addAll(canvas, graphicEngine.mountainNameTxt(mtName));
        secondaryStage.setScene(new Scene(group));
        secondaryStage.show();
    }
}


