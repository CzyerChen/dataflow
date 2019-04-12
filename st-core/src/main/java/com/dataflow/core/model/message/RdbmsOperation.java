package com.dataflow.core.model.message;

import com.dataflow.core.constant.RdbmsOperationEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Desciption ： rdbms数据操作类
 *
 * @author Claire.Chen
 * @create_time 2019 -04 - 10 9:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RdbmsOperation implements Serializable {
    private RdbmsOperationEnum type;//"table-create" "table-insert","table-delete"...
    private long xid;
    private boolean commit;
    /**
     * DDL:{`id` int(32) NOT NULL,`name` varchar(255) NULL,`age` int(32) NULL,`hobby` varchar(255) NULL,primary key(`id`)}
     * DML:{"id":1,"name":"czy","age":10,"hobby":"basketball"}
     */
    private String data;
}
