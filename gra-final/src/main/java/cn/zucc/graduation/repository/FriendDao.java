package cn.zucc.graduation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.zucc.graduation.entity.Friend;

public interface FriendDao extends PagingAndSortingRepository<Friend, Long>, JpaSpecificationExecutor<Friend> {

	@Modifying
	@Query("select f from Friend f join f.from u where u.id=?1")
	public List<Friend> findFriendsByUserId(Long userId);

	@Modifying
	@Query("select f from Friend f join f.from u join f.to t where u.id=?1 and t.id=?2")
	public List<Friend> querybyFromAndTo(Long fromUserId, Long toUserId);
}
