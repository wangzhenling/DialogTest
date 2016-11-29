package com.example.dialogtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btnExit,btnStatus,btnInterest,btnChooseFriend;
	private TextView statusText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
        btnExit=(Button) this.findViewById(R.id.btnExit);
        btnStatus=(Button) this.findViewById(R.id.btnStatus);
        btnInterest=(Button) this.findViewById(R.id.btnInterest);
        btnChooseFriend=(Button) this.findViewById(R.id.btnChooseFriend);
        statusText=(TextView) this.findViewById(R.id.stastusText);
		
		final Builder builder=new AlertDialog.Builder(this);
		
		btnExit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				builder.setMessage("Are you sure you want to exit?");
				builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
						Toast.makeText(MainActivity.this, "������ȷ����", 1000).show();
					}
				});
				builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
						Toast.makeText(MainActivity.this, "������ȡ����", 1000).show();
					}
				});
				builder.show();
			}
		});
		
		btnStatus.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				final String[] items=new String[]{"����","����","�뿪","æµ","����","����"};
				Builder builder=new AlertDialog.Builder(MainActivity.this);
				builder.setTitle("��ѡ�����״̬");
				builder.setIcon(R.drawable.me_selected);
				builder.setCancelable(false);
				builder.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
						//statusText.setText("�㵱ǰ��״̬�ǣ�"+items[which]);
						
						if(which==(items.length-1)){
							Builder mybuilder=new AlertDialog.Builder(MainActivity.this);
							final EditText myInput=new EditText(MainActivity.this);
							mybuilder.setTitle("���������״̬");
							mybuilder.setIcon(R.drawable.me_selected);
							mybuilder.setView(myInput);
							mybuilder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int which) {
									// TODO Auto-generated method stub
									
									statusText.setText("�㵱ǰ��״̬�ǣ�"+myInput.getText().toString());
								}
							});
							mybuilder.show();
						}else{
							statusText.setText("�㵱ǰ��״̬�ǣ�"+items[which]);
						}
					}
				});
				builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
	
					}
				});
				builder.create().show();
			}
		});
		btnInterest.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				final String[] hobbies=new String[]{"����","����","��ѧ","����","�˶�","����"};
				Builder mebuilder=new AlertDialog.Builder(MainActivity.this);
				mebuilder.setTitle("��İ�����");
				mebuilder.setIcon(R.drawable.me_selected);
				mebuilder.setCancelable(false);
				final EditText sb=new EditText(MainActivity.this);
				mebuilder.setView(sb);
				
				mebuilder.setMultiChoiceItems(hobbies, null, new DialogInterface.OnMultiChoiceClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which, boolean isChecked) {
						// TODO Auto-generated method stub
						
						if(isChecked)
                        {
                            sb.append(hobbies[which] + ", ");
                        }
                        //Toast.makeText(MainActivity.this, "��İ���Ϊ��" + sb.toString(), Toast.LENGTH_SHORT).show();	
                        statusText.setText("��İ���Ϊ��"+sb.getText().toString());
					}
				});
				
				mebuilder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
	
					}
				});
				mebuilder.show();
				
			}
		});
		
		btnChooseFriend.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				final String[] names=new String[]{"��������","ǳ��","Ƽˮ���"};
				final String[] infos=new String[]{"����ǩ����ĥ����","����ǩ����ƴ����","����ǩ�����������ߵ����У��������ߵ����¡�"};
				final int[] imageids=new int[]{R.drawable.a,R.drawable.b,R.drawable.c};
				List<Map<String,Object>>listItems=new ArrayList<Map<String,Object>>();
				
				for(int i = 0;i<names.length;i++){
					Map<String,Object>map=new HashMap<String,Object>();
					map.put("img", imageids[i]);
					map.put("title", names[i]);
					map.put("info",infos[i]);
					listItems.add(map);
				}
				
				SimpleAdapter simpleAdapter=new SimpleAdapter(MainActivity.this, listItems, R.layout.simple_adapter, 
						new String[]{"img","title","info"}, new int[]{R.id.img,R.id.title,R.id.info});
				
				Builder ibuilder=new AlertDialog.Builder(MainActivity.this);
				ibuilder.setTitle("��ѡ�����");
				ibuilder.setIcon(R.drawable.me_selected);
				ibuilder.setAdapter(simpleAdapter, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub

						Toast.makeText(MainActivity.this, "��ѡ��ĺ����ǣ�"+names[which], 1000).show();
					}
				});
				ibuilder.create().show();
			}
		});
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
