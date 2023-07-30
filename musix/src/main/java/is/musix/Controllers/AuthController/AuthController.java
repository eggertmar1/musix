package is.musix.Controllers.AuthController;

import is.musix.Services.AuthService.AuthService;
import is.musix.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public UserDto registerUser(@RequestBody UserDto userDto) {
        return authService.createUser(userDto);
    }

    @PostMapping("/login")
    public UserDto authenticateUser() {
        return authService.authenticateUser();
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logoutUser() {
        // TODO: Best practice is to validate the user - then call the authservice to logout
        authService.logoutUser();
        return ResponseEntity.ok().build();

    }
}
