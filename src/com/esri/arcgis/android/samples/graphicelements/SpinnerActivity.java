package com.esri.arcgis.android.samples.graphicelements;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
 
public class SpinnerActivity extends Activity {
     
    private static final String[] m={"A��","B��","O��","AB��","����","A��","B��","O��","AB��","����","A��","B��","O��","AB��","����","A��","B��","O��","AB��","����"};
    private TextView view ;
    private Spinner spinner;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);
         
        view = (TextView) findViewById(R.id.spinnerText);
        spinner = (Spinner) findViewById(R.id.Name);
        //����ѡ������ArrayAdapter��������
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,m);
         
        //���������б�ķ��
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         
        //��adapter ��ӵ�spinner��
        spinner.setAdapter(adapter);
         
        //����¼�Spinner�¼�����  
        spinner.setOnItemSelectedListener(new SpinnerSelectedListener());
         
        //����Ĭ��ֵ
        spinner.setVisibility(View.VISIBLE);
         
    }
     
    //ʹ��������ʽ����
    class SpinnerSelectedListener implements OnItemSelectedListener{
 
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                long arg3) {
            view.setText("���Ѫ���ǣ�"+m[arg2]);
        }
 
        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }
}