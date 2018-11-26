package p08_military_elite.interfaces;

import java.util.Collection;

public interface LeutenantGeneral extends Private{
    Collection<Private> getPrivates();
}