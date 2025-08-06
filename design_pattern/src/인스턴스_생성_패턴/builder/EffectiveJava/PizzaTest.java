package 인스턴스_생성_패턴.builder.EffectiveJava;

import 인스턴스_생성_패턴.builder.EffectiveJava.NyPizza.Size;
import 인스턴스_생성_패턴.builder.EffectiveJava.Pizza.Topping;

public class PizzaTest {
    public static void main(String[] args) {

        Pizza nyPizza = new NyPizza.Builder(Size.SMALL)
            .addTopping(Topping.SAUSAGE)
            .addTopping(Topping.ONION)
            .build();

        System.out.println(nyPizza);
    }

}
