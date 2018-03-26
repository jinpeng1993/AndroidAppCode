package com.practice.sensor;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SensorDemo extends Activity {

	private final String TAG = "SensorDemo";
	private String SERVICE_NAME = Context.SENSOR_SERVICE;
	
	//用来管理Andorid设备上可用的传感器
	private SensorManager sensorManager; 
	
	private Sensor accelSensor;
	private TextView view;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
		Log.d(TAG,"1");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		view = findViewById(R.id.test);
		Log.d(TAG,"2");
        config();
    }
    
    @Override
	protected void onStart() {
		Log.d(TAG,"3");
		super.onStart();
		Log.d(TAG,"4");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
	}

	@Override
	protected void onResume() {
		super.onResume();
		//第四步：注册传感器事件监听事件
		Log.d(TAG,"5");
    	sensorManager.registerListener(mySensorListener, accelSensor, SensorManager.SENSOR_DELAY_NORMAL);
		Log.d(TAG,"6");
	}

	@Override
	protected void onPause() {
		super.onPause();
    	//第五步：注销传感器事件的监听
		Log.d(TAG,"7");
    	sensorManager.unregisterListener(mySensorListener);
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG,"8");
		super.onDestroy();
	}
	
	private void config() {
		Log.d(TAG,"9");
    	//第一步：获得SensorManager对象
    	sensorManager = (SensorManager)getSystemService(SERVICE_NAME);
    	//第二步：获得特定的传感器
		accelSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    	
    	if(accelSensor==null) {
    		//不支持此传感器
    	}
    	
    }
    
	//第三步 创建监听类
    SensorEventListener mySensorListener = new SensorEventListener() {

    	//传感器的值改变调用此方法
		@Override
		public void onSensorChanged(SensorEvent event) {
			Log.d(TAG,"10");

			float x = event.values[0];
			float y = event.values[1];
			float z = event.values[2];

			String Xx = "onSensorChanged: x:" +x;
			Xx += "\ny:" +y;
			Xx += "\nz:" +z;
			view.setText(Xx);

			Log.d(TAG,"onSensorChanged: x:" +x);
			Log.d(TAG, "onSensorChanged: y:" +y);
			Log.d(TAG, "onSensorChanged: z:"+z);

		}

		//传感器的精确度改变调用此方法
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			Log.d(TAG,"11");
		}

    };
}