package cn.zucc.graduation.web.group;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zucc.graduation.core.MessageType;
import cn.zucc.graduation.entity.Group;
import cn.zucc.graduation.entity.Message;
import cn.zucc.graduation.entity.User;
import cn.zucc.graduation.service.acount.AccountService;
import cn.zucc.graduation.service.acount.ShiroDbRealm.ShiroUser;
import cn.zucc.graduation.service.group.GroupService;
import cn.zucc.graduation.service.message.MessageService;
import cn.zucc.graduation.web.shiro.ShiroUserUtil;

@Controller
@RequestMapping("/group")
public class JoinGroupController {

	@Autowired
	private GroupService groupService;
	@Autowired
	private AccountService accountService;
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
		message.setDate(new Date());
		message.setMessageFromType(MessageType.SYSTEM);
		message.setMessageToType(MessageType.ADD_GROUP);
		messageService.save(message);
		boolean isMember = groupService.isGroupMemberQueryByUserId(groupId, ShiroUserUtil.getCurrentUserId());
		model.addAttribute("group", group);
		model.addAttribute("message", "申请消息已发送");
		model.addAttribute("isMember", isMember);
		return "group/groupDetail";
	}

	@RequestMapping("/handler")
	public void handler(Long toId, String choice, Long messageId, Model model) {
		Message message = messageService.getMessage(messageId);
		String content = message.getContent();
		String groupName = null;
		Pattern p = Pattern.compile("申请加入群(.+)");
		Matcher m = p.matcher(content);
		while (m.find()) {
			groupName = m.group(1);
		}
		Group group = groupService.getGroupByGroupName(groupName);
		User to = new User(toId);
		group.getUsers().add(to);
		groupService.save(group);
		message.setIsRead(true);
		messageService.save(message);
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
