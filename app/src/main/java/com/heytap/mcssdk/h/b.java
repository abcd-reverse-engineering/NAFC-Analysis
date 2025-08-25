package com.heytap.mcssdk.h;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.c;
import com.heytap.mcssdk.k.e;
import com.heytap.mcssdk.k.g;
import com.heytap.msp.push.mode.BaseMode;
import com.heytap.msp.push.mode.DataMessage;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b extends c {
    @Override // com.heytap.mcssdk.h.d
    public BaseMode a(Context context, int i2, Intent intent) throws NumberFormatException {
        if (4103 != i2 && 4098 != i2 && 4108 != i2) {
            return null;
        }
        BaseMode baseModeA = a(intent, i2);
        com.heytap.mcssdk.j.a.a(context, c.a.f5837e, (DataMessage) baseModeA);
        return baseModeA;
    }

    @Override // com.heytap.mcssdk.h.c
    public BaseMode a(Intent intent, int i2) throws NumberFormatException {
        try {
            DataMessage dataMessage = new DataMessage();
            dataMessage.setMessageID(e.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f5825c)));
            dataMessage.setTaskID(e.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f5826d)));
            dataMessage.setGlobalId(e.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f5830h)));
            dataMessage.setAppPackage(e.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f5827e)));
            dataMessage.setTitle(e.d(intent.getStringExtra("title")));
            dataMessage.setContent(e.d(intent.getStringExtra("content")));
            dataMessage.setDescription(e.d(intent.getStringExtra("description")));
            String strD = e.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f5832j));
            int i3 = 0;
            dataMessage.setNotifyID(TextUtils.isEmpty(strD) ? 0 : Integer.parseInt(strD));
            dataMessage.setMiniProgramPkg(e.d(intent.getStringExtra("miniProgramPkg")));
            dataMessage.setMessageType(i2);
            dataMessage.setEventId(e.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f5833k)));
            dataMessage.setStatisticsExtra(e.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f5834l)));
            String strD2 = e.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f5835m));
            dataMessage.setDataExtra(strD2);
            String strA = a(strD2);
            if (!TextUtils.isEmpty(strA)) {
                i3 = Integer.parseInt(strA);
            }
            dataMessage.setMsgCommand(i3);
            dataMessage.setBalanceTime(e.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.n)));
            dataMessage.setStartDate(e.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.s)));
            dataMessage.setEndDate(e.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.t)));
            dataMessage.setTimeRanges(e.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.o)));
            dataMessage.setRule(e.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.p)));
            dataMessage.setForcedDelivery(e.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.q)));
            dataMessage.setDistinctContent(e.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.r)));
            dataMessage.setAppId(e.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.u)));
            return dataMessage;
        } catch (Exception e2) {
            g.b("OnHandleIntent--" + e2.getMessage());
            return null;
        }
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONObject(str).optString(com.heytap.mcssdk.constant.b.v);
        } catch (JSONException e2) {
            g.b(e2.getMessage());
            return "";
        }
    }
}
