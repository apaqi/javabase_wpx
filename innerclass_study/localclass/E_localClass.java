package localclass;
//���һ���ڲ���Ķ�������ڴ�����У�����static���Σ���Ƹ���Ϊ�ֲ��ڲ���


	interface Analyse{
		int count();
	}
	class Local{
		public static Analyse walkThrough(final int[] obj){//final������
			class Realize implements Analyse{//�ֲ��ڲ���
				private int pos = 0;
				public int count(){
					int i;
					for(i=0;i<obj.length;i++)
						pos++;
					return pos;
				}
			}
			
			return new Realize() ;
		}
	}
public class E_localClass {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		Analyse b = Local.walkThrough(a);
		System.out.println(b.count());
	}

}
