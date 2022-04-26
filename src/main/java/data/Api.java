package data;

import com.google.gson.Gson;
import data.model.Cart;
import data.model.User;
import io.reactivex.rxjava3.core.Single;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

import java.util.List;

public class Api {

    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();

    private final Request cartsRequest = new Request.Builder()
            .url("https://fakestoreapi.com/carts")
            .build();
    private final Request usersRequest = new Request.Builder()
            .url("https://fakestoreapi.com/users")
            .build();

    public Single<List<User>> fetchUsers(){
        return Single.create(emitter -> {
            ResponseBody response = client.newCall(usersRequest).execute().body();
            if (response == null){
                emitter.onError(new NullPointerException());
                return;
            }

            List<User> users = (List<User>) gson.fromJson(response.string(),List.class);

            emitter.onSuccess(users);
        });
    };
    
    public Single<List<Cart>> fetchCards(){
        return Single.create(emitter -> {
            
            ResponseBody response = client.newCall(cartsRequest).execute().body();
            if (response == null){
                emitter.onError(new NullPointerException());
                return;
            }

            List<Cart> carts = (List<Cart>) gson.fromJson(response.string(),List.class);

            emitter.onSuccess(carts);
        });
    }
}
