package com.dataflow.core.model.writer;

import com.dataflow.core.constant.RetryModeEnum;
import com.dataflow.core.model.message.PluginParameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Desciption:writer 参数类
 *
 * @author Claire.Chen
 * @create_time 2019 -04 - 12 16:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class PluginWriterParameter extends PluginParameter {
    /**
     * Writer的线程池大小
     */
    private int poolSize = 5;
    /**
     * dryRun时不会进行实际写入操作
     */
    private boolean dryRun = false;
    /**
     * 是否开启批量写入
     */
    private boolean useBatch = true;
    /**
     * 批量写入时每个批次的大小
     */
    private int batchSize = 50;
    /**
     * 是否可以对数据进行合并
     */
    private boolean merging = false;
    /**
     * 最大重试次数
     */
    private int maxRetryTimes = 3;
    /**
     * 重试模式
     */
    private RetryModeEnum retryMode = RetryModeEnum.ALWAYS;
    /**
     * 目标端缺少列时，是否自动加列
     */
    private boolean syncAutoAddColumn = true;


}
