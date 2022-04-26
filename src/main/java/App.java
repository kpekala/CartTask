import data.Api;

public class App {
    public static void main(String[] args){
        Api api = new Api();
        var users = api.fetchUsers().blockingGet();
        var carts = api.fetchCarts().blockingGet();
        var products = api.fetchProducts().blockingGet();
        System.out.println(products);
    }
}
