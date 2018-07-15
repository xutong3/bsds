package cc.mrbird.bsds.service.impl;

import cc.mrbird.bsds.dao.RecordBookMapper;
import cc.mrbird.bsds.domain.RecordBook;
import cc.mrbird.bsds.domain.RecordSheet;
import cc.mrbird.bsds.service.IRecordBookService;
import cc.mrbird.bsds.service.IRecordSheetService;
import cc.mrbird.common.service.impl.BaseService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 75631 on 2018/7/14.
 */
@Service("recordSheetService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RecordSheetServiceImp extends BaseService<RecordSheet> implements IRecordSheetService {

    @Override
    public List<RecordSheet> findRecordSheet(RecordSheet recordSheet) {
        try {
            Example example = new Example(RecordSheet.class);
            Example.Criteria criteria = example.createCriteria();
            if (StringUtils.isNotBlank(recordSheet.getrType())){
                criteria.andEqualTo("rType",recordSheet.getrType());
            }
            if (StringUtils.isNotBlank(recordSheet.getrSolName())){
                criteria.andCondition("concat(R_CODE,R_SOL_NAME,R_POTENCY,R_REF_METHOD) like ","%"+recordSheet.getrSolName()+"%");
            }
            example.setOrderByClause("R_UPD_DATE desc");
            return this.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<RecordSheet>();
        }
    }
}
