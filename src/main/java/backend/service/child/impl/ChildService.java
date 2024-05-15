package backend.service.child.impl;

import java.util.List;

import backend.service.child.dto.ChildDTO;
import backend.service.child.interfaces.in.IChildService;
import backend.service.child.interfaces.out.IChildRepository;

public class ChildService implements IChildService {

    private IChildRepository childRepository;

    @Override
    public List<ChildDTO> findChildrenByGroupId(Long groupId) {
        return childRepository.findChildrenByGroupId(groupId);
    }

    @Override
    public void injectChildRepository(IChildRepository childRepository) {
        this.childRepository = childRepository;
    }

}
