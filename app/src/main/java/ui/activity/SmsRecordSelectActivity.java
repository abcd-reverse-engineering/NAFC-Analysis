package ui.activity;

import adapter.SmsSelectAdapter;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.loader.content.CursorLoader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.SmsBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.hihonor.honorid.core.data.UserInfo;
import com.umeng.analytics.pro.bl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.Collator;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ui.Hicore;
import util.y1;

/* loaded from: classes2.dex */
public class SmsRecordSelectActivity extends BaseActivity implements SmsSelectAdapter.b {

    /* renamed from: h, reason: collision with root package name */
    public static final String f19028h = "select_type_name";

    /* renamed from: i, reason: collision with root package name */
    public static final int f19029i = 1;

    /* renamed from: j, reason: collision with root package name */
    public static final int f19030j = 2;

    /* renamed from: k, reason: collision with root package name */
    public static final String f19031k = "select_mode";

    /* renamed from: l, reason: collision with root package name */
    public static final String f19032l = "single";

    /* renamed from: a, reason: collision with root package name */
    private SmsSelectAdapter f19033a;

    /* renamed from: b, reason: collision with root package name */
    private List<SmsBean> f19034b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private List<SmsBean> f19035c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private Uri f19036d = Uri.parse("content://sms/");

    /* renamed from: e, reason: collision with root package name */
    private int f19037e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f19038f = 100;

    /* renamed from: g, reason: collision with root package name */
    private String f19039g = "";

    @BindView(R.id.btn_report)
    Button mBtnReport;

    @BindView(R.id.iv_back)
    ImageView mIvBack;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.rl_title)
    RelativeLayout mRlTitle;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    class a implements Runnable {

        /* renamed from: ui.activity.SmsRecordSelectActivity$a$a, reason: collision with other inner class name */
        class C0286a implements Comparator<SmsBean> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Collator f19041a;

            C0286a(Collator collator) {
                this.f19041a = collator;
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(SmsBean smsBean, SmsBean smsBean2) {
                return this.f19041a.compare(smsBean2.getStringDate(), smsBean.getStringDate());
            }
        }

        class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ List f19043a;

            b(List list) {
                this.f19043a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                SmsRecordSelectActivity smsRecordSelectActivity = SmsRecordSelectActivity.this;
                smsRecordSelectActivity.f19033a = new SmsSelectAdapter(R.layout.recyclerview_sms_select, this.f19043a, smsRecordSelectActivity.f19035c);
                SmsRecordSelectActivity.this.f19033a.a(SmsRecordSelectActivity.this.mRecyclerview);
                SmsRecordSelectActivity smsRecordSelectActivity2 = SmsRecordSelectActivity.this;
                smsRecordSelectActivity2.mRecyclerview.setAdapter(smsRecordSelectActivity2.f19033a);
                SmsRecordSelectActivity.this.f19033a.setOnItemClickListener(SmsRecordSelectActivity.this);
                SmsRecordSelectActivity.this.hideProgressDialog();
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            List arrayList = new ArrayList();
            int i2 = SmsRecordSelectActivity.this.f19037e;
            if (i2 == 1) {
                SmsRecordSelectActivity smsRecordSelectActivity = SmsRecordSelectActivity.this;
                List listA = smsRecordSelectActivity.a((Context) smsRecordSelectActivity);
                if (listA != null && listA.size() > 0) {
                    arrayList.addAll(listA);
                }
                List listC = SmsRecordSelectActivity.this.c();
                if (listC != null && listC.size() > 0) {
                    arrayList.addAll(listC);
                }
                if (arrayList.size() > 0) {
                    Collections.sort(arrayList, new C0286a(Collator.getInstance(Locale.CHINA)));
                }
            } else if (i2 == 2) {
                arrayList = SmsRecordSelectActivity.a((Activity) SmsRecordSelectActivity.this, false);
            }
            SmsRecordSelectActivity.this.runOnUiThread(new b(arrayList));
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SmsRecordSelectActivity.this.showDlogPrimssExcept();
        }
    }

    private void initData() {
        showProgressDialog();
        new Thread(new a()).start();
    }

    private void initView() {
        if (this.f19037e != 2) {
            this.mTvTitle.setText(R.string.sms_record_select);
        } else {
            this.mTvTitle.setText("浏览器历史记录选择");
        }
        if (TextUtils.equals(this.f19039g, f19032l)) {
            this.mBtnReport.setVisibility(8);
        }
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        this.f19037e = getIntent().getIntExtra(f19028h, 0);
        this.f19039g = getIntent().getStringExtra(f19031k);
        this.f19035c = (ArrayList) getIntent().getSerializableExtra(util.k1.u);
        initView();
        initData();
        try {
            this.f19038f = getIntent().getIntExtra("extra_select_can", 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            this.f19038f = 0;
        }
    }

    @OnClick({R.id.iv_back, R.id.btn_report})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.btn_report) {
            a();
        } else {
            if (id != R.id.iv_back) {
                return;
            }
            finish();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_call_record_select;
    }

    private static String b(Context context, String str) throws IOException {
        Uri uri = Uri.parse("content://mms/part/" + str);
        StringBuilder sb = new StringBuilder();
        InputStream inputStreamOpenInputStream = null;
        try {
            try {
                inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                if (inputStreamOpenInputStream != null) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpenInputStream, "UTF-8"));
                    for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                        sb.append(line);
                    }
                }
            } catch (IOException unused) {
                if (inputStreamOpenInputStream != null) {
                }
            } catch (Throwable th) {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }
        if (inputStreamOpenInputStream != null) {
            try {
                inputStreamOpenInputStream.close();
            } catch (IOException unused3) {
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<SmsBean> c() {
        try {
            ArrayList arrayList = new ArrayList();
            Cursor cursorQuery = getContentResolver().query(this.f19036d, new String[]{bl.f10170d, UserInfo.ADDRESS, "person", "body", "date", "type"}, null, null, "date desc");
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(UserInfo.ADDRESS));
                cursorQuery.getString(cursorQuery.getColumnIndex("person"));
                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("body"));
                arrayList.add(new SmsBean(string, string2, y1.a(Long.valueOf(Long.parseLong(cursorQuery.getString(cursorQuery.getColumnIndex("date")))), "yyyy-MM-dd HH:mm:ss"), false));
                Matcher matcher = Pattern.compile(" [a-zA-Z0-9]{10}").matcher(string2);
                if (matcher.find()) {
                    matcher.group().substring(1, 11);
                }
            }
            cursorQuery.close();
            return arrayList;
        } catch (Exception unused) {
            runOnUiThread(new b());
            return null;
        }
    }

    @Override // adapter.SmsSelectAdapter.b
    public void a(int i2, List<SmsBean> list, SmsBean smsBean) {
        try {
            SmsBean smsBean2 = list.get(i2);
            if (!smsBean2.isSelect()) {
                if (this.f19034b.size() == this.f19038f) {
                    util.w1.a("最多选择" + this.f19038f + "个");
                    return;
                }
                if (!this.f19034b.contains(smsBean2)) {
                    this.f19034b.add(smsBean2);
                }
                smsBean2.setSelect(true);
            } else {
                smsBean2.setSelect(false);
                this.f19034b.remove(smsBean2);
                if (smsBean != null && this.f19035c.contains(smsBean)) {
                    this.f19035c.remove(smsBean);
                }
            }
            this.f19033a.notifyDataSetChanged();
            if (TextUtils.equals(this.f19039g, f19032l)) {
                a();
            }
        } catch (Exception unused) {
        }
    }

    public static String b() {
        String str;
        if (Environment.getExternalStorageState().equals("mounted")) {
            if (y1.b()) {
                str = Hicore.getApp().getExternalFilesDir("").getAbsolutePath() + "/hicore_national/cache/";
            } else {
                str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/hicore_national/cache/";
            }
        } else {
            str = Hicore.getApp().getFilesDir().getAbsolutePath() + "/hicore_national/";
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    private void a() {
        List<SmsBean> list = this.f19035c;
        if (list != null && list.size() > 0) {
            this.f19034b.addAll(this.f19035c);
        }
        if (this.f19034b.size() != 0) {
            int i2 = this.f19037e;
            if (i2 == 1) {
                org.greenrobot.eventbus.c.f().d(new util.c2.a(302, this.f19034b));
            } else if (i2 == 2) {
                org.greenrobot.eventbus.c.f().d(new util.c2.a(13, this.f19034b));
            }
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<SmsBean> a(Context context) throws IOException {
        String string;
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = getContentResolver().query(Uri.parse("content://mms"), null, null, null, null);
        if (cursorQuery == null || !cursorQuery.moveToFirst()) {
            return arrayList;
        }
        do {
            SmsBean smsBean = new SmsBean();
            String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(bl.f10170d));
            String strA = a(this, string2);
            util.n1.a("彩信--phonenumber》" + strA);
            String strA2 = y1.a(Long.valueOf(((long) cursorQuery.getInt(cursorQuery.getColumnIndex("date"))) * 1000), "yyyy-MM-dd HH:mm:ss");
            String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("sub"));
            try {
                string3 = !TextUtils.isEmpty(string3) ? new String(string3.getBytes("ISO8859_1"), "UTF-8") : "";
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            Cursor cursorQuery2 = getContentResolver().query(Uri.parse("content://mms/part"), null, "mid=" + string2, null, null);
            if (cursorQuery2 != null) {
                if (cursorQuery2.moveToFirst()) {
                    do {
                        String string4 = cursorQuery2.getString(cursorQuery2.getColumnIndex("ct"));
                        util.n1.a("彩信--type》" + string4);
                        String lowerCase = string4.toLowerCase();
                        if ("text/plain".equals(lowerCase)) {
                            if (cursorQuery2.getString(cursorQuery2.getColumnIndex("_data")) != null) {
                                String strB = b(context, cursorQuery2.getString(cursorQuery2.getColumnIndex(bl.f10170d)));
                                util.n1.a("彩信--》" + string3 + "\n" + strB);
                                StringBuilder sb = new StringBuilder();
                                sb.append(string3);
                                sb.append(strB);
                                string = sb.toString();
                            } else {
                                String string5 = cursorQuery2.getString(cursorQuery2.getColumnIndex("text"));
                                util.n1.a("彩信--》" + string3 + "\n" + string5);
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(string3);
                                sb2.append(string5);
                                string = sb2.toString();
                            }
                            smsBean.setSmsContent(string);
                        } else if (lowerCase.contains("image")) {
                            Uri uri = Uri.parse("content://mms/part/" + cursorQuery2.getString(cursorQuery2.getColumnIndex(bl.f10170d)));
                            util.n1.b("partURI", "彩信==>" + uri.toString());
                            smsBean.setType(lowerCase);
                            smsBean.setFileUri(uri.toString());
                        }
                    } while (cursorQuery2.moveToNext());
                }
                if (!TextUtils.isEmpty(smsBean.getSmsContent())) {
                    smsBean.setSmsNum(strA);
                    smsBean.setStringDate(strA2);
                    arrayList.add(smsBean);
                }
            }
        } while (cursorQuery.moveToNext());
        return arrayList;
    }

    private static String a(Context context, String str) {
        String string;
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse(MessageFormat.format("content://mms/{0}/addr", str)), null, null, null, null);
        if (cursorQuery.moveToFirst()) {
            do {
                string = cursorQuery.getString(cursorQuery.getColumnIndex(UserInfo.ADDRESS));
                if (!TextUtils.isEmpty(string)) {
                    break;
                }
            } while (cursorQuery.moveToNext());
            string = "";
        } else {
            string = "";
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x0118 A[Catch: Exception -> 0x0114, TRY_LEAVE, TryCatch #9 {Exception -> 0x0114, blocks: (B:71:0x0110, B:75:0x0118), top: B:87:0x0110 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r8, java.lang.String r9, java.lang.String r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ui.activity.SmsRecordSelectActivity.a(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x009e A[Catch: Exception -> 0x009a, TRY_LEAVE, TryCatch #3 {Exception -> 0x009a, blocks: (B:49:0x0096, B:53:0x009e), top: B:59:0x0096 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r5, android.net.Uri r6, java.lang.String r7) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "saved_file"
            java.lang.String r1 = ".jpg"
            android.content.ContentResolver r5 = r5.getContentResolver()
            r2 = 0
            java.io.InputStream r5 = r5.openInputStream(r6)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L7a
            if (r5 != 0) goto L1a
            if (r5 == 0) goto L19
            r5.close()     // Catch: java.lang.Exception -> L15
            goto L19
        L15:
            r5 = move-exception
            r5.printStackTrace()
        L19:
            return
        L1a:
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            java.lang.String r3 = util.f1.b()     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            r4.<init>()     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            r4.append(r0)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            r4.append(r7)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            r4.append(r1)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            r6.<init>(r3, r7)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            java.lang.String r7 = r6.getPath()     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            java.lang.String r0 = "彩信"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            r1.<init>()     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            java.lang.String r3 = "彩信==>"
            r1.append(r3)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            r1.append(r7)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            java.lang.String r7 = r1.toString()     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            util.n1.b(r0, r7)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            r7.<init>(r6)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L6f
        L58:
            int r0 = r5.read(r6)     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L6f
            r1 = -1
            if (r0 == r1) goto L64
            r1 = 0
            r7.write(r6, r1, r0)     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L6f
            goto L58
        L64:
            if (r5 == 0) goto L69
            r5.close()     // Catch: java.lang.Exception -> L85
        L69:
            r7.close()     // Catch: java.lang.Exception -> L85
            goto L90
        L6d:
            r6 = move-exception
            goto L93
        L6f:
            r6 = move-exception
            goto L75
        L71:
            r6 = move-exception
            goto L94
        L73:
            r6 = move-exception
            r7 = r2
        L75:
            r2 = r5
            goto L7c
        L77:
            r6 = move-exception
            r5 = r2
            goto L94
        L7a:
            r6 = move-exception
            r7 = r2
        L7c:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L91
            if (r2 == 0) goto L87
            r2.close()     // Catch: java.lang.Exception -> L85
            goto L87
        L85:
            r5 = move-exception
            goto L8d
        L87:
            if (r7 == 0) goto L90
            r7.close()     // Catch: java.lang.Exception -> L85
            goto L90
        L8d:
            r5.printStackTrace()
        L90:
            return
        L91:
            r6 = move-exception
            r5 = r2
        L93:
            r2 = r7
        L94:
            if (r5 == 0) goto L9c
            r5.close()     // Catch: java.lang.Exception -> L9a
            goto L9c
        L9a:
            r5 = move-exception
            goto La2
        L9c:
            if (r2 == 0) goto La5
            r2.close()     // Catch: java.lang.Exception -> L9a
            goto La5
        La2:
            r5.printStackTrace()
        La5:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ui.activity.SmsRecordSelectActivity.a(android.content.Context, android.net.Uri, java.lang.String):void");
    }

    public static List<SmsBean> a(Activity activity, boolean z) {
        Uri uri = Uri.parse("content://browser/bookmarks");
        Uri.parse("content://com.android.chrome.browser/bookmarks");
        Uri.parse("content://com.sec.android.app.sbrowser.browser/bookmarks");
        String[] strArr = {"url", "title"};
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorLoadInBackground = new CursorLoader(activity, uri, strArr, null, null, null).loadInBackground();
            if (cursorLoadInBackground != null && cursorLoadInBackground.moveToFirst() && cursorLoadInBackground.getCount() > 0) {
                while (!cursorLoadInBackground.isAfterLast()) {
                    String string = cursorLoadInBackground.getString(0);
                    String string2 = cursorLoadInBackground.getString(1);
                    util.n1.e("urlIdx-->", string);
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                        arrayList.add(new SmsBean(string2, string, "", false));
                    }
                    util.n1.e("titleIdx-->", string2);
                    if (z && !TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                        break;
                    }
                    cursorLoadInBackground.moveToNext();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }
}
