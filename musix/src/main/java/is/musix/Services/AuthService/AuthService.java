package is.musix.Services.AuthService;

import is.musix.Entities.User;
import is.musix.Repositories.UserRepository.UserRepository;
import is.musix.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public AuthService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }

    public UserDto authenticateUser() {
        return null;
    }

    public void logoutUser() {

    }


}
