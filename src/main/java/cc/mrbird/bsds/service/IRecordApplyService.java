package cc.mrbird.bsds.service;

import cc.mrbird.bsds.domain.RecordApply;
import cc.mrbird.common.service.IService;

import java.util.List;

/**
 * Created by 75631 on 2018/7/14.
 */
public interface IRecordApplyService  extends IService<RecordApply> {
    List<RecordApply> findRecordSheet(RecordApply recordApply);
}
