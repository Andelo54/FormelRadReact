package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Formelrad Application
 *
 * @author David Kresic und Andelo Batinic
 * @version 23.11.2021
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            Pane root = new Pane();

            // Creating an image
            Image image = new Image(getClass().getResourceAsStream("formelradelektronik.gif"));
            ImageView imageView = new ImageView(image);
            imageView.setX(10);
            imageView.setY(10);
            imageView.setFitHeight(300);
            imageView.setFitWidth(300);
            imageView.setPreserveRatio(true);
            root.getChildren().add(imageView);

            Label lbleistung = new Label("Leistung:");
            lbleistung.relocate(10, 285);
            lbleistung.setFont(Font.font(15));
            root.getChildren().add(lbleistung);

            TextField txLeistung = new TextField();
            txLeistung.relocate(100, 285);
            txLeistung.setFont(Font.font("Verdana", 15));
            root.getChildren().add(txLeistung);

            Label lblSpannung = new Label("Spannung:");
            lblSpannung.relocate(10, 325);
            lblSpannung.setFont(Font.font(15));
            root.getChildren().add(lblSpannung);

            TextField txSpannung = new TextField();
            txSpannung.relocate(100, 325);
            txSpannung.setFont(Font.font("Verdana", 15));
            root.getChildren().add(txSpannung);

            Label lblStrom = new Label("Strom:");
            lblStrom.relocate(10, 365);
            lblStrom.setFont(Font.font(15));
            root.getChildren().add(lblStrom);

            TextField txStrom = new TextField();
            txStrom.relocate(100, 365);
            txStrom.setFont(Font.font("Verdana", 15));
            root.getChildren().add(txStrom);

            Label lblWiderstand = new Label("Widerstand:");
            lblWiderstand.relocate(10, 405);
            lblWiderstand.setFont(Font.font(15));
            root.getChildren().add(lblWiderstand);

            TextField txWiderstand = new TextField();
            txWiderstand.relocate(100, 405);
            txWiderstand.setFont(Font.font("Verdana", 15));
            root.getChildren().add(txWiderstand);

            Button btnBerechnen = new Button();
            btnBerechnen.relocate(100, 445);
            btnBerechnen.setText("Berechnen");
            root.getChildren().add(btnBerechnen);

            Button btnLoeschen = new Button();
            btnLoeschen.relocate(238, 445);
            btnLoeschen.setText("L??schen");
            root.getChildren().add(btnLoeschen);

            btnLoeschen.setOnAction(e -> {
                txLeistung.setText("");
                txSpannung.setText("");
                txStrom.setText("");
                txWiderstand.setText("");

                if (txLeistung.getText().isEmpty()) {
                    txLeistung.setStyle("-fx-text-inner-color: black;");
                }
                if (txSpannung.getText().isEmpty()) {
                    txSpannung.setStyle("-fx-text-inner-color: black;");
                }
                if (txStrom.getText().isEmpty()) {
                    txStrom.setStyle("-fx-text-inner-color: black;");
                }
                if (txWiderstand.getText().isEmpty()) {
                    txWiderstand.setStyle("-fx-text-inner-color: black;");
                }
            });

            btnBerechnen.setOnAction(e -> {
                double power = 0.0;
                double tension = 0.0;
                double current = 0.0;
                double resistence = 0.0;
                int inputAmount = 0;

                if (!txLeistung.getText().isEmpty()) {
                    power = Double.parseDouble(txLeistung.getText());
                    inputAmount++;
                }
                if (!txSpannung.getText().isEmpty()) {
                    tension = Double.parseDouble(txSpannung.getText());
                    inputAmount++;
                }
                if (!txStrom.getText().isEmpty()) {
                    current = Double.parseDouble(txStrom.getText());
                    inputAmount++;
                }
                if (!txWiderstand.getText().isEmpty()) {
                    resistence = Double.parseDouble(txWiderstand.getText());
                    inputAmount++;
                }
                if (inputAmount != 2) {
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Warning");
                    alert.setHeaderText("Invalid Input");
                    alert.setContentText("Please enter 2 physical quantities");
                    alert.showAndWait();
                } else {

                    if (!txLeistung.getText().isEmpty()) {
                        power = Double.parseDouble(txLeistung.getText());
                    }
                    if (!txSpannung.getText().isEmpty()) {
                        tension = Double.parseDouble(txSpannung.getText());
                    }
                    if (!txStrom.getText().isEmpty()) {
                        current = Double.parseDouble(txStrom.getText());
                    }
                    if (!txWiderstand.getText().isEmpty()) {
                        resistence = Double.parseDouble(txWiderstand.getText());
                    }
                    Calculator myCalculator = new Calculator(
                            power, tension, current, resistence);
                    myCalculator.calculate();

                    if (txLeistung.getText().isEmpty()) {
                        txLeistung.setText(Double.toString(myCalculator.getLeistung()));
                        txLeistung.setStyle("-fx-text-inner-color: red;");
                    }
                    if (txSpannung.getText().isEmpty()) {
                        txSpannung.setText(Double.toString(myCalculator.getSpannung()));
                        txSpannung.setStyle("-fx-text-inner-color: red;");
                    }
                    if (txStrom.getText().isEmpty()) {
                        txStrom.setText(Double.toString(myCalculator.getStrom()));
                        txStrom.setStyle("-fx-text-inner-color: red;");
                    }
                    if (txWiderstand.getText().isEmpty()) {
                        txWiderstand.setText(Double.toString(myCalculator.getWiderstand()));
                        txWiderstand.setStyle("-fx-text-inner-color: red;");
                    }
                }
            });

            Scene scene = new Scene(root, 330, 490);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Formelrad");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
