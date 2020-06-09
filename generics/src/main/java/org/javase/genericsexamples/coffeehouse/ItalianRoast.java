package org.javase.genericsexamples.coffeehouse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Juneau
 */
public class ItalianRoast extends CoffeeType implements Dark {
    List<String> description;

    public ItalianRoast() {
        description = new ArrayList<>();
        description.add(BOLD);
        description.add(ROBUST);
        description.add(WINEY_UNDERTONES);
        description.add(WHOLE_BEAN);
    }

    @Override
    public List<String> getDescription() {
        return description;
    }

}
