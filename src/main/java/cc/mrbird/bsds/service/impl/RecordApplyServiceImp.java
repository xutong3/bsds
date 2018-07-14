package cc.mrbird.bsds.service.impl;

import cc.mrbird.bsds.domain.RecordApply;
import cc.mrbird.bsds.domain.RecordSheet;
import cc.mrbird.bsds.service.IRecordApplyService;
import cc.mrbird.common.service.impl.BaseService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 75631 on 2018/7/14.
 */
@Service("recordApplyService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RecordApplyServiceImp extends BaseService<RecordApply> implements IRecordApplyService {

    @Override
    public List<RecordApply> findRecordSheet(RecordApply recordApply) {
        try {
            Example example = new Example(RecordApply.class);
            Example.Criteria criteria = example.createCriteria();
            if (null!=recordApply.getApType()){
                criteria.andEqualTo("apType",recordApply.getApType());
            }
            if (StringUtils.isNotBlank(recordApply.getrName())){
                criteria.andCondition("(AP_NAME||R_NAME||AP_BATCH_NUM) like ","%"+recordApply.getrName()+"%");
            }
            example.setOrderByClause("AP_DATE desc");
            return this.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<RecordApply>();
        }
    }
}
