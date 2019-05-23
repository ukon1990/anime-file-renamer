package net.sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TableController implements Initializable {
    @FXML
    private TableView<Object> tableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    void addColumns(TableColumn... columns) {
        this.tableView
                .getColumns()
                .addAll(columns);
    }

    private <T> TableColumn getColumn(String title, String key, Class<T> type) {
        TableColumn column = new TableColumn(title);
        column.setCellValueFactory(
                new PropertyValueFactory<Object, T>(key));
        return column;
    }

    void add(Object object) {
        this.tableView
                .getItems()
                .add(object);
    }

    public void clear() {
        this.tableView.getItems().clear();
    }

    <T>void addColumn(String title, String key, Class<T> type) {
        TableColumn column = this.getColumn(title, key, type);
        this.tableView.getColumns().add(column);
    }
}
