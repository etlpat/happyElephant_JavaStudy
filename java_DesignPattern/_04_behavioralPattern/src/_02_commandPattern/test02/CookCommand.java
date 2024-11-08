package _02_commandPattern.test02;

public class CookCommand implements Command {
    Chef chef = new Chef();

    // 命令中调用接收者方法
    @Override
    public void execute() {
        chef.cook();
    }
}
