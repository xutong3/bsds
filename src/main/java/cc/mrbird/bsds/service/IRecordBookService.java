package cc.mrbird.bsds.service;

import cc.mrbird.bsds.domain.RecordBook;
import cc.mrbird.common.service.IService;

import java.util.List;

/**
 * Created by 75631 on 2018/7/14.
 */
public interface IRecordBookService extends IService<RecordBook> {
    List<RecordBook> findRecordBook(RecordBook recordBook);
}
