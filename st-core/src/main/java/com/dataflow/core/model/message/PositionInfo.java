package com.dataflow.core.model.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Desciption：位点信息
 *
 * @author Claire.Chen
 * @create_time 2019 -04 - 10 9:42
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionInfo implements Serializable {
    private String file;
    private int position;
    private boolean snapshot;
    private long tsSec;
    private int serverId;
    private int event;
}
