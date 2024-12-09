package org.mdolgushev.neomorphism;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);  // Запуск JavaFX приложения
    }

    @Override
    public void start(Stage primaryStage) {
        // Список коммитов
        ListView<String> commitList = new ListView<>();
        commitList.getItems().addAll("6 Dec. 2024", "3 Dec. 2024", "2 Dec. 2024");

        // Область для деталей выбранного коммита
        TextArea commitDetails = new TextArea();
        commitDetails.setPromptText("Select a commit to view details...");
        commitDetails.setEditable(false);

        // Панель с кнопками для команд (Commit, Pull, Push)
        Button commitButton = new Button("Commit");
        Button pullButton = new Button("Pull");
        Button pushButton = new Button("Push");

        HBox buttons = new HBox(10, commitButton, pullButton, pushButton);
        buttons.setPadding(new Insets(10));

        // Панель для ввода команд
        TextArea commandInput = new TextArea();
        commandInput.setPromptText("Enter your Git command here...");

        // Основная панель
        VBox rightPanel = new VBox(10, commitDetails, buttons, commandInput);
        rightPanel.setPadding(new Insets(10));

        // Основная рамка
        BorderPane root = new BorderPane();
        root.setLeft(commitList);
        root.setCenter(rightPanel);

        // Обработчики событий для списка коммитов
        commitList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Здесь мы можем обновить commitDetails в зависимости от выбранного коммита
            commitDetails.setText("Details for commit: " + newValue);
        });

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Git GUI Shell");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}