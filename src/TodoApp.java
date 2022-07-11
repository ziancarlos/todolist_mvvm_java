import core.ModelFactory;
import core.ViewHandler;
import core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class TodoApp extends Application {

    @Override
    public void start(Stage arg0) throws Exception {
        ModelFactory mf = new ModelFactory();
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(vmf);

        vh.start();
    }

}
