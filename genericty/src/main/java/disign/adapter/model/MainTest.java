package disign.adapter.model;

/**
 * Created by Administrator on 2018/11/10
 * https://www.cnblogs.com/V1haoge/p/6479118.html
 */
public class MainTest {
    public static void main(String[] args){
        //1.�����䣬ͨ���̳�������
        AdapterOne adapterOne=new AdapterOne();
        adapterOne.isPs2();
        //2.�������䣬ͨ�����ʵ��
        Usber usber=new Usber();
        AdapterTwo adapterTwo=new AdapterTwo(usber);
        adapterTwo.isPs2();
        //3.�ӿ����䣬ͨ��������ʵ��
        A aRealize=new MyAdapter();
        aRealize.a();
        aRealize.b();

    }
}
