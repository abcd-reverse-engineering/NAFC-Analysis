package com.huawei.agconnect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes.dex */
public class LocalBrdMnger {
    private static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final Object M_LOCK = new Object();
    private static LocalBrdMnger mInstance;
    private final Context mAppContext;
    private final Handler mHandler;
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> mReceivers = new HashMap<>();
    private final HashMap<String, ArrayList<ReceiverRecord>> mActions = new HashMap<>();
    private final ArrayList<BroadcastRecord> mPendingBroadcasts = new ArrayList<>();

    private static class BroadcastRecord {
        final Intent intent;
        final ArrayList<ReceiverRecord> receivers;

        BroadcastRecord(Intent intent, ArrayList<ReceiverRecord> arrayList) {
            this.intent = intent;
            this.receivers = arrayList;
        }
    }

    private static class ReceiverRecord {
        boolean broadcasting;
        final IntentFilter filter;

        /* renamed from: receiver, reason: collision with root package name */
        final BroadcastReceiver f6369receiver;

        ReceiverRecord(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.filter = intentFilter;
            this.f6369receiver = broadcastReceiver;
        }

        public String toString() {
            return "Receiver{" + this.f6369receiver + " filter=" + this.filter + "}";
        }
    }

    private LocalBrdMnger(Context context) {
        this.mAppContext = context;
        this.mHandler = new Handler(context.getMainLooper()) { // from class: com.huawei.agconnect.LocalBrdMnger.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    LocalBrdMnger.this.executePendingBroadcasts();
                } else {
                    super.handleMessage(message);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executePendingBroadcasts() {
        BroadcastRecord[] broadcastRecordArr;
        while (true) {
            synchronized (this.mReceivers) {
                int size = this.mPendingBroadcasts.size();
                if (size <= 0) {
                    return;
                }
                broadcastRecordArr = new BroadcastRecord[size];
                this.mPendingBroadcasts.toArray(broadcastRecordArr);
                this.mPendingBroadcasts.clear();
            }
            for (BroadcastRecord broadcastRecord : broadcastRecordArr) {
                for (int i2 = 0; i2 < broadcastRecord.receivers.size(); i2++) {
                    broadcastRecord.receivers.get(i2).f6369receiver.onReceive(this.mAppContext, broadcastRecord.intent);
                }
            }
        }
    }

    public static LocalBrdMnger getInstance(Context context) {
        LocalBrdMnger localBrdMnger;
        synchronized (M_LOCK) {
            if (mInstance == null) {
                mInstance = new LocalBrdMnger(context.getApplicationContext());
            }
            localBrdMnger = mInstance;
        }
        return localBrdMnger;
    }

    public void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            ReceiverRecord receiverRecord = new ReceiverRecord(intentFilter, broadcastReceiver);
            ArrayList<IntentFilter> arrayList = this.mReceivers.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.mReceivers.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                String action = intentFilter.getAction(i2);
                ArrayList<ReceiverRecord> arrayList2 = this.mActions.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.mActions.put(action, arrayList2);
                }
                arrayList2.add(receiverRecord);
            }
        }
    }

    public boolean sendBroadcast(Intent intent) {
        boolean z;
        String str;
        String str2;
        ArrayList arrayList;
        int i2;
        Uri uri;
        synchronized (this.mReceivers) {
            String action = intent.getAction();
            String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            ArrayList<ReceiverRecord> arrayList2 = this.mActions.get(intent.getAction());
            if (arrayList2 != null) {
                ArrayList arrayList3 = null;
                int i3 = 0;
                while (i3 < arrayList2.size()) {
                    ReceiverRecord receiverRecord = arrayList2.get(i3);
                    if (receiverRecord.broadcasting) {
                        i2 = i3;
                        str = action;
                        str2 = strResolveTypeIfNeeded;
                        uri = data;
                        arrayList = arrayList3;
                    } else {
                        str = action;
                        String str3 = strResolveTypeIfNeeded;
                        str2 = strResolveTypeIfNeeded;
                        arrayList = arrayList3;
                        i2 = i3;
                        uri = data;
                        if (receiverRecord.filter.match(action, str3, scheme, data, categories, "LocalBroadcastManager") >= 0) {
                            arrayList3 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList3.add(receiverRecord);
                            receiverRecord.broadcasting = true;
                        }
                        i3 = i2 + 1;
                        action = str;
                        strResolveTypeIfNeeded = str2;
                        data = uri;
                    }
                    arrayList3 = arrayList;
                    i3 = i2 + 1;
                    action = str;
                    strResolveTypeIfNeeded = str2;
                    data = uri;
                }
                ArrayList arrayList4 = arrayList3;
                z = false;
                if (arrayList4 != null) {
                    for (int i4 = 0; i4 < arrayList4.size(); i4++) {
                        ((ReceiverRecord) arrayList4.get(i4)).broadcasting = false;
                    }
                    this.mPendingBroadcasts.add(new BroadcastRecord(intent, arrayList4));
                    if (!this.mHandler.hasMessages(1)) {
                        this.mHandler.sendEmptyMessage(1);
                    }
                    return true;
                }
            } else {
                z = false;
            }
            return z;
        }
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.mReceivers) {
            ArrayList<IntentFilter> arrayListRemove = this.mReceivers.remove(broadcastReceiver);
            if (arrayListRemove == null) {
                return;
            }
            for (int i2 = 0; i2 < arrayListRemove.size(); i2++) {
                IntentFilter intentFilter = arrayListRemove.get(i2);
                for (int i3 = 0; i3 < intentFilter.countActions(); i3++) {
                    String action = intentFilter.getAction(i3);
                    ArrayList<ReceiverRecord> arrayList = this.mActions.get(action);
                    if (arrayList != null) {
                        int i4 = 0;
                        while (i4 < arrayList.size()) {
                            if (arrayList.get(i4).f6369receiver == broadcastReceiver) {
                                arrayList.remove(i4);
                                i4--;
                            }
                            i4++;
                        }
                        if (arrayList.size() <= 0) {
                            this.mActions.remove(action);
                        }
                    }
                }
            }
        }
    }
}
