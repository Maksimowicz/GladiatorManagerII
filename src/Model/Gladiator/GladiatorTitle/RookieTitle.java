package Model.Gladiator.GladiatorTitle;

public class RookieTitle implements TitleDecorator{
    TitleDecorator baseTitle;

    public RookieTitle(TitleDecorator baseTitle)
    {
        this.baseTitle = baseTitle;
    }

    @Override
    public String getTitle() {
        return baseTitle.getTitle() + " " + "The Rookie";
    }
}
