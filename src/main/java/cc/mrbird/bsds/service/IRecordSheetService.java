package cc.mrbird.bsds.service;

import cc.mrbird.bsds.domain.RecordSheet;
import cc.mrbird.common.service.IService;

import java.util.List;

/**
 * Created by 75631 on 2018/7/14.
 */
public interface IRecordSheetService   extends IService<RecordSheet> {
    List<RecordSheet> findRecordSheet(RecordSheet recordSheet);
}
