package View;
import Presenter.Presenter;
public interface View {

    public void start();
    public void setPresenter(Presenter presenter);
    public void ptint(String info);
}
