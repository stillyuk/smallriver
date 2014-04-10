package cn.zucc.graduation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.zucc.graduation.entity.Message;

public interface MessageDao extends PagingAndSortingRepository<Message, Long>, JpaSpecificationExecutor<Message> {

	@Query("select m from Message m join m.to t on t.id = ?1 where m.isRead = 0")
	List<Message> findMessagesByReceiveIdAndUnRead(Long receiveId);

	@Query("select m from Message m join m.to t on t.id = ?1")
	List<Message> getMessagesByReceiveId(Long receiveId);

	@Query("select m from Message m join m.from t on t.id = ?1")
	List<Message> getMessagesBySendId(Long senderId);

}
