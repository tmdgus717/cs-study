package 인스턴스_생성_패턴.builder.gof;

public class Main {
    public static void main(String[] args) {
        Director director = new Director(new ChickenBurgerBuilder());
        Burger burger = director.construct();
        System.out.println(burger); // Wheat Bun + Chicken Patty + Mayo
    }
}
