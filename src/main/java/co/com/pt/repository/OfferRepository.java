package co.com.pt.repository;


import co.com.pt.entity.Offer;
import co.com.pt.entity.Project;
import co.com.pt.entity.User;
import co.com.pt.enums.OfferStatusForUserEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface OfferRepository extends JpaRepository<Offer, Integer> {


    Offer findByOfferId(Long offerId);

    Optional<Offer> findByProjectAndProvider(Project project, User user);

    Page<Offer> findAllByOrderByUpdateTimeDescOfferStatusForUser(OfferStatusForUserEnum offerStatus, Pageable pageable);

    Page<Offer> findAllByProviderEmailOrderByUpdateTimeDesc(String ProviderEmail, Pageable pageable);
    // Page<Offer> findAllByProviderEmailOrderByUpdateTimeDescOfferStatusForUserDesc(String ProviderEmail, Pageable pageable);

    Page<Offer> findAllByOrderByUpdateTimeDescOfferStatusForUserDesc(Pageable pageable);

    Page<Offer> findAllByProviderPhoneOrderByUpdateTimeDesc(String ProviderPhone, Pageable pageable);
    // Page<Offer> findAllByProviderPhoneOrderByUpdateTimeDescOfferStatusForUserDesc(String ProviderPhone, Pageable pageable);

    Offer save(Offer offer);

}
