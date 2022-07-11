package view.update;

import java.io.IOException;
import java.sql.SQLException;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Todo;

public class UpdateController {

    @FXML
    private TextField ownerTf;

    @FXML
    private TextField textTf;

    ViewHandler viewHandler;

    UpdateViewModel updateViewModel;

    Todo todo;

    public void init(ViewHandler viewHandler, UpdateViewModel updateViewModel, Todo todo) {
        this.viewHandler = viewHandler;
        this.updateViewModel = updateViewModel;
        this.todo = todo;

        ownerTf.textProperty().bindBidirectional(updateViewModel.getOwner());
        textTf.textProperty().bindBidirectional(updateViewModel.getText());

        ownerTf.setText(todo.getOwner());
        textTf.setText(todo.getText());
    }

    @FXML
    void cancelOnAction(ActionEvent event) {
        try {
            viewHandler.openListView();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void updateOnAction(ActionEvent event) {
        try {
            updateViewModel.updateTodo(todo);
        } catch (ClassNotFoundException | SQLException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            viewHandler.openListView();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
