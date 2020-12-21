package co.com.pt.service;


import co.com.pt.entity.Offer;
import co.com.pt.entity.Project;
import co.com.pt.entity.User;
import co.com.pt.enums.OfferStatusForUserEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface OfferService {
    Page<Offer> findAll(Pageable pageable);

    Page<Offer> findByStatus(OfferStatusForUserEnum status, Pageable pageable);

    Page<Offer> findByProviderEmail(String email, Pageable pageable);

    Page<Offer> findByProviderPhone(String phone, Pageable pageable);

    Offer findOne(Long offerId);

    Optional<Offer> findByProjectAndProvider(Project project, User user);

    // Offer finish(Long offerId);

    Offer activate(Long offerId);

    Offer lock(Long offerId);

    Offer unlock(Long offerId);

    Offer review(Long offerId);

    Offer checked(Long offerId);

    Offer cancel(Long offerId);

    Offer delete(Long offerId);

    Offer save(Offer offer);
}
