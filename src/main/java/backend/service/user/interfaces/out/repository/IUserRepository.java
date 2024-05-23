package backend.service.user.interfaces.out.repository;

import java.util.List;

import backend.service.user.dto.UserDTO;

public interface IUserRepository {

    void save(UserDTO dto);

    void delete(UserDTO dto);

    UserDTO findById(Long id);

    UserDTO findByLoginAndPassword(String login, String password);

    List<UserDTO> findAll();
}