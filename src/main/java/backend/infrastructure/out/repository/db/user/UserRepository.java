package backend.infrastructure.out.repository.db.user;

import java.util.List;
import java.util.stream.Collectors;

import backend.infrastructure.util.entityMapper.UserMapper;
import backend.service.user.dto.UserDTO;
import backend.service.user.interfaces.out.repository.IUserRepository;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class UserRepository implements IUserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(UserDTO dto) {
        EUser entity = UserMapper.toEntity(dto);
        entityManager.persist(entity);
    }

    @Override
    public void delete(UserDTO dto) {
        EUser entity = UserMapper.toEntity(dto);
        entityManager.remove(entity);
    }

    @Override
    public UserDTO findById(Long id) {
        EUser entity = entityManager.find(EUser.class, id);
        return UserMapper.toDTO(entity);
    }

    @Override
    public List<UserDTO> findAll() {
        List<EUser> entities = entityManager.createQuery("SELECT u FROM EUser u", EUser.class)
                .getResultList();
        return entities.stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

}
