package Model.Gladiator.GladiatorTitle;

public class EmptyTitle implements TitleDecorator {


    public EmptyTitle()
    {

    }

    @Override
    public String getTitle() {
        return "";
    }
}
