package net.jonaskf.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import net.jonaskf.models.Person;

import java.net.URL;
import java.util.ResourceBundle;

public class TableController implements Initializable {
    @FXML
    private TableView<Object> tableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tableView
                .getColumns()
                .addAll(
                        this.getColumn("Name", "name", String.class),
                        this.getColumn("Age", "age", Integer.class),
                        this.getColumn("Profession", "profession", String.class));


        this.add(
                new Person("Li Hua", 25, "Consultant"));
        this.add(
                new Person("Joel", 34, "Private contractor"));
    }

    private <T> TableColumn getColumn(String title, String key, Class<T> type) {
        TableColumn column = new TableColumn(title);
        column.setCellValueFactory(
                new PropertyValueFactory<Person, T>(key));
        return column;
    }

    private void add(Object object) {
        this.tableView
                .getItems()
                .add(object);
    }
}
