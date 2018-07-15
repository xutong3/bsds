package cc.mrbird.bsds.controller;
import cc.mrbird.bsds.domain.RecordSheet;
import cc.mrbird.bsds.service.IRecordSheetService;
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
public class RecordSheetController  extends BaseController {
    @Autowired
    private IRecordSheetService sheetService;
    @RequestMapping("recordSheet")
    @RequiresPermissions("recordSheet:list")
    public String recordSheet(Model model) {
        User user = super.getCurrentUser();
        model.addAttribute("user", user);
        return "bsds/record/recordSheet";
    }
    @RequestMapping("recordSheet/list")
    @ResponseBody
    public Map<String, Object> recordSheetList(QueryRequest request, RecordSheet recordSheet) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<RecordSheet> list = this.sheetService.findRecordSheet(recordSheet);
        PageInfo<RecordSheet> pageInfo = new PageInfo<RecordSheet>(list);
        return getDataTable(pageInfo);
    }
}
