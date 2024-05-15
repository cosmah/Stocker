package org.wrapper.stocker;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class DashboardController {

    private Parent mainContent;
    private Stage primaryStage; 

    public void initialize() {
        // Initialize any components or data structures here
    }

    public void setMainContent(Parent mainContent) {
        this.mainContent = mainContent;
    }

    public void setPrimaryStage(Stage primaryStage) { // Method to set the primary stage
        this.primaryStage = primaryStage;
    }

    public void handleMenuItemClick(MouseEvent event) {
        MenuItem menuItem = (MenuItem) event.getSource();
        String title = menuItem.getText();

        try {
            switch (title) {
                case "Overview":
                    loadView("overview.fxml");
                    break;
                case "Reports":
                    loadView("reports.fxml");
                    break;
                case "Stock":
                    loadView("stock.fxml");
                    break;
                case "People":
                    loadView("people.fxml");
                    break;
                case "Expenses":
                    loadView("expenses.fxml");
                    break;
                case "Warehouse":
                    loadView("warehouse.fxml");
                    break;
                default:
                    throw new IllegalArgumentException("Unknown menu item: " + title);
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error Loading View");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    private void loadView(String fxmlPath) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
    Parent view = loader.load();
    
    // Cast mainContent to the appropriate subclass
    Pane mainContentPane = (Pane) mainContent;
    
    // Use getChildren() to access children
    mainContentPane.getChildren().setAll(view.getChildrenUnmodifiable());
}
}