//Comment 注释
//
// 注意：1.注释在编译阶段会被删除，不会被JVM虚拟机解释执行
//      2.多行注释不允许嵌套多行注释



// 1.单行注释

/* 2.多行注释 */

/**
 * 3.文档注释
 * 
 * 注释内容会被JDK提供的工具javadoc所解释，生成一套网页文件形式的说明文档，一般写在类中
 * 生成说明文档指令： javadoc -d 文档存放路径 -author -version... 文件.java
 */





/**
 * @author XXX作者名
 * @version 1.0版本
 */

public class _04_Comment{
	public static void main(String[] args){
	}
}

// 生成文档：
// javadoc -d D:\Java\javacode\tmp -author -version _04_Comment.java
