import data.Api;

public class App {
    public static void main(String[] args){
        Api api = new Api();
        var users = api.fetchUsers().blockingGet();
        var carts = api.fetchCards().blockingGet();
        System.out.println(carts);
    }
}
