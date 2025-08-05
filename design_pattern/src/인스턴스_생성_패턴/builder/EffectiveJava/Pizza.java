package 인스턴스_생성_패턴.builder.EffectiveJava;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {
    public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE};
    final Set<Topping> toppings;

    abstract static class Builder{

        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public Builder addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        protected abstract Builder self();
    }

    public Pizza(Builder builder) {
        toppings = builder.toppings.clone();
    }

    public String toString() {
        return toppings.toString();
    }
}
