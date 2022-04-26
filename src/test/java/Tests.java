import data.Api;
import org.junit.jupiter.api.Test;

public class Tests {
    @Test
    public void fetchedUserListIsNotEmpty(){
        Api api = new Api();
        var users = api.fetchUsers().blockingGet();
        assert users.size() > 0;
    }

    @Test
    public void fetchedCartListIsNotEmpty(){
        Api api = new Api();
        var carts = api.fetchCarts().blockingGet();
        assert carts.size() > 0;
    }

    @Test
    public void fetchedProductListIsNotEmpty(){
        Api api = new Api();
        var products = api.fetchProducts().blockingGet();
        assert products.size() > 0;
    }
}
