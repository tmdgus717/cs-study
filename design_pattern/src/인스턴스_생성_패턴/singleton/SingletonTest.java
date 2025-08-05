package 인스턴스_생성_패턴.singleton;

import java.util.Calendar;

public class SingletonTest {
    public static void main(String[] args) {
        ConnectionPool instance1 = ConnectionPool.getInstance();
        ConnectionPool instance2 = ConnectionPool.getInstance();

        System.out.println(instance1 == instance2); //같은 인스턴스라면 true 반환
    }
}
