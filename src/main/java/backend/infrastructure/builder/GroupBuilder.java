package backend.infrastructure.builder;

import backend.service.group.interfaces.in.IGroupService;
import backend.service.group.interfaces.out.IGroupRepository;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

public class GroupBuilder {

    @Inject
    @Default
    private IGroupRepository groupRepository;

    @Inject
    @Default
    private IGroupService groupService;

    @Produces
    @Built
    public IGroupService buildGroupService() {
        groupService.injectGroupRepository(groupRepository);
        return groupService;
    }
}
