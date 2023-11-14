// debug：调试

// 断点调试
//
// (1)快捷键【重要】
//  F7：跳入方法内
//  shift+alt+F7：强制进入方法 (可进入java库方法查看源码)
//  F8：逐行执行
//  shift+F8：跳出方法
//  F9：(resume)执行到下一个断点
//
//
//
// 注意事项：
//  1.断点调试过程中，是运行状态，是以对象的运行类型来执行的
//      如：F7进入方法，进入的是和对象运行类型动态绑定的方法
//
//  2.改如下设置，可以F7直接进入java库方法查看源码（原本需要shift+alt+F7）
//      Settings -> Build,Execution,Deployment -> Debugger -> Stepping
//      把 java.* 和 javax.* 取消勾选(默认F7不进入这些类方法)

