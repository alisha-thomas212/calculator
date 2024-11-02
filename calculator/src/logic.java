import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
public class logic {
    private final TextField textField;
    private final calculations model = new calculations();

    public logic(TextField textField) {
        this.textField = textField;
    }

    public void setupGrid(GridPane gridPane) {
        Button[] numberButtons = buttons.numButtons(textField);
        Button addButton = buttons.operationButtons("+", e -> operator('+'));
        Button subButton = buttons.operationButtons("-", e -> operator('-'));
        Button mulButton = buttons.operationButtons("*", e -> operator('*'));
        Button divButton = buttons.operationButtons("/", e -> operator('/'));
        Button decButton = buttons.operationButtons(".", e -> decimal());

        gridPane.add(numberButtons[1], 0, 0);
        gridPane.add(numberButtons[2], 1, 0);
        gridPane.add(numberButtons[3], 2, 0);
        gridPane.add(addButton, 3, 0);

        gridPane.add(numberButtons[4], 0, 1);
        gridPane.add(numberButtons[5], 1, 1);
        gridPane.add(numberButtons[6], 2, 1);
        gridPane.add(subButton, 3, 1);

        gridPane.add(numberButtons[7], 0, 2);
        gridPane.add(numberButtons[8], 1, 2);
        gridPane.add(numberButtons[9], 2, 2);
        gridPane.add(mulButton, 3, 2);

        gridPane.add(decButton, 0, 3);
        gridPane.add(numberButtons[0], 1, 3);
        gridPane.add(buttons.eqlButton("=", e -> calculate()), 2, 3);
        gridPane.add(divButton, 3, 3);
    }

    public void setupFunctionButtons(HBox hbox) {
        hbox.getChildren().addAll(
                buttons.otherButtons("(-)", e -> negation()),
                buttons.otherButtons("Del", e -> delete()),
                buttons.otherButtons("Clr", e -> textField.setText(""))
        );
    }

    private void operator(char op) {
        model.setNum1(Double.parseDouble(textField.getText()));
        model.setOperator(op);
        textField.setText("");
    }

    private void decimal() {
        if (!textField.getText().contains(".")) {
            textField.setText(textField.getText() + ".");
        }
    }

    private void calculate() {
        model.setNum2(Double.parseDouble(textField.getText()));
        textField.setText(String.valueOf(model.calculate()));
    }

    public void delete() {
        String text = textField.getText();
        if (!text.isEmpty()) {
            textField.setText(text.substring(0, text.length() - 1));
        }
    }

    public void negation() {
        double value = Double.parseDouble(textField.getText()) * -1;
        textField.setText(String.valueOf(value));
    }

}
