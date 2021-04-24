package c1020g1.social_network.repository;

import c1020g1.social_network.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import c1020g1.social_network.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

    @Query("select gr from Group gr")
    List<Group> findAllGroup();

    @Query("select gr from Group gr where gr.groupId=?1")
    Group findGroupById(Integer id);

    @Query("select gr from Group gr where gr.groupName like %?1%")
    List<Group> findGroupByGroupNameContaining(String name);

    @Query("delete from Group gr where gr.groupId = ?1")
    Group removeGroupById(Integer id);

    @Modifying
    @Query(" UPDATE Group gr set gr.scope = ?3, gr.imageAvatarUrl= ?2," +
            " gr.imageBackground= ?1 where gr.groupId = ?4")
    void updateGroup(String imageBackground, String imageAvatarUrl, String scope ,Integer groupId);

    @Query(value = "select * from `group_social` where group_id = :id",nativeQuery = true)
    Group findByGroupId(@Param("id") int id);
}
