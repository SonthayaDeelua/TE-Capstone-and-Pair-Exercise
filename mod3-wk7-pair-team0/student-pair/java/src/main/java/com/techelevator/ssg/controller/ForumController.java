package com.techelevator.ssg.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.ssg.model.forum.ForumDao;
import com.techelevator.ssg.model.forum.ForumPost;

@Controller
public class ForumController {
	
	@Autowired 
	private ForumDao forumDao;
	
	@RequestMapping("/forum")
	public String getForumDisplay(ModelMap map) {
		List <ForumPost> postList = forumDao.getAllPosts();
		map.put("posts", postList);
		
		DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");
		for(ForumPost post: postList) {
			String date = post.getDatePosted().format(formatterDate);
			String time = post.getDatePosted().format(formatterTime);
			post.setPostDate(date);
			post.setPostTime(time);
		}
		
		return "forum";

	}
	
	
	@RequestMapping(path="/postAForum", method=RequestMethod.GET)
	public String postAForumDisplay() {
		return "postAForum";
	}
	
	@RequestMapping(path="/postAForum", method=RequestMethod.POST)
	public String processForum(@RequestParam String userName,
								@RequestParam String subject,
								@RequestParam String message) {
		ForumPost post = new ForumPost();
		post.setUsername(userName);
		post.setSubject(subject);
		post.setMessage(message);
		post.setDatePosted(LocalDateTime.now());
		forumDao.save(post);
		
		return "redirect:/forum";
		
	}
	
	
	
}
