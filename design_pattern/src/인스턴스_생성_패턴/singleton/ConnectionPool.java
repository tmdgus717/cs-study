package 인스턴스_생성_패턴.singleton;

public class ConnectionPool {

    private static ConnectionPool instance = new ConnectionPool();

    private ConnectionPool(){
        //인스턴스 생성 방지
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }
}
