package hello.core.lifecycle;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = "+url);

    }
    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connect url = "+ url);
    }
    public void call(String message) {
        System.out.println("call: "+ url + " message = " + message);
    }
    public void disconnect() {
        System.out.println("close: "+ url);
    }

    //의존관계 주입이 끝나면 호출됨
    @PostConstruct
    public void init(){
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    //스프링 빈이 종료될때 호출됨
    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
