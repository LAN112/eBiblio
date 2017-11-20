package pl.edu.zut.rest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pl.edu.zut.models.User;
import pl.edu.zut.services.UserService;
import pl.edu.zut.services.specifications.UserSpecifications;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/")
    public ResponseEntity<List<User>> getAllUsers() throws URISyntaxException {
        List<User> users = userService.findAll(Specifications.where(null));

        return Optional.ofNullable(users)
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {

        return userService.findOne(UserSpecifications.withId(id))
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/user/")
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {

        if (userService.findOne(UserSpecifications.withLogin(user.getLogin())).isPresent()) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        userService.save(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {

        Optional <User> userOptional = userService.findOne(UserSpecifications.withId(id));

        if (!userOptional.isPresent()) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        if (userService.findOne(UserSpecifications.withLogin(user.getLogin())).isPresent()) {
            return new ResponseEntity<User>(HttpStatus.CONFLICT);
        }

        User currentUser = userOptional.get();

        currentUser.setLogin(user.getLogin());
        currentUser.setPassword(user.getPassword());
        currentUser.setName(user.getName());
        currentUser.setSurname(user.getSurname());
        currentUser.setEmail(user.getEmail());
        currentUser.setPhoneNumber(user.getPhoneNumber());

        userService.save(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {

        if (!userService.findOne(UserSpecifications.withId(id)).isPresent()) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        userService.delete(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
}