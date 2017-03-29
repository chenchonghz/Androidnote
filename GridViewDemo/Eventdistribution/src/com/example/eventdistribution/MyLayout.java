package com.example.eventdistribution;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class MyLayout extends FrameLayout{
/*
 *1. Android�¼��ַ����ȴ��ݵ�ViewGroup������ViewGroup���ݵ�View�ġ�
2. ��ViewGroup�п���ͨ��onInterceptTouchEvent�������¼����ݽ������أ�onInterceptTouchEvent��������true���������¼���������View���ݣ�����false�������¼��������أ�Ĭ�Ϸ���false��
3. ��View����������ݵ��¼����ѵ���ViewGroup�н��޷����յ��κ��¼���
 */
	public MyLayout(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public MyLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	//ϵͳĬ�Ϸ���false
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) { 
        Log.e(MainActivity.TAG,"MyLayout onInterceptTouchEvent. "   
        + super.onInterceptTouchEvent(ev));  
    	return super.onInterceptTouchEvent(ev);
//        return true;
    }
  //ϵͳĬ�Ϸ���false
    @Override
    public boolean onTouchEvent(MotionEvent event) {
         Log.e(MainActivity.TAG,"MyLayout onTouchEvent."   
         + super.onTouchEvent(event));  
    	return super.onTouchEvent(event);
//    	   return true;
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
    	  Log.e(MainActivity.TAG,"MyLayout dispatchTouchEvent."   
    		         + super.onTouchEvent(ev));  
    	return super.dispatchTouchEvent(ev);
    }


}
