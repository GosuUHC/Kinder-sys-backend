package backend.service.user.interfaces.in;

import java.util.List;

import backend.service.user.dto.UserDTO;
import backend.service.user.interfaces.out.repository.IUserRepository;

public interface IUserService {

    void saveUser(UserDTO dto);

    void deleteUser(UserDTO dto);

    UserDTO findUserById(Long id);

    List<UserDTO> findAllUsers();

    public void injectUserRepository(IUserRepository userRepository);
}