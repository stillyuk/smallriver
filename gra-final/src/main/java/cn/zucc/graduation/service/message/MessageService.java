package cn.zucc.graduation.service.message;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zucc.graduation.entity.Message;
import cn.zucc.graduation.repository.MessageDao;

@Service
@Transactional
public class MessageService {

	@Autowired
	private MessageDao messageDao;

	public Message save(Message message) {
		return messageDao.save(message);
	}

	public List<Message> findMessagesByReceiveIdAndUnRead(Long receiveId) {
		return messageDao.findMessagesByReceiveIdAndUnRead(receiveId);
	}

	public Message getMessage(Long messageId) {
		return messageDao.findOne(messageId);
	}

	public void update(Message message) {
		messageDao.save(message);
	}

	public List<Message> getMessagesByReceiveId(Long receiveId) {
		return messageDao.getMessagesByReceiveId(receiveId);
	}

	public List<Message> getMessagesBySendId(Long senderId) {
		return messageDao.getMessagesBySendId(senderId);
	}
}
