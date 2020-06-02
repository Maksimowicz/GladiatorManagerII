package Model.Classes;

import java.util.Objects;

//Class to create enumlike entity for Abstract class factory
public abstract class GladiatorClassSubtypes {
    String value;

    public GladiatorClassSubtypes(String value)
    {
        this.value = value;
    }

    public final String getValue()
    {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GladiatorClassSubtypes that = (GladiatorClassSubtypes) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
