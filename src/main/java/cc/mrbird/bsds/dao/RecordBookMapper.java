package cc.mrbird.bsds.dao;

import cc.mrbird.bsds.domain.RecordBook;
import cc.mrbird.common.config.MyMapper;

import java.util.List;

public interface RecordBookMapper extends MyMapper<RecordBook> {
    List<RecordBook> findRecordBook(RecordBook recordBook);
}