package co.com.pt.service;


import co.com.pt.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;


public interface UserService {

    User findByUserId(Long id);

    User findOne(String email);

    Collection<User> findByRole(String role);

    User save(User user);

    User update(User user);

    Page<User> findAll(Pageable pageable);

    User lock(Long userId);

    User unLock(Long userId);
}
