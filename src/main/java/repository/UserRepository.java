package repository;

import java.util.List;

public class UserRepository<User> implements Repository<User>{
    @Override
    public int add(User user) {
        return 0;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
