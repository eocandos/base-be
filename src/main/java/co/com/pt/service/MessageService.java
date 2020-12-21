package co.com.pt.service;

import co.com.pt.entity.Message;
import co.com.pt.entity.Project;
import co.com.pt.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MessageService {

    Message findOne(Long id);

    Message approveQuestion(Long id);

    Message notApproveQuestion(Long id);

    Message approveAnswer(Long id);

    Message notApproveAnswer(Long id);

    Page<Message> findAll(Pageable pageable);

    // Questions
    Page<Message> findByClient(User client, Pageable pageable);

    // Answers
    Page<Message> findByProvider(User client, Pageable pageable);

    Page<Message> findByProject(Project project, Pageable pageable);

    Page<Message> findByProjectAndProvider(Project project, User provider, Pageable pageable);

    Message save(Message message);
}
