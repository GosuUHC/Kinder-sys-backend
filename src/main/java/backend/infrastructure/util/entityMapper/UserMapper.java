package backend.infrastructure.util.entityMapper;

import backend.infrastructure.out.repository.db.user.EUser;
import backend.service.user.dto.UserDTO;

public class UserMapper {

    public static UserDTO toDTO(EUser entity) {
        if (entity == null) {
            return null;
        }
        return new UserDTO(
                entity.getId(),
                entity.getLogin(),
                entity.getPassword(),
                entity.getRole());
    }

    public static EUser toEntity(UserDTO dto) {
        if (dto == null) {
            return null;
        }
        EUser entity = new EUser();
        entity.setId(dto.getId());
        entity.setLogin(dto.getLogin());
        entity.setPassword(dto.getPassword());
        entity.setRole(dto.getRole());
        return entity;
    }
}