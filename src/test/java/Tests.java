import data.Api;
import org.junit.jupiter.api.Test;

public class Tests {
    @Test
    public void fetchedUserListIsNotEmpty(){
        Api api = new Api();
        var users = api.fetchUsers().blockingGet();
        assert users.size() > 0;
    }
}
