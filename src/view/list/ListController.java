package view.list;

import java.io.IOException;
import java.sql.SQLException;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Todo;

public class ListController {

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private TableColumn<?, ?> ownerCol;

    @FXML
    private TableColumn<?, ?> statusCol;

    @FXML
    private TableColumn<?, ?> textCol;

    @FXML
    private TableView<Todo> table;

    ViewHandler vh;

    ListViewModel listViewModel;

    public void init(ViewHandler viewHandler, ListViewModel listViewModel) {
        this.vh = viewHandler;
        this.listViewModel = listViewModel;

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        ownerCol.setCellValueFactory(new PropertyValueFactory<>("owner"));
        textCol.setCellValueFactory(new PropertyValueFactory<>("text"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("isCompleted"));

        refreshTable();
    }

    @FXML
    void AddOnAction(ActionEvent event) {
        try {
            vh.openAddView();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void deleteOnAction(ActionEvent event) {

    }

    @FXML
    void editOnAction(ActionEvent event) {

    }

    @FXML
    void completedOnAction(ActionEvent event) {
        try {
            listViewModel.todoCompleted(table.getSelectionModel().getSelectedItem());
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }

        refreshTable();
    }

    private void refreshTable() {
        table.getItems().clear();

        try {
            listViewModel.loadData();
        } catch (Exception e) {
            e.printStackTrace();
        }

        table.setItems(listViewModel.getTodos());
    }

}
