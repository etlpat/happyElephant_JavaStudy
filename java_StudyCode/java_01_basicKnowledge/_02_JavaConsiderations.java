//Consideration��ע������


// Java����ע������
// 1.Դ�ļ��Ļ�����ɲ�������class
// 
// 2.java�����ִ�������main���������й̶�����д��ʽ��
//	 public static void main(String[] args) {...} 
//	 
// 3.һ��Դ�ļ������ֻ����һ��publicȨ�޵��࣬�������������
// 	 һ��Դ�ļ���δ��ֻ��һ��main����
// 	 
// 4.���һ��Դ�ļ�����һ��public�࣬���ļ������밴����������
//   (����������� == �ļ���)
//   
// 5.���Խ�main����д�ڷ�public���У�Ȼ�����и��࣬������ڷ������Ƿ�public��





// һ������ֻ����һ��public����(���ļ�ͬ��)
public class _02_JavaConsiderations{
}

class cat{
	public static void main(String[] args){// main����δ�ط��ڹ�������
		System.out.println("main������Cat����");
	}
}

class dog{
	public static void main(String[] args){// main����δ��ֻ��һ��
		System.out.println("main������Dog����");
	}
}