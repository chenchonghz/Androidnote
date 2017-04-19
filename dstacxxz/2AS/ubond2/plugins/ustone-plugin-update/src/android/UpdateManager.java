package com.ustone.plugin.update;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.widget.ProgressBar;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.LOG;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UpdateManager {
    public static final String TAG = "UpdateManager";

    private String updateXmlUrl;
    private JSONArray args;
    private CallbackContext callbackContext;
    private String packageName;
    private Context mContext;
    private MsgBox msgBox;
    private List<Version> queue = new ArrayList<Version>(1);
    private CheckUpdateThread checkUpdateThread;
    private DownloadApkThread downloadApkThread;


    public UpdateManager(JSONArray args, CallbackContext callbackContext, Context context) {
        this(args, callbackContext, context, "http://192.168.3.102:8080/update_apk/version.xml");
    }

    public UpdateManager(JSONArray args, CallbackContext callbackContext, Context context, String updateUrl) {
        this.args = args;
        this.callbackContext = callbackContext;
        this.updateXmlUrl = updateUrl;
        this.mContext = context;
        packageName = mContext.getPackageName();
        msgBox = new MsgBox(mContext);
    }

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(android.os.Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case Constants.NETWORK_ERROR:
                    msgBox.showErrorDialog(errorDialogOnClick);
                    break;
                case Constants.VERSION_COMPARE_START:
                    compareVersions();
                    break;
                case Constants.VERSION_COMPARE_SUCCESS:
                    callbackContext.success();
                    break;
                case Constants.VERSION_COMPARE_FAIL:
//                    callbackContext.error(Constants.VERSION_COMPARE_FAIL);
                    break;
            }
        }
    };

    public void checkUpdate() {
        LOG.d(TAG, "checkUpdate..");
        checkUpdateThread = new CheckUpdateThread(mContext, mHandler, queue, packageName, updateXmlUrl);
        new Thread(checkUpdateThread).start();
    }


    private void compareVersions() {
        Version version = queue.get(0);
        int versionCodeLocal = version.getLocal();
        int versionCodeRemote = version.getRemote();

        if (versionCodeLocal != versionCodeRemote) {
            LOG.d(TAG, "need update");
            msgBox.showNoticeDialog(noticeDialogOnClick);
        } else {
        }
    }

    private OnClickListener noticeDialogOnClick = new OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
            Map<String, Object> ret = msgBox.showDownloadDialog(downloadDialogOnClick);
            downloadApk((Dialog)ret.get("dialog"), (ProgressBar)ret.get("progress"));
        }
    };

    private OnClickListener downloadDialogOnClick = new OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
            downloadApkThread.cancelBuildUpdate();
        }
    };

    private OnClickListener errorDialogOnClick = new OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
        }
    };

    private void downloadApk(Dialog mDownloadDialog, ProgressBar mProgress) {
        LOG.d(TAG, "downloadApk" + mProgress);

        downloadApkThread = new DownloadApkThread(mContext, mProgress, mDownloadDialog, checkUpdateThread.getMHashMap());
        new Thread(downloadApkThread).start();
    }
}