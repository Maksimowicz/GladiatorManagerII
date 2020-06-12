package Model.Classes.Mages;

import Model.Classes.GladiatorClassSubtypes;

public class MageSubtypes extends GladiatorClassSubtypes {

    private MageSubtypes(String value){
        super(value);
        //declared private to avoid creation of element
    };

    public static MageSubtypes constructCurser() {
        return new MageSubtypes("Curser");
    }

    public static MageSubtypes constructElementalist()
    {
        return new MageSubtypes("Elementalist");
    }

    public static MageSubtypes constructIllusionist()
    {
        return new MageSubtypes("Illusionist");
    }



}
