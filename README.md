# dataflow
support mysql pg hbase data sync 

### 流程 思路
整体流程图：
![avatar]()

#### writer部分
```text
kafka --->  mysqlMessages --- |
                              |    
                              |
                              |----主Thread
                              |
                              |
kafka --->  pgMessages--------|


主Thread ---> 初始化任务 ---> 生成不同RdbmsTaskWriter --> RdbmsMessageHandler
             查询合理任务



                                                                 |---------无
                                                                 | 
合理任务 ---> taskId  ---> mediaMappings ---> sourceMediaNodeId --|              
                                             targetMediaNodeId --|
                                                                 |
                                                                 |---------联通验证，表映射验证

```



```text
taskId  --> taskContext --> 1个目标数据库连接 --->  n(t -t) --> n(c-c) --> d-t-c
```


```text
DDL:
{"databaseName":"testdb","operationType":"DML","positionInfo":{"event":0,"position":0,"serverId":0,"snapshot":false,"tsSec":0},"rdbmsOperation":{"commit":true,"data":"{"id":1,"name":"czy2","age":13}","type":"table-insert","xid":11},"sourceType":"mysql","tableName":"profile"}


```
