package data;

import com.google.gson.Gson;
import data.model.Cart;
import data.model.Product;
import data.model.User;
import io.reactivex.rxjava3.core.Single;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class Api {

    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();

    private final Request cartsRequest = buildRequest("https://fakestoreapi.com/carts");
    private final Request usersRequest = buildRequest("https://fakestoreapi.com/users");
    private final Request productsRequest = buildRequest("https://fakestoreapi.com/products");

    public Single<List<User>> fetchUsers(){
        return Single.create(emitter -> {
            ResponseBody response = client.newCall(usersRequest).execute().body();
            if (response == null){
                emitter.onError(new NullPointerException());
                return;
            }

            Type listType = new TypeToken<List<User>>(){}.getType();
            List<User> users = gson.fromJson(response.string(),listType);

            emitter.onSuccess(users);
        });
    };
    
    public Single<List<Cart>> fetchCarts(){
        return Single.create(emitter -> {
            
            ResponseBody response = client.newCall(cartsRequest).execute().body();
            if (response == null){
                emitter.onError(new NullPointerException());
                return;
            }

            Type listType = new TypeToken<List<Cart>>(){}.getType();
            List<Cart> carts = gson.fromJson(response.string(),listType);

            emitter.onSuccess(carts);
        });
    }

    public Single<List<Product>> fetchProducts(){
        return Single.create(emitter -> {

            ResponseBody response = client.newCall(productsRequest).execute().body();
            if (response == null){
                emitter.onError(new NullPointerException());
                return;
            }
            Type listType = new TypeToken<List<Product>>(){}.getType();
            List<Product> products = gson.fromJson(response.string(),listType);

            emitter.onSuccess(products);
        });
    }

    private Request buildRequest(String url){
        return new Request.Builder()
                .url(url)
                .build();
    }
}
