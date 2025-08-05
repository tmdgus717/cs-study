package 인스턴스_생성_패턴.builder.gof;

// Product
class Burger {
    String bun;
    String patty;
    String sauce;
    @Override
    public String toString() {
        return bun + " + " + patty + " + " + sauce;
    }
}
