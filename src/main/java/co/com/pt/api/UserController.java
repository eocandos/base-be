package co.com.pt.api;

import co.com.pt.entity.Offer;
import co.com.pt.entity.User;
import co.com.pt.enums.UserStateEnum;
import co.com.pt.security.JWT.JwtProvider;
import co.com.pt.service.UserService;
import co.com.pt.vo.request.LoginForm;
import co.com.pt.vo.response.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@CrossOrigin(origins = "https://sapp.com.co")
public class UserController {

    @Autowired
    UserService userService;


    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginForm loginForm) {
        // throws Exception if authentication failed

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generate(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            User user = userService.findOne(userDetails.getUsername());

            return ResponseEntity.ok(new JwtResponse(jwt, user.getId(), user.getEmail(), user.getName(), user.getRole()));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody User user,
                                   BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult);
        }

        try {
            // user.setState(UserStateEnum.NEW);register
            user.setActive(false);
            user.setRole("ROLE_CLIENT");
            return ResponseEntity.ok(userService.save(user));
        } catch (Exception e) {
            // return ResponseEntity.badRequest().build();
            return new ResponseEntity<>("¡Ya existe un usuario con este correo!", HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/users")
    public Page<User> userList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                               @RequestParam(value = "size", defaultValue = "10") Integer size,
                               Authentication authentication) {
        PageRequest request = PageRequest.of(page - 1, size);
        Page<User> userPage = null;
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_MANAGER"))) {
            userPage = userService.findAll(request);
        }

        return userPage;
    }

    @PutMapping("/user/{id}/edit") // do not work
    public ResponseEntity update(@PathVariable("id") Long userId,
                                 @RequestBody User user,
                                 BindingResult bindingResult,
                                 Authentication authentication) {
        user.setId(userId);
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult);
        }
        return ResponseEntity.ok(userService.update(user));
    }

    /*
    @PutMapping("/profile")
    public ResponseEntity<User> update(@RequestBody User user, Principal principal) {

        try {
            if (!principal.getName().equals(user.getEmail())) throw new IllegalArgumentException();
            return ResponseEntity.ok(userService.update(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }*/

    @GetMapping("/profile/{email}")
    public ResponseEntity<User> getProfile(@PathVariable("email") String email, Principal principal) {
        if (principal.getName().equals(email)) {
            return ResponseEntity.ok(userService.findOne(email));
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    @PatchMapping("/user/{id}/lock")
    public ResponseEntity lock(@PathVariable("id") Long userId, Authentication authentication) {
        if (!authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_MANAGER"))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(userService.lock(userId));
    }

    @PatchMapping("/user/{id}/unlock")
    public ResponseEntity unLock(@PathVariable("id") Long userId, Authentication authentication) {
        if (!authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_MANAGER"))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(userService.unLock(userId));
    }
}
