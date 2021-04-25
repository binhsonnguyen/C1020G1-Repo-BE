package c1020g1.social_network.controller;

import c1020g1.social_network.model.User;
import c1020g1.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import c1020g1.social_network.model.*;
import c1020g1.social_network.model.dto.UserCreateDTO;
import c1020g1.social_network.model.dto.UserResultMessageDTO;
import c1020g1.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;
    @PutMapping("/user/{idUser}/update/status/{idStatus}")
    public void updateStatus(@PathVariable("idUser") Integer idUser, @PathVariable("idStatus") Integer idStatus) {
        userService.updateStatus( idUser, idStatus );
    }

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable Integer id) {
        return userService.getUserById( id );
    }

    @PutMapping("/user/{idUser}/update/avatar")
    public void updateAvatar(@PathVariable("idUser") Integer idUser, @RequestParam("image")String image) {
        System.out.println(image);
        userService.updateAvatar( idUser, image );
    }

    @PutMapping("/user/{idUser}/update/background")
    public void updateBackground(@PathVariable("idUser") Integer idUser, @RequestParam("background")String image) {
        System.out.println(image);
        userService.updateBackground(idUser, image);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createUser(@RequestBody @Valid UserCreateDTO userCreateDTO, UriComponentsBuilder ucBuider) {
        User user = userService.createUser(userCreateDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuider.path("/user/detail/{id}").buildAndExpand(user.getUserId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public UserResultMessageDTO handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        UserResultMessageDTO result = new UserResultMessageDTO();
        result.setErrors(errors);
        result.setMessage("invalid_input");
        return result;
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int userId) {
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }
}
