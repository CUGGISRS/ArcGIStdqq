package textwatcher;
/**
 * һ��Value(��ֵ)-Name(��ʾ����)�����磺1-����
 */
public class ValueNameDomain {

	private String Value;//�󶨵�ֵ
	private String Name;//��ʾ��ѡ������
	
	public ValueNameDomain(){}
	
	public ValueNameDomain(String name,String value){
		this.Name = name;
		this.Value = value;
	}
	
	/**
	 * ��ȡ�󶨵�ֵ
	 */
	public String getValue() {
		return Value;
	}
	/**
	 * ���ð󶨵�ֵ
	 */
	public void setValue(String value) {
		this.Value = value;
	}
	/**
	 * ��ȡ��ʾ��ѡ������
	 */
	public String getName() {
		return Name;
	}
	/**
	 * ������ʾ��ѡ������
	 */
	public void setName(String name) {
		this.Name = name;
	}
	@Override
	public String toString() {
		return Name;
	}
	
	
}
