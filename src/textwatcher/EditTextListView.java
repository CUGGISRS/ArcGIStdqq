package textwatcher;
import java.util.ArrayList;
import java.util.List;

import com.esri.arcgis.android.samples.graphicelements.DrawGraphicElements;
import com.esri.arcgis.android.samples.graphicelements.GloableFunction;
import com.esri.arcgis.android.samples.graphicelements.NewInfoActivity;
import com.esri.arcgis.android.samples.graphicelements.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class EditTextListView extends Activity {
	//��ť��̬���棬���÷����Ա���ʹ��startActivityForResult����ȡ��ť���ص�ʱ��
	private EditText edit_search;
	private ListView lv;
	private EditTextListViewAdapter adapter;
	List<ValueNameDomain> newlist = new ArrayList<ValueNameDomain>();//��ѯ�������list

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.edittextlistview);
		init();

	}
	//��ʼ���ؼ�
	private void init() {
		edit_search = (EditText) findViewById(R.id.edit_search);
		//Ϊ�������TextWatcher�������ֵı仯
		edit_search.addTextChangedListener(new TextWatcher_Enum());
		adapter = new EditTextListViewAdapter(this, GloableFunction.UserList);
		lv = (ListView) findViewById(R.id.edittextListview);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(new onclick());
	}
	//��editetext�仯ʱ���õķ��������ж��������Ƿ����������������
	private List<ValueNameDomain> getNewData(String input_info) {
		//����list
		for (int i = 0; i < GloableFunction.UserList.size(); i++) {
			ValueNameDomain domain = GloableFunction.UserList.get(i);
			//��������������ְ����������ַ���
			if (domain.getName().contains(input_info)) {
				//����������Ԫ���������һ��list
				ValueNameDomain domain2 = new ValueNameDomain();
				domain2.setName(domain.getName());
				domain2.setValue(i + "");
				newlist.add(domain2);
			}
		}
		return newlist;
	}

	//button�ĵ���¼�
	class onclick implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
			TextView text = (TextView) view.findViewById(R.id.tvData);
			//String str = (String) text.getText();
			//btn.setText(str);
			ValueNameDomain value=(ValueNameDomain)text.getTag();
			Intent i = new Intent(EditTextListView.this, DrawGraphicElements.class); 
			i.putExtra("id",value.getValue());
			i.putExtra("name", value.getName());
			EditTextListView.this.setResult(RESULT_OK, i);
            finish();
		}

	}

	//TextWatcher�ӿ�
	class TextWatcher_Enum implements TextWatcher {

		//���ֱ仯ǰ
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {

		}

		//���ֱ仯ʱ
		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			newlist.clear();
			if (edit_search.getText() != null) {
				String input_info = edit_search.getText().toString();
				newlist = getNewData(input_info);
				adapter = new EditTextListViewAdapter(EditTextListView.this,
						newlist);
				lv.setAdapter(adapter);
			}
		}

		//���ֱ仯��
		@Override
		public void afterTextChanged(Editable s) {

		}

	}

}
