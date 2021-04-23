package c1020g1.social_network.service;

import c1020g1.social_network.model.User;

import java.util.List;

public interface UserService {
    void updateStatus(Integer userId, Integer statusId);

    List<User> listUsers();

    User findUserById(Integer id);

    void updateAvatar(Integer userId, String image);

    void updateBackground(Integer userId, String background);
}
