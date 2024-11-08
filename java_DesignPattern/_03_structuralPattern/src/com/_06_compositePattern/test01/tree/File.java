package com._06_compositePattern.test01.tree;

public class File extends AbstractFolder {
    public File() {
        setLevel("文件");
    }

    public File(String name) {
        super(name);
        setLevel("文件");
    }

    @Override
    public void add(AbstractFolder folder) {
        throw new RuntimeException("叶子结点不可添加子树！");
    }

    @Override
    public void remove(AbstractFolder folder) {
        throw new RuntimeException("叶子结点不可删除子树！");
    }

    @Override
    public AbstractFolder getChile(int i) {
        throw new RuntimeException("叶子结点不可查找子树！");
    }


    // 叶子结点的operation()：执行叶子结点的业务逻辑。
    @Override
    public void operation() {
        printInfo();
    }
}
