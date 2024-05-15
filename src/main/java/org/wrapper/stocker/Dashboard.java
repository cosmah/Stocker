package org.wrapper.stocker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Dashboard extends Application {

    private Parent root;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
        root = loader.load();

        // Assuming you have a Controller class defined in your FXML
        DashboardController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);

        Scene scene = new Scene(root, 1500, 700);
        primaryStage.setTitle("STOCKER");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void handleMenuItemClick(MouseEvent event) {
        MenuItem menuItem = (MenuItem) event.getSource();
        String title = menuItem.getText();

        switch (title) {
            case "Overview":
                // Load Overview view
                break;
            case "Reports":
                // Load Reports view
                break;
            case "Stock":
                // Load Stock view
                break;
            case "People":
                // Load People view
                break;
            case "Expenses":
                // Load Expenses view
                break;
            case "Warehouse":
                // Load Warehouse view
                break;
            default:
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Feature not implemented yet.");
                alert.showAndWait();
        }
    }
}