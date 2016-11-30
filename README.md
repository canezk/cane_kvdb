# cane_kvdb
用java实现一个分布式键值存储

## 为什么要写？

> 这么多现成的，redis，memcache，为什么还要实现一个java版本的呢？性能更加难以超越其他的开源项目？

> 1. 为了进一步学习java

> 2. 为了进一步学习数据结构

> 3. 为了进一步学习i/o,多线程,存储管理,并发编程

> 4. 为了进一步学习分布式

> 5. 发现一些其他项目做不到的点

## 项目中依赖的工具

1. gradle管理依赖

2. log4j作为日志输出

## 单元测试
1. gradle test会跑所有的testcase

2. gradle test -Dtest.single=TestCaneKVLogger 跑单个testcase

