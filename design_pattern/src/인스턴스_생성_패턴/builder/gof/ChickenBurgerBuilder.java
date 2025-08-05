package 인스턴스_생성_패턴.builder.gof;

// ConcreteBuilder
class ChickenBurgerBuilder implements BurgerBuilder {
    private Burger burger = new Burger();
    public void buildBun() { burger.bun = "Wheat Bun"; }
    public void buildPatty() { burger.patty = "Chicken Patty"; }
    public void buildSauce() { burger.sauce = "Mayo"; }
    public Burger getResult() { return burger; }
}
