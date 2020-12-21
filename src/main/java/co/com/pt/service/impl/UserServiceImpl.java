package co.com.pt.service.impl;


import co.com.pt.entity.User;
import co.com.pt.enums.ResultEnum;
import co.com.pt.exception.MyException;
import co.com.pt.repository.UserRepository;
import co.com.pt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
@DependsOn("passwordEncoder")
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
    // @Autowired
    // FavoriteRepository favoriteRepository;

    @Override
    public User findByUserId(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findOne(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Collection<User> findByRole(String role) {
        return userRepository.findAllByRole(role);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAllByOrderByUpdateTimeDesc(pageable);
    }

    @Override
    @Transactional
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try {
            User savedUser = userRepository.save(user);
            return userRepository.save(savedUser);

        } catch (Exception e) {
            throw new MyException(ResultEnum.VALID_ERROR);
        }
    }

    @Override
    @Transactional
    public User update(User user) {
        try {
            User savedUser = userRepository.save(user);
            return userRepository.save(savedUser);

        } catch (Exception e) {
            throw new MyException(ResultEnum.VALID_ERROR);
        }
    }

    /*
    @Override
    @Transactional
    public User lock(Long userId) {
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new MyException(ResultEnum.USER_NOT_FOUNT);
        }
        user.setActive(false);
        return save(user);
    }*/

    @Override
    @Transactional
    public User lock(Long userId) {
        User user = userRepository.findById(userId);
        if (user == null) throw new MyException(ResultEnum.USER_NOT_FOUNT);
        user.setActive(false);
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User unLock(Long userId) {
        User user = userRepository.findById(userId);
        if (user == null) throw new MyException(ResultEnum.USER_NOT_FOUNT);
        user.setActive(true);
        return userRepository.save(user);
    }
}
