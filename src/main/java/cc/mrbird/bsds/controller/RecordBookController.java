package cc.mrbird.bsds.controller;

import cc.mrbird.bsds.domain.RecordBook;
import cc.mrbird.bsds.service.IRecordBookService;
import cc.mrbird.common.controller.BaseController;
import cc.mrbird.common.domain.QueryRequest;
import cc.mrbird.system.domain.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class RecordBookController extends BaseController {
    @Autowired
    private IRecordBookService bookService;

    @RequestMapping("recordBook")
    @RequiresPermissions("recordBook:list")
    public String recordBook(Model model) {
        User user = super.getCurrentUser();
        model.addAttribute("user", user);
        return "bsds/record/recordBook";
    }

    @RequestMapping("recordBook/list")
    @ResponseBody
    public Map<String, Object> recordBookList(QueryRequest request, RecordBook recordBook) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<RecordBook> list = this.bookService.findRecordBook(recordBook);
        PageInfo<RecordBook> pageInfo = new PageInfo<RecordBook>(list);
        return getDataTable(pageInfo);
    }
}
