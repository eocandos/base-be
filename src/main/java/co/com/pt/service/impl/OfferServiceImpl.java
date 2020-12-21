package co.com.pt.service.impl;

import co.com.pt.entity.Offer;
import co.com.pt.entity.Project;
import co.com.pt.entity.User;
import co.com.pt.enums.OfferStatusForManagerEnum;
import co.com.pt.enums.OfferStatusForUserEnum;
import co.com.pt.enums.ResultEnum;
import co.com.pt.exception.MyException;
import co.com.pt.repository.OfferRepository;
import co.com.pt.repository.ProjectRepository;
import co.com.pt.repository.UserRepository;
import co.com.pt.service.OfferService;
import co.com.pt.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    OfferRepository offerRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ProjectService projectService;

    @Override
    public Page<Offer> findAll(Pageable pageable) {
        return offerRepository.findAllByOrderByUpdateTimeDescOfferStatusForUserDesc(pageable);
    }

    @Override
    public Page<Offer> findByStatus(OfferStatusForUserEnum status, Pageable pageable) {
        return offerRepository.findAllByOrderByUpdateTimeDescOfferStatusForUser(status, pageable);
    }

    @Override
    public Page<Offer> findByProviderEmail(String email, Pageable pageable) {
        return offerRepository.findAllByProviderEmailOrderByUpdateTimeDesc(email, pageable);
    }

    @Override
    public Page<Offer> findByProviderPhone(String phone, Pageable pageable) {
        return offerRepository.findAllByProviderPhoneOrderByUpdateTimeDesc(phone, pageable);
    }

    @Override
    public Optional<Offer> findByProjectAndProvider(Project project, User user) {
        return offerRepository.findByProjectAndProvider(project, user);
    }

    @Override
    public Offer findOne(Long offerId) {
        Offer offer = offerRepository.findByOfferId(offerId);
        if(offer == null) {
            throw new MyException(ResultEnum.OFFER_NOT_FOUND);
        }
        return offer;
    }

    @Override
    @Transactional
    public Offer activate(Long offerId) {
        Offer offer = findOne(offerId);
        offer.setOfferStatusForUser(OfferStatusForUserEnum.ACTIVE);
        return offerRepository.save(offer);
        // return offerRepository.findByOfferId(offerId);
    }

    @Override
    @Transactional
    public Offer lock(Long offerId) {
        Offer offer = findOne(offerId);
        offer.setOfferStatusForManager(OfferStatusForManagerEnum.LOCKED);
        return offerRepository.save(offer);
        // return offerRepository.findByOfferId(offerId);
    }

    @Override
    @Transactional
    public Offer unlock(Long offerId) {
        Offer offer = findOne(offerId);
        offer.setOfferStatusForManager(OfferStatusForManagerEnum.UNLOCKED);
        return offerRepository.save(offer);
        // return offerRepository.findByOfferId(offerId);
    }

    @Override
    @Transactional
    public Offer review(Long offerId) {
        Offer offer = findOne(offerId);
        offer.setOfferStatusForManager(OfferStatusForManagerEnum.REVIEW);
        return offerRepository.save(offer);
        // return offerRepository.findByOfferId(offerId);
    }

    @Override
    @Transactional
    public Offer checked(Long offerId) {
        Offer offer = findOne(offerId);
        offer.setOfferStatusForManager(OfferStatusForManagerEnum.CHECKED);
        return offerRepository.save(offer);
        // return offerRepository.findByOfferId(offerId);
    }

    @Override
    @Transactional
    public Offer delete(Long offerId) {
        Offer offer = findOne(offerId);
        offer.setOfferStatusForManager(OfferStatusForManagerEnum.DELETED);
        return offerRepository.save(offer);
        // return offerRepository.findByOfferId(offerId);
    }

    @Override
    @Transactional
    public Offer cancel(Long offerId) {
        Offer offer = findOne(offerId);
        offer.setOfferStatusForUser(OfferStatusForUserEnum.CANCELED);
        offerRepository.save(offer);
        return offerRepository.findByOfferId(offerId);
    }

    @Override
    public Offer save(Offer offer) {
        return offerRepository.save(offer);
    }
}
