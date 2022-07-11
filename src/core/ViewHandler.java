package core;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.add.AddController;
import view.list.ListController;

public class ViewHandler {
    private Stage stage;
    private ViewModelFactory vmf;

    public ViewHandler(ViewModelFactory vmf) {
        this.stage = new Stage();
        this.vmf = vmf;
    }

    public void start() {
        try {
            openListView();
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.show();
    }

    public void openListView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/list/List.fxml"));

        Parent root = loader.load();

        ListController controller = loader.getController();

        controller.init(this, vmf.getListViewModel());

        Scene scene = new Scene(root);

        stage.setScene(scene);
    }

    public void openAddView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/add/Add.fxml"));

        Parent root = loader.load();

        AddController controller = loader.getController();

        controller.init(this, vmf.getAddViewModel());

        Scene scene = new Scene(root);

        stage.setScene(scene);
    }

}
