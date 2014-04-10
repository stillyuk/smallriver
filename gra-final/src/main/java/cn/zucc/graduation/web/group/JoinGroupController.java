package cn.zucc.graduation.web.group;

import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zucc.graduation.entity.Group;
import cn.zucc.graduation.entity.Message;
import cn.zucc.graduation.entity.User;
import cn.zucc.graduation.service.acount.ShiroDbRealm.ShiroUser;
import cn.zucc.graduation.service.group.GroupService;
import cn.zucc.graduation.service.message.MessageService;

@Controller
@RequestMapping("/group")
public class JoinGroupController {

	@Autowired
	private GroupService groupService;

	@Autowired
	private MessageService messageService;

	@RequestMapping("/joinGroup")
	public String joinGroup(Long groupId, Model model) {
		Group group = groupService.findManagerByGroupId(groupId);
		Message message = new Message();
		User from = new User();
		from.setId(getCurrentUserId());
		message.setFrom(from);
		message.setTo(group.getManager());
		message.setContent(getCurrentUserName() + "申请加入群" + group.getGroupName());
		message.setMessageDate(new Date());
		messageService.save(message);
		return "group/allGroups";
	}

	private Long getCurrentUserId() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.getId();
	}

	private String getCurrentUserName() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.getLoginName();
	}
}
