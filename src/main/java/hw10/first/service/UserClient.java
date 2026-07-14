package hw10.first.service;

import hw10.first.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class UserClient {

    private final RestClient restClient;
    public UserClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public User getUser(Integer id) {
        return restClient
                .get()
                .uri("http://localhost:8099/users/find/id/{id}", id)
                .retrieve()
                .body(User.class);
    }

}
