package cc.mrbird.exam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cc.mrbird.common.annotation.Log;
import cc.mrbird.common.controller.BaseController;
import cc.mrbird.common.domain.QueryRequest;
import cc.mrbird.system.domain.User;
import cc.mrbird.system.service.UserService;
@Controller
public class ExamController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	@Log("题库管理")
	@RequestMapping("testBank")
	@RequiresPermissions("testBank:list")
	public String testBank() {
		return "exam/testBank";
	}
	
	@RequestMapping("exam/user/list")
	@ResponseBody
	public Map<String, Object> userList(QueryRequest request, User user) {
		PageHelper.startPage(request.getPageNum(), request.getPageSize());
		List<User> list = this.userService.findUserWithDept(user);
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		Map<String, Object> rspData = new HashMap<String, Object>();
		rspData.put("rows", pageInfo.getList());
		rspData.put("total", pageInfo.getTotal());
		return rspData;
	}
	@Log("在线测试")
	@RequestMapping("examOnline")
	@RequiresPermissions("examOnline:do")
	public String examOnline() {
		return "exam/examOnline";
	}
}
