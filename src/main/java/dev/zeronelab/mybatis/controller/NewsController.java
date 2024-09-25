package dev.zeronelab.mybatis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.zeronelab.mybatis.dao.DeptMapper;
import dev.zeronelab.mybatis.dao.NewsMapper;
import dev.zeronelab.mybatis.vo.DeptEntity;
import dev.zeronelab.mybatis.vo.NewsEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

	private Logger logger = LoggerFactory.getLogger(NewsController.class);

	@Autowired
	private NewsMapper newDAO;
	
	@Autowired
	private DeptMapper deptMapper;

	@RequestMapping("/home")
	public Map<String, String> home() {
		System.out.println("/*** home running2...");

		Map<String, String> rtnObj = new HashMap<>();
		rtnObj.put("home", "This is a home page.");
		return rtnObj;
	}

	@RequestMapping("/api/news")
	public @ResponseBody Map<String, Object> news() throws Exception {
		Map<String, Object> rtnObj = new HashMap<>();

		List<NewsEntity> newsList = newDAO.listNews();
		logger.info("news->" + newsList.toString());

		rtnObj.put("newsList", newsList);
		return rtnObj;
	}

	@RequestMapping("/api/dept")
	public @ResponseBody Map<String, Object> dept() {
		Map<String, Object> rtnObj = new HashMap<>();

		List<DeptEntity> deptList = deptMapper.listDept();

		rtnObj.put("deptList", deptList);
		return rtnObj;
	}

	@RequestMapping("/news")
	public String news(Model model) {
		List<NewsEntity> list = newDAO.listNews();
		model.addAttribute("list", list);
		return "news";
	}
	
	@RequestMapping("/dept")
	public String dept(Model model) {
		List<DeptEntity> list = deptMapper.listDept();
		model.addAttribute("list", list);
		return "dept";
	}
}
