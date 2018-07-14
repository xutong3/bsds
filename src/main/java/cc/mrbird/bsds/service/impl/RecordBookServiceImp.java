package cc.mrbird.bsds.service.impl;

import cc.mrbird.bsds.dao.RecordBookMapper;
import cc.mrbird.bsds.domain.RecordBook;
import cc.mrbird.bsds.service.IRecordBookService;
import cc.mrbird.common.service.impl.BaseService;
import cc.mrbird.system.dao.UserMapper;
import cc.mrbird.system.domain.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 75631 on 2018/7/14.
 */
@Service("recordBookService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RecordBookServiceImp extends BaseService<RecordBook> implements IRecordBookService {
    @Autowired
    private RecordBookMapper recordBookMapper;
    @Override
    public List<RecordBook> findRecordBook(RecordBook recordBook) {
        try {
            return this.recordBookMapper.findRecordBook(recordBook);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<RecordBook>();
        }
    }
}
