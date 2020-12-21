package co.com.pt.service.impl;

import co.com.pt.entity.Message;
import co.com.pt.entity.Project;
import co.com.pt.entity.User;
import co.com.pt.enums.AnswerStateEnum;
import co.com.pt.enums.MessageNotifyEnum;
import co.com.pt.enums.QuestionStateEnum;
import co.com.pt.repository.MessageRepository;
import co.com.pt.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Override
    public Message findOne(Long id) {
        return messageRepository.findByMessageId(id);
    }

    @Override
    public Page<Message> findAll(Pageable pageable) {
        return messageRepository.findAllByOrderByUpdateDateDesc(pageable);
    }

    @Override
    public Page<Message> findByClient(User client, Pageable pageable) {
        return messageRepository.findByClientAndQuestionStateOrderByUpdateDateDesc(client, QuestionStateEnum.APPROVED, pageable);
        // return messageRepository.findByClientOrderByUpdateDateDesc(client, pageable);
    }

    @Override
    public Page<Message> findByProvider(User provider, Pageable pageable) {
        return messageRepository.findByProviderOrderByUpdateDateDesc(provider, pageable);
        // return messageRepository.findByClientAndQuestionStateOrderByUpdateDateDesc(provider, AnswerStateEnum.UN_ANSWERED, pageable);
        // return messageRepository.findByProviderAndNotify(provider, MessageNotifyEnum.SOLVED, pageable);
    }

    @Override
    public Page<Message> findByProject(Project project, Pageable pageable) {
        return messageRepository.findByProjectOrderByUpdateDateDesc(project, pageable);
    }

    @Override
    public Page<Message> findByProjectAndProvider(Project project, User provider, Pageable pageable) {
        return messageRepository.findByProjectAndProvider(project, provider, pageable);
    }

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }

    @Override
    @Transactional
    public Message approveQuestion(Long messageId) {
        Message message = findOne(messageId);
        if (message != null) {
            message.setQuestionState(QuestionStateEnum.APPROVED);
            return messageRepository.save(message);
        }
        return message;
    }

    @Override
    @Transactional
    public Message notApproveQuestion(Long messageId) {
        Message message = findOne(messageId);
        if (message != null) {
            message.setQuestionState(QuestionStateEnum.NOT_APPROVED);
            return messageRepository.save(message);
        }
        return message;
    }

    @Override
    @Transactional
    public Message approveAnswer(Long messageId) {
        Message message = findOne(messageId);
        if (message != null) {
            message.setAnswerState(AnswerStateEnum.APPROVED);
            return messageRepository.save(message);
        }
        return message;
    }

    @Override
    @Transactional
    public Message notApproveAnswer(Long messageId) {
        Message message = findOne(messageId);
        if (message != null) {
            message.setNotify(MessageNotifyEnum.RELAUNCHED);
            message.setAnswerState(AnswerStateEnum.NOT_APPROVED);
            return messageRepository.save(message);
        }
        return message;
    }

}
