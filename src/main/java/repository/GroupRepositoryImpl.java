package repository;

import model.Group;

import java.util.Map;

public class GroupRepositoryImpl implements GroupRepository {
    private Map<String, Group> groups;

    @Override
    public Group findById(String groupId) {
        return groups.get(groupId);
    }

    @Override
    public Group save(Group group) {
        return groups.put(group.getId(), group);
    }
}
