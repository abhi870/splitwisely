package repository;

import model.Group;

public interface GroupRepository {
    Group findById(String groupId);

    Group save(Group group);
}
