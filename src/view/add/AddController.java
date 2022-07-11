package view.add;

import java.io.IOException;
import java.sql.SQLException;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;

public class AddController {

    @FXML
    private TextField ownerTf;

    @FXML
    private TextField textTf;

    ViewHandler viewHandler;

    AddViewModel addViewModel;

    public void init(ViewHandler viewHandler, AddViewModel addViewModel) {
        this.viewHandler = viewHandler;
        this.addViewModel = addViewModel;

        ownerTf.textProperty().bindBidirectional(addViewModel.getOwner());
        textTf.textProperty().bindBidirectional(addViewModel.getText());

    }

    @FXML
    void cancelOnAction(ActionEvent event) {
        try {
            viewHandler.openListView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void okOnAction(ActionEvent event) {
        try {
            addViewModel.addTodo();

            viewHandler.openListView();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }

    }

}
