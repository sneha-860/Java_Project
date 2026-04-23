package dao;

import beans.User;

public class TestUser {

    public static void main(String[] args) {

        User user = new User();

        user.setName("Sneha");
        user.setEmail("sneha@gmail.com");
        user.setPassword("123");

        UserDAO dao = new UserDAO();
        dao.saveUser(user);
    }
}