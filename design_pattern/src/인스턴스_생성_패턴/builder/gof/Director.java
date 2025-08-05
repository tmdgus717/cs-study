package 인스턴스_생성_패턴.builder.gof;

public class Director {
    private BurgerBuilder builder;
    public Director(BurgerBuilder builder) { this.builder = builder; }
    public Burger construct() {
        builder.buildBun();
        builder.buildPatty();
        builder.buildSauce();
        return builder.getResult();
    }
}
