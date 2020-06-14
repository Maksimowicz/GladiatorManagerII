package Model.Gladiator.GladiatorTitle;

public class VeteranTitle implements TitleDecorator{
    TitleDecorator baseTitle;

    public VeteranTitle(TitleDecorator baseTitle)
    {
        this.baseTitle = baseTitle;
    }

    @Override
    public String getTitle() {
        return baseTitle.getTitle() + " " + "The Veteran";
    }
}
