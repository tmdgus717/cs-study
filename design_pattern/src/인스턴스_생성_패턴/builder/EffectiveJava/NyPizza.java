package 인스턴스_생성_패턴.builder.EffectiveJava;

import java.util.Objects;

public class NyPizza extends Pizza{

    public enum Size { SMALL, MEDIUM, LARGE};
    private final Size size;

    public static class Builder extends Pizza.Builder{

        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        Pizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Pizza.Builder self() {
            return this;
        }
    }

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

}
