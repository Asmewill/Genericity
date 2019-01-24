package disign.prototype.model;

/**
 * Created by jian.shui on 2019/1/24
 */
public class Card implements Cloneable {
    private int num;//卡号
    private Spec spec=new Spec();
    public Card(){
        System.out.println("Card 执行构造函数");
    }

    @Override
    protected Card clone() throws CloneNotSupportedException {
        System.out.println("clone时不执行构造函数");
        Card card= (Card) super.clone();
        card.spec=spec.clone();//对Spce对象也调用clone,实现深拷贝
        return card;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Spec getSpec() {
        return spec;
    }

    public void setSpec(int width,int  length) {
        spec.width=width;
        spec.length=length;
    }

    public class Spec implements Cloneable{
        private int width;
        private int length;

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        @Override
        protected Spec clone() throws CloneNotSupportedException {
            return (Spec) super.clone();
        }
    }

    @Override
    public String toString() {
        return "Card{" +
                "num=" + num +
                ", spec=" +"{width="+spec.getWidth()+",length="+spec.getLength()+
                '}';
    }
}
