	//����
Instrumentation inst = new Instrumentation();
inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);

//����ϵͳ����
	AudioManager mAudioManager = (AudioManager) MainActivity.instance.getSystemService(Context.AUDIO_SERVICE);
	mAudioManager.setStreamVolume(AudioManager.STREAM_SYSTEM, 0, 0);//����ϵͳ����

//��������
   		mAudioManager = (AudioManager) MainActivity.instance.getSystemService(Context.AUDIO_SERVICE);
			mAudioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,AudioManager.ADJUST_LOWER,
                    AudioManager.FX_FOCUS_NAVIGATION_UP);

//��������

		mAudioManager = (AudioManager) MainActivity.instance.getSystemService(Context.AUDIO_SERVICE);
			mAudioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,AudioManager.ADJUST_RAISE,
                    AudioManager.FX_FOCUS_NAVIGATION_UP);
//�����ֻ�������

			 intent = new Intent(Intent.ACTION_MAIN);
	            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);// ע��
	            intent.addCategory(Intent.CATEGORY_HOME);
	            MainActivity.instance.startActivity(intent);

//ֹͣ����

	inst = new Instrumentation();
	    	inst.sendKeyDownUpSync(KeyEvent.KEYCODE_MEDIA_STOP);


			// ��ʼ/ֹͣ����
			 	inst = new Instrumentation();
      inst.sendKeyDownUpSync(KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE);
	//ת����һ��
			inst = new Instrumentation();
	    	inst.sendKeyDownUpSync(KeyEvent.KEYCODE_MEDIA_PREVIOUS);

		//��ͣ
			inst = new Instrumentation();
	    	inst.sendKeyDownUpSync(KeyEvent.KEYCODE_MEDIA_PAUSE);

		//��ʼ����
			inst = new Instrumentation();
	    	inst.sendKeyDownUpSync(KeyEvent.KEYCODE_MEDIA_PLAY);

//ת����һ��
			inst = new Instrumentation();
	    	inst.sendKeyDownUpSync(KeyEvent.KEYCODE_MEDIA_NEXT);