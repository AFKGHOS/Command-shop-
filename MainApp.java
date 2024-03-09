import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;


import javafx.scene.layout.VBox;
import javafx.stage.Stage;

     
    public class MainApp extends Application {
        private ListView<String> listView;
        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) {
            primaryStage.setTitle("MainApp");

         listView = new ListView<>();
         listView.setPrefWidth(100);
         listView.setStyle("-fx-margin-width: 10;");
           listView.getItems().addAll("id", "number command");

           Button button = new Button("adauga comanda");
           button.setStyle("-fx-background-color: black; -fx-border-color: white; -fx-border-width: 2px;");
           button.setOnAction(e -> openModel());

           Button saveButton = new Button("Save Products");
           saveButton.setStyle("-fx-background-color: black; -fx-border-color: white; -fx-color: white;");
           VBox vbox = new VBox();

           Scene scene = new Scene(vbox, 300, 200);

           vbox.getChildren().addAll(button, saveButton,listView);

           primaryStage.setScene(scene);

            primaryStage.show();
        }

        private void openModel() {
            Stage modalStage = new Stage();
            modalStage.initModality(Modality.APPLICATION_MODAL);

            modalStage.setTitle("Adauga o comanda");

            TextField textField = new TextField();

            Button addButton = new Button("Adauga comanda");
            addButton.setOnAction(e -> {
                String data = textField.getText();
                if (!data.isEmpty()) {
                    listView.getItems().add(data);
                    modalStage.close();
                }
            });

            VBox modalLayout = new VBox(10);
            modalLayout.getChildren().addAll(new Label("Introduceti nr. comenzi"), textField, addButton);

            Scene modalScene = new Scene(modalLayout, 300, 200);
            modalStage.setScene(modalScene);

            modalStage.showAndWait();
        }
    }
