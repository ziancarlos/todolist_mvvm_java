package core;

import view.add.AddViewModel;
import view.list.ListViewModel;

public class ViewModelFactory {
    ModelFactory modelFactory;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public ListViewModel getListViewModel() {
        return new ListViewModel(modelFactory.getTodoService());
    }

    public AddViewModel getAddViewModel() {
        return new AddViewModel(modelFactory.getTodoService());
    }

}
