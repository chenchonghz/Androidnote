package com.example.hellocharttest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {
	 List<Line> lines;
	 Axis axisX;
	 Axis axisY;
	 Viewport v;
	private LineChartView lineChart;
	private Button startbutton,stopbutyon;
	Timer disConnectOutTimer;
	String[] date = {""};//X��ı�ע
	int[] score= {};//ͼ�������
	private List<PointValue> mPointValues = new ArrayList<PointValue>();
	private List<AxisValue> mAxisXValues = new ArrayList<AxisValue>();
	 Line line ;
	 LineChartData data2;
	  int i=0;
	MyHandler mHandler ;
	  
	boolean isSend = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getdata();
        lineChart = (LineChartView)findViewById(R.id.line_chart);
   	 	getAxisXLables();//��ȡx��ı�ע
   	 	getAxisPoints();//��ȡ�����
        initLineChart();//��ʼ��
        startbutton=(Button) findViewById(R.id.startdata);
        stopbutyon=(Button) findViewById(R.id.stopdata);
        mHandler = new MyHandler();
        stopbutyon.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			    Message message=new Message();  
                message.what=2;  
                mHandler.sendMessage(message);  
			}
		});
      
        startbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						while (isSend) {
							try {
								Message message=new Message();  
	    	                    message.what=1;  
	    	                    mHandler.sendMessage(message);  
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					}
				}).start();
				
			}
		});
    }
    public void getdata(){
    	Data data =new Data();
    	data.adddata();
    	for(int i =0;i<100;i++){
    		System.out.println(" i: "+data.arr.get(i));
    	}
    }
    class MyHandler extends Handler  
    {  
        @Override  
        public void handleMessage(Message msg) {  
            // TODO Auto-generated method stub  
            super.handleMessage(msg);  
            switch (msg.what) {
			case 1:
				System.out.println("����");  
				 mPointValues.add(new PointValue(i+2, i));
					mAxisXValues.add(new AxisValue(i).setLabel(String.valueOf(i)));
					System.out.println("��ʼ�������");
					i++;
					lines.add(line);
					data2.setLines(lines);
					lineChart.setLineChartData(data2);
				break;
			case 2:
				System.out.println("ֹͣ");  
				isSend = false;
				break;
			}
        }  
    }  
    
    
    @Override
    protected void onDestroy() {
    	 if (mHandler != null) {
    		   mHandler = null;
    		}
    	super.onDestroy();
    }
    /**
     * ��ʼ��LineChart��һЩ����
     */
    private void initLineChart(){
        line = new Line(mPointValues).setColor(Color.parseColor("#D6D6D9"));  //���ߵ���ɫ
	    lines = new ArrayList<Line>();    
	    line.setShape(ValueShape.CIRCLE);//����ͼ��ÿ�����ݵ����״  ������Բ�� �������� ��ValueShape.SQUARE  ValueShape.CIRCLE  ValueShape.SQUARE��
	    line.setCubic(false);//�����Ƿ�ƽ��
//	    line.setStrokeWidth(3);//�����Ĵ�ϸ��Ĭ����3
		line.setFilled(false);//�Ƿ�������ߵ����
		line.setHasLabels(true);//���ߵ����������Ƿ���ϱ�ע
//		line.setHasLabelsOnlyForSelected(true);//�������������ʾ���ݣ����������line.setHasLabels(true);����Ч��
		line.setHasLines(true);//�Ƿ���ֱ����ʾ�����Ϊfalse ��û������ֻ�е���ʾ	
		line.setHasPoints(true);//�Ƿ���ʾԲ�� ���Ϊfalse ��û��ԭ��ֻ�е���ʾ	
	    lines.add(line);  
	    data2 = new LineChartData();  
	    data2.setLines(lines);  
	      
	    //������  
	    axisX = new Axis(); //X��  
	    axisX.setHasTiltedLabels(false);  //X������������������б����ʾ����ֱ�ģ�true��б����ʾ 
//	    axisX.setTextColor(Color.WHITE);  //����������ɫ
	    axisX.setTextColor(Color.parseColor("#D6D6D9"));//��ɫ
	    
	    axisX.setName("δ�����������");  //�������
	    axisX.setTextSize(11);//���������С
	    axisX.setMaxLabelChars(7); //��༸��X�����꣬��˼�������������X�������ݵĸ���7<=x<=mAxisValues.length
	    axisX.setValues(mAxisXValues);  //���X�����������
	    data2.setAxisXBottom(axisX); //x ���ڵײ�     
//	    data.setAxisXTop(axisX);  //x ���ڶ���
	    axisX.setHasLines(true); //x ��ָ���
	    axisY = new Axis();  //Y��  
	    axisY.setName("����");//y���ע
	    axisY.setTextSize(11);//���������С
	    data2.setAxisYLeft(axisY);  //Y�����������
	    lineChart.setInteractive(true); 
	    lineChart.setZoomType(ZoomType.HORIZONTAL);  //�������ͣ�ˮƽ
	    lineChart.setMaxZoom((float) 3);//���ű���
	    lineChart.setLineChartData(data2);  
	    lineChart.setVisibility(View.VISIBLE);
	    v = new Viewport(lineChart.getMaximumViewport()); 
		  v.left = 0; 
		  v.right= 7; 
		  lineChart.setCurrentViewport(v);
    }
    /**
     * X �����ʾ
     */
    private void getAxisXLables(){
        for (int i = 0; i < date.length; i++) {    
        	mAxisXValues.add(new AxisValue(i).setLabel(date[i]));    
        }    	
    }
    /**
     * ͼ���ÿ�������ʾ
     */
    private void getAxisPoints(){
        for (int i = 0; i < score.length; i++) {    
        	mPointValues.add(new PointValue(i, score[i]));      
        }    	
    }
}
