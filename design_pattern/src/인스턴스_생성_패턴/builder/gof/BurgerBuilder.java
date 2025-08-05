package 인스턴스_생성_패턴.builder.gof;

// Builder
interface BurgerBuilder {
    void buildBun();
    void buildPatty();
    void buildSauce();
    Burger getResult();
}

