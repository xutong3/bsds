package cc.mrbird.bsds.controller;
import cc.mrbird.bsds.domain.RecordApply;
import cc.mrbird.bsds.domain.RecordSheet;
import cc.mrbird.bsds.service.IRecordApplyService;
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
public class RecordApplyController extends BaseController {
    @Autowired
    private IRecordApplyService applyService;
    @RequestMapping("recordApply")
    @RequiresPermissions("recordApply:list")
    public String recordApply(Model model) {
        User user = super.getCurrentUser();
        model.addAttribute("user", user);
        return "bsds/record/recordApply";
    }
    @RequestMapping("recordApply/list")
    @ResponseBody
    public Map<String, Object> recordApplyList(QueryRequest request, RecordApply recordApply) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<RecordApply> list = this.applyService.findRecordSheet(recordApply);
        PageInfo<RecordApply> pageInfo = new PageInfo<RecordApply>(list);
        return getDataTable(pageInfo);
    }
}
