package com.dataflow.core.model.writer;

import com.dataflow.core.constant.MediaSourceTypeEnum;
import com.dataflow.core.constant.SyncModeEnum;
import com.dataflow.core.model.message.WriterParamEntry;
import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * Desciption: rdbms -writer 参数类
 *
 * @author Claire.Chen
 * @create_time 2019 -04 - 12 18:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RdbmsWriterParameter extends PluginWriterParameter {

    private SyncModeEnum syncMode = SyncModeEnum.TABLE_ORDERED_PARTLY;
    private WriterParamEntry writerParamEntry;

    @Override
    public String initPluginName() {
        return "writer-rdbms";
    }

    @Override
    public String initPluginClass() {
        return "com.huayun.worker.writerdbms.runner.RdbmsTaskWriter";
    }

    @Override
    public String initPluginListenerClass() {
        return "";
    }

    @Override
    public Set<MediaSourceTypeEnum> initSupportedSourceTypes() {
        return Sets.newHashSet(MediaSourceTypeEnum.MYSQL, MediaSourceTypeEnum.SQLSERVER, MediaSourceTypeEnum.POSTGRESQL);
    }

}
