#uband1

�ֻ� Android Demo ˵���ĵ�
1.����HelloCordova���� ɨ���豸�����Ҫ���ӵ��豸

2.a: ����BLEInfoActivity ������Զ�����,����ӡ������Ϣ
  
  b: ��һ�����ӳɹ�������ָ������ǵ��Է��͵��ǳ�����ָ�,����ʧ�������˵��ֶ�����
  
  c: �Ȱ󶨳ɹ����ߵ�¼�ɹ����ٷ�������ָ���Ȼ�ֻ���һ����ʱ�����Զ��Ͽ�����
  
  d:�ڶ������ӳɹ����͵��������¼ָ�� �����ڵ��Խ׶η��͵��ǳ�����ָ�

�������裺

  ��һ�����ӣ�

  ɨ��-->�Զ�����-->�Զ����Ͱ�ָ��-->����������

  �ڶ������ӣ�  

  ɨ��-->�Զ�����-->�Զ����������¼ָ��--> ����������




2016-11-7 
����ʵ��DFU ��������

��Ҫ�����������£�
1��ɨ�������豸�����������豸����ѯ�����豸�Ƿ�֧��DFU����������Ͳ�����ˣ���������
2����֧��DFU������ô�����صĹ̼�ͨ���������ͳ�ȥ��
3�����ݷ�����ϣ������̼��ɹ�

�򵥽��ܣ����忴���룬�������� QQ��1475579663��

1. ���� Android-DFU-Library ����⣬���漯����ع��ܺã�ֻ����þͿ����ˣ�


2. ѡ��Ҫ�ϴ��Ĳ���
  
				 DfuServiceInitiator starter = new DfuServiceInitiato(mPeripheral.device.getAddress())
						.setDeviceName(mPeripheral.device.getName())
						.setKeepBond(false);
//				if (mFileType == DfuService.TYPE_AUTO)
					starter.setZip(mFileStreamUri, mFilePath);
//				else {
//					starter.setBinOrHex(mFileType, mFileStreamUri, mFilePath).setInitFile(mInitFileStreamUri, mInitFilePath);
//				}
				
				starter.start(BLEInfoActivity.this, DfuService.class);





	@Override
	protected void onResume() {
		super.onResume();
        Log.i(tag, "onResume.........");
		DfuServiceListenerHelper.registerProgressListener(this, mDfuProgressListener);
	}

3./**
   * Dfu���ȼ�����
   */


	private  DfuProgressListener mDfuProgressListener = new DfuProgressListener() {
		/*
		 * ����
		 **/
		@Override
		public void onProgressChanged(String deviceAddress, int percent,
				float speed, float avgSpeed, int currentPart, int partsTotal) {
			 Log.i("DfuProgressListener", "onProgressChanged");
			
		}
		/*
		 * ��Ŀ���豸����֤�¹̼�ʱ���õķ�����
		 * */
		@Override
		public void onFirmwareValidating(String deviceAddress) {
			 Log.i("DfuProgressListener", "onFirmwareValidating");
		}
		/*
		 * ������Ϣ
		 * �������ͣ�
		 * DfuBaseService.ERROR_TYPE_COMMUNICATION_STATE, 
		 * DfuBaseService.ERROR_TYPE_COMMUNICATION, 
		 * DfuBaseService.ERROR_TYPE_DFU_REMOTE, 
		 * DfuBaseService.ERROR_TYPE_OTHER.
		 **/
		@Override
		public void onError(String deviceAddress, int error, int errorType,
				String message) {
			 Log.i("DfuProgressListener", "onError��"+message);
		}
		@Override
		public void onEnablingDfuMode(String deviceAddress) {
		}
		
		@Override
		public void onDfuProcessStarting(String deviceAddress) {
			 Log.i("DfuProgressListener", "onDfuProcessStarting");
		}
		
		@Override
		public void onDfuProcessStarted(String deviceAddress) {
			 Log.i("DfuProgressListener", "Started...��ʼ");
			
		}
		
		@Override
		public void onDfuCompleted(String deviceAddress) {
			 Log.i("DfuProgressListener", "onDfuCompleted..�ɹ�");
			
		}
		
		@Override
		public void onDfuAborted(String deviceAddress) {
		}
		
		@Override
		public void onDeviceDisconnecting(String deviceAddress) {
		}
		
		@Override
		public void onDeviceDisconnected(String deviceAddress) {
			 Log.i("DfuProgressListener", "onDeviceDisconnected...�Ͽ�����");			
		}
		
		@Override
		public void onDeviceConnecting(String deviceAddress) {
		}
		
		@Override
		public void onDeviceConnected(String deviceAddress) {
			 Log.i("DfuProgressListener", "onDeviceConnected....����");			
		}
	};
