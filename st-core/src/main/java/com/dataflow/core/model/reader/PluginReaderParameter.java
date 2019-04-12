package com.dataflow.core.model.reader;


import com.dataflow.core.model.message.PluginParameter;

/**
 * Desciption:reader 参数类，目前还没用
 *
 * @author Claire.Chen
 * @create_time 2019 -04 - 11 09:38
 */
public abstract class PluginReaderParameter extends PluginParameter {

    private boolean dump = false;//是否需要dump fetch到的数据
    private Long mediaSourceId;//Reader关联的mediaSource的id
    private boolean ddlSync = true;

    public boolean isDump() {
        return dump;
    }

    public void setDump(boolean dump) {
        this.dump = dump;
    }

    public Long getMediaSourceId() {
        return mediaSourceId;
    }

    public void setMediaSourceId(Long mediaSourceId) {
        this.mediaSourceId = mediaSourceId;
    }

    public boolean isDdlSync() {
        return ddlSync;
    }

    public void setDdlSync(boolean ddlSync) {
        this.ddlSync = ddlSync;
    }
}
