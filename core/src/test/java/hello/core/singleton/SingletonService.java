package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    // new 생성자를 private처리 해줌으로 또다른 instance를 만들지 않도록 처리
    private SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 로직 호출");
    }
}
