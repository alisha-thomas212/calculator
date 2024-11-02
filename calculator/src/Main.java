import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private TextField textField;
    private logic handler;

    @Override
    public void start(Stage stage) {
        textField = new TextField();
        textField.setEditable(false);
        textField.setStyle("-fx-font-size: 30px;");

        handler = new logic(textField);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));

        handler.setupGrid(gridPane);

        HBox hbox = new HBox(10);
        hbox.setPadding(new Insets(20, 20, 0, 20));
        handler.setupFunctionButtons(hbox);

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(textField, gridPane, hbox);

        Scene scene = new Scene(vbox, 400, 550);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}