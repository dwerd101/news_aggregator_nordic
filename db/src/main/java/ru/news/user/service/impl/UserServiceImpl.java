package ru.news.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.news.user.model.User;
import ru.news.user.repository.UserRepository;
import ru.news.user.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user, Long aLong) {
        user.setId(aLong);
        return userRepository.save(user);
    }

    @Override
    public User delete(Long aLong) {
        userRepository.deleteById(aLong);
        return User.builder()
                .id(aLong)
                .build();
    }
}

