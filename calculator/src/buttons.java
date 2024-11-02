import javafx.scene.control.Button;
import javafx.scene.control.TextField;
public class buttons {
    public static Button[] numButtons(TextField textField) {
        Button[] buttons = new Button[10];
        for (int i = 0; i < 10; i++) {
            buttons[i] = new Button(String.valueOf(i));
            buttons[i].setStyle("-fx-font-size: 30px; -fx-pref-width: 70px; -fx-pref-height: 80px;");
            int index = i;
            buttons[i].setOnAction(e -> textField.setText(textField.getText() + index));
        }
        return buttons;
    }

    public static Button operationButtons(String text, javafx.event.EventHandler<javafx.event.ActionEvent> handler) {
        Button button = new Button(text);
        button.setStyle("-fx-font-size: 30px; -fx-pref-width: 70px; -fx-pref-height: 80px;");
        button.setOnAction(handler);
        return button;
    }

    public static Button eqlButton(String text, javafx.event.EventHandler<javafx.event.ActionEvent> handler) {
        return operationButtons(text, handler);
    }

    public static Button otherButtons(String text, javafx.event.EventHandler<javafx.event.ActionEvent> handler) {
        Button button = new Button(text);
        button.setStyle("-fx-font-size: 30px; -fx-pref-width: 100px; -fx-pref-height: 80px;");
        button.setOnAction(handler);
        return button;
    }
}


