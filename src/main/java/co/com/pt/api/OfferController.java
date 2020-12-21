package co.com.pt.api;

import co.com.pt.entity.Offer;
import co.com.pt.entity.Project;
import co.com.pt.entity.User;
import co.com.pt.enums.OfferStatusForManagerEnum;
import co.com.pt.enums.OfferStatusForUserEnum;
import co.com.pt.service.OfferService;
import co.com.pt.service.ProjectService;
import co.com.pt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin
public class OfferController {

    @Autowired
    OfferService offerService;
    @Autowired
    UserService userService;
    @Autowired
    ProjectService projectService;

    /** ====================================== GET METHODS ============================================
     *  =============================================================================================== * */

    /**
     * Get Offers
     * @param page
     * @param size
     * @param authentication
     * @return
     */
    @GetMapping("/offer")
    public Page<Offer> offerList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                 @RequestParam(value = "size", defaultValue = "5") Integer size,
                                 Authentication authentication) {
        PageRequest request = PageRequest.of(page - 1, size);
        Page<Offer> offerPage = null;
        if (authentication != null) {
            if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CLIENT"))) {
                offerPage = offerService.findByProviderEmail(authentication.getName(), request);
            } else {
                if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_MANAGER"))) {
                    offerPage = offerService.findAll(request);
                }
            }
        }
        return offerPage;
    }

    /**
     * Get Offer by Id
     * @param offerId
     * @param authentication
     * @return
     */
    @GetMapping("/offer/{id}")
    public ResponseEntity show(@PathVariable("id") Long offerId, Authentication authentication) {
        boolean isClient = authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CLIENT"));
        boolean isManager = authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_MANAGER"));

        if (isClient || isManager) {
            Offer offer = offerService.findOne(offerId);
            return ResponseEntity.ok(offer);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    /** ====================================== POST METHODS============================================
     *  =============================================================================================== * */

    /**
     * Make new Offer
     * @param offer
     * @param bindingResult
     * @param authentication
     * @return
     */
    @PostMapping("/offer/new")
    public ResponseEntity makeOffer(@Valid @RequestBody Offer offer,
                                    BindingResult bindingResult,
                                    Authentication authentication) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult);
        }

        Project project = null;
        if(offer.getProject() != null) {
            project = projectService.findOne(offer.getProject().getProjectId());
        }

        if (authentication != null) {
            User user = userService.findOne(authentication.getName());
            if (project != null && user != null) {
                Optional<Offer> offers = offerService.findByProjectAndProvider(project, user);
                if (!offers.isPresent()) {
                    offer.setProvider(user);
                    offer.setProject(project);
                    offer.setOfferStatusForUser(OfferStatusForUserEnum.ACTIVE);
                    offer.setOfferStatusForManager(OfferStatusForManagerEnum.REVIEW);
                    return new ResponseEntity<>(offerService.save(offer), HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("¡Ya realizó una oferta a este Proyecto!", HttpStatus.CONFLICT);
                }
            }
        }
        return ResponseEntity.badRequest().body("¡Oferta no realizada!");
    }

    /** ====================================== PUT METHODS ============================================
     *  =============================================================================================== * */

    /**
     *  Edit Offer by Id
     * @param offerId
     * @param offer
     * @param bindingResult
     * @param authentication
     * @return
     */
    @PutMapping("/offer/{id}/edit")
    public ResponseEntity edit(@PathVariable("id") Long offerId,
                               @Valid @RequestBody Offer offer,
                               BindingResult bindingResult,
                               Authentication authentication) {

        offer.setOfferId(offerId);
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult);
        }
        if (!offerId.equals(offer.getOfferId())) {
            return ResponseEntity.badRequest().body("Id Not Matched");
        }
        if (authentication != null) {
            if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CLIENT"))) {
                User user = userService.findOne(authentication.getName());
                offer.setProvider(user);
                offer.setOfferStatusForManager(OfferStatusForManagerEnum.REVIEW);
            }
        }
        return ResponseEntity.ok(offerService.save(offer));
    }

    /** ====================================== PATCH METHODS ==========================================
     *  =============================================================================================== * */

    @PatchMapping("/offer/lock/{id}")
    public ResponseEntity<Offer> lock(@PathVariable("id") Long offerId, Authentication authentication) {
        if (authentication != null) {
            if (!authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_MANAGER"))) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }
        return ResponseEntity.ok(offerService.lock(offerId));
    }

    @PatchMapping("/offer/unlock/{id}")
    public ResponseEntity<Offer> unlock(@PathVariable("id") Long offerId, Authentication authentication) {
        if (authentication != null) {
            if (!authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_MANAGER"))) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }
        return ResponseEntity.ok(offerService.unlock(offerId));
    }

    @PatchMapping("/offer/review/{id}")
    public ResponseEntity<Offer> review(@PathVariable("id") Long offerId, Authentication authentication) {
        if (authentication != null) {
            if (!authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_MANAGER"))) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }
        return ResponseEntity.ok(offerService.review(offerId));
    }

    @PatchMapping("/offer/checked/{id}")
    public ResponseEntity<Offer> checked(@PathVariable("id") Long offerId, Authentication authentication) {
        if (authentication != null) {
            if (!authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_MANAGER"))) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }
        return ResponseEntity.ok(offerService.checked(offerId));
    }

    @PatchMapping("/offer/cancel/{id}")
    public ResponseEntity<Offer> cancel(@PathVariable("id") Long offerId, Authentication authentication) {
        if (authentication != null) {
            if (!authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CLIENT"))) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }
        return ResponseEntity.ok(offerService.cancel(offerId));
    }

    @PatchMapping("/offer/delete/{id}")
    public ResponseEntity<Offer> delete(@PathVariable("id") Long offerId, Authentication authentication) {
        if (authentication != null) {
            if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CLIENT")) ||
                    authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_MANAGER"))) {
                return ResponseEntity.ok(offerService.delete(offerId));
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
