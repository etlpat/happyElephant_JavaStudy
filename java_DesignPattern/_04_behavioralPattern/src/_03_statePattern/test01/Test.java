package _03_statePattern.test01;

// 案例：电梯切换状态
//  通过按钮来控制一个电梯的状态AbstractState,
//  一个电梯有开门状态OpenState,关门状态CloseState,停止状态StopState,运行状态RunState。
//  每一种状态改变,都有可能要根据其他状态来更新处理。
//  例如：电梯处于运行状态，就不能开门/关门，只能转换为停止状态。
//      电梯处于停止状态，可以转换为开门/关门状态，也可以转换为运行状态。
//      电梯开门，可以转换为停止/关门状态，不能转换为运行状态。
//      电梯关门，可以转换为停止/开门状态，不能转换为运行状态。
//


import _03_statePattern.test01.context.Context;

public class Test {
    public static void main(String[] args) {
        // 创建环境对象（环境对象中，包含当前状态对象）
        Context context = new Context();

        // 测试电梯的各项操作
        // （状态会在内部自动切换）
        context.open();
        context.close();
        context.stop();
        context.run();
        context.stop();
        context.open();
        context.close();
        context.stop();
    }
}
