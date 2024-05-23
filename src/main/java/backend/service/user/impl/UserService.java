package backend.service.user.impl;

import java.util.List;

import backend.service.user.dto.UserDTO;
import backend.service.user.interfaces.in.IUserService;
import backend.service.user.interfaces.out.repository.IUserRepository;

public class UserService implements IUserService {

    private IUserRepository userRepository;

    @Override
    public void saveUser(UserDTO dto) {
        userRepository.save(dto);
    }

    @Override
    public void deleteUser(UserDTO dto) {
        userRepository.delete(dto);
    }

    @Override
    public UserDTO findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserDTO> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void injectUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO checkUser(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password);
    }
}
