package net.jonaskf.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import net.jonaskf.models.CompanyTableObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TableController implements Initializable {
    ArrayList<CompanyTableObject> list = new ArrayList<>();
    @FXML
    private TableView<CompanyTableObject> tableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void addCompany(CompanyTableObject companyTableObject) {
        this.list.add(companyTableObject);
    }
}
