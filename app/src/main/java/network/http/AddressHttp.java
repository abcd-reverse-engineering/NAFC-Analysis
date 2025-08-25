package network.http;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.a.d.d;
import b.a.a.d.e;
import b.a.a.d.k;
import b.a.a.e.a;
import bean.AddressBean;
import bean.BaseAddressBean;
import com.hicorenational.antifraud.R;
import e.b;
import g.a.i0;
import g.a.u0.c;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.Hicore;
import ui.basemvp.BaseView;
import ui.model.ModelPresent;
import util.b1;
import util.f1;
import util.p1;
import util.w1;
import util.y1;

/* loaded from: classes2.dex */
public class AddressHttp extends ModelPresent {
    private static final String ADDRESS_FILE_NAME = "address.txt";
    private static final int MODE_DIALOG = 10;
    private static final int MODE_JUST_DATA = 11;
    private static final int REQUEST_TYPE_SILENCE = 1;
    public static final int REQUEST_TYPE_TIP = 2;
    private static Activity mActivity;
    private static ArrayList<k> mProvinceListData = new ArrayList<>();
    private static AddressHttp addressHttp = null;
    private static boolean notNeedRequest = false;

    public static class MyPicker implements a.e {
        @Override // b.a.a.e.a.e
        public void onAddressPicked(k kVar, d dVar, e eVar) {
        }

        public void onClear() {
        }

        public void onData(ArrayList<k> arrayList) {
        }
    }

    private AddressHttp() {
        super((Activity) null, (BaseView) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAPIData(final int i2, final int i3, final boolean z, final MyPicker myPicker) {
        String str = d.a.f13517c + b.f13569g;
        HashMap<String, String> map = new HashMap<>();
        map.put("areaVersion", getMaxAddressVersion() + "");
        regionHttp(map, str, new MiddleSubscriber<APIresult<BaseAddressBean>>() { // from class: network.http.AddressHttp.3
            @Override // network.MiddleSubscriber
            protected Type getType() {
                return BaseAddressBean.class;
            }

            @Override // network.MiddleSubscriber
            protected void onErrorMiddle(APIException aPIException) {
                AddressHttp.this.rearCallBack(i2, i3, z, myPicker);
            }

            @Override // network.MiddleSubscriber
            protected void onNextMiddle(APIresult<BaseAddressBean> aPIresult) {
                if (aPIresult == null || aPIresult.getCode() != 0) {
                    onErrorMiddle(APIException.getApiExcept());
                } else {
                    AddressHttp.this.successArea(aPIresult, i2, i3, z, myPicker);
                }
            }
        });
    }

    public static AddressHttp getAddSint(Activity activity) {
        mActivity = activity;
        if (addressHttp == null) {
            synchronized (AddressHttp.class) {
                if (addressHttp == null) {
                    addressHttp = new AddressHttp();
                }
            }
        }
        return addressHttp;
    }

    public static String getAddressJson() {
        return p1.a(p1.f20898h);
    }

    public static ArrayList<k> getAddressList(String str) {
        ArrayList arrayList = (ArrayList) new com.google.gson.e().a(str, new com.google.gson.d0.a<List<AddressBean>>() { // from class: network.http.AddressHttp.7
        }.getType());
        if (arrayList != null && arrayList.size() > 0) {
            return AddressBean.gainRegionData(arrayList);
        }
        w1.a("数据异常");
        return new ArrayList<>();
    }

    public static int getMaxAddressVersion() {
        return Math.max(1, p1.a(p1.f20899i, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getOSSArea(String str, final int i2, final int i3, final int i4, final boolean z, final MyPicker myPicker) {
        getAreaListOss(str, new i0<List<AddressBean>>() { // from class: network.http.AddressHttp.2
            @Override // g.a.i0
            public void onComplete() {
            }

            @Override // g.a.i0
            public void onError(Throwable th) {
                AddressHttp.this.getAPIData(i3, i4, z, myPicker);
            }

            @Override // g.a.i0
            public void onSubscribe(c cVar) {
            }

            @Override // g.a.i0
            public void onNext(List<AddressBean> list) {
                AddressHttp.this.successRequest();
                if (list == null || list.size() <= 0) {
                    onError(APIException.getApiExcept());
                    return;
                }
                AddressHttp.saveAddressJson(i2, new com.google.gson.e().a(list));
                ArrayList unused = AddressHttp.mProvinceListData = AddressBean.gainRegionData(list);
                AddressHttp.this.rearCallBack(i3, i4, z, myPicker);
            }
        });
    }

    public static void initAddressJson() {
        int iA = p1.a(p1.f20899i, 1);
        String addressJson = getAddressJson();
        if (1 > iA || (1 == iA && TextUtils.isEmpty(addressJson))) {
            p1.a(p1.f20898h, f1.c(ADDRESS_FILE_NAME));
        }
    }

    private boolean isNotNeedRequest() {
        return notNeedRequest;
    }

    private boolean isToday() {
        return TextUtils.equals(p1.a(p1.f20900j), y1.d("yyyy-MM-dd"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rearCallBack(int i2, int i3, boolean z, MyPicker myPicker) {
        ArrayList<k> arrayList;
        ArrayList<k> arrayList2 = mProvinceListData;
        if (arrayList2 == null || arrayList2.size() <= 0) {
            mProvinceListData = getAddressList(getAddressJson());
        }
        if (i2 == 2 && ((arrayList = mProvinceListData) == null || (arrayList != null && arrayList.size() <= 0))) {
            w1.a(Hicore.getApp().getResources().getString(R.string.err_system));
            return;
        }
        if (myPicker != null) {
            if (i3 == 10) {
                regionPick(z, myPicker);
            } else {
                if (i3 != 11) {
                    return;
                }
                myPicker.onData(mProvinceListData);
            }
        }
    }

    private void regionHttp(final int i2, final int i3, final boolean z, final MyPicker myPicker) {
        if (!isNotNeedRequest()) {
            String str = d.a.f13517c + b.f13570h;
            HashMap<String, String> map = new HashMap<>();
            map.put("areaVersion", getMaxAddressVersion() + "");
            regionHttp(map, str, new MiddleSubscriber<APIresult<BaseAddressBean>>() { // from class: network.http.AddressHttp.1
                @Override // network.MiddleSubscriber
                protected Type getType() {
                    return BaseAddressBean.class;
                }

                @Override // network.MiddleSubscriber
                protected void onErrorMiddle(APIException aPIException) {
                    AddressHttp.this.getAPIData(i2, i3, z, myPicker);
                }

                @Override // network.MiddleSubscriber
                protected void onNextMiddle(APIresult<BaseAddressBean> aPIresult) {
                    if (aPIresult == null || aPIresult.getCode() != 0) {
                        onErrorMiddle(APIException.getApiExcept());
                        return;
                    }
                    BaseAddressBean data = aPIresult.getData();
                    if (data.getIsRenew() != 1 || TextUtils.isEmpty(data.getOssPath())) {
                        AddressHttp.this.rearCallBack(i2, i3, z, myPicker);
                    } else {
                        AddressHttp.this.getOSSArea(data.getOssPath(), data.getAreaVersion(), i2, i3, z, myPicker);
                    }
                }

                @Override // network.MiddleSubscriber
                protected void onStartMiddle(c cVar) {
                    if (i2 == 2) {
                        b1.a("加载中...", true, AddressHttp.mActivity);
                    }
                }
            });
            return;
        }
        if (myPicker != null) {
            ArrayList<k> arrayList = mProvinceListData;
            if (arrayList == null || arrayList.size() <= 0) {
                mProvinceListData = getAddressList(getAddressJson());
            }
            if (i3 == 10) {
                regionPick(z, myPicker);
            } else {
                if (i3 != 11) {
                    return;
                }
                myPicker.onData(mProvinceListData);
            }
        }
    }

    public static void saveAddressJson(int i2, String str) {
        p1.b(p1.f20899i, i2);
        p1.a(p1.f20898h, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void successArea(APIresult<BaseAddressBean> aPIresult, int i2, int i3, boolean z, MyPicker myPicker) {
        successRequest();
        BaseAddressBean data = aPIresult.getData();
        if (data != null && data.getIsRenew() == 1 && data.getProvinceList() != null) {
            String string = data.getProvinceList().toString();
            ArrayList arrayList = (ArrayList) new com.google.gson.e().a(string, new com.google.gson.d0.a<List<AddressBean>>() { // from class: network.http.AddressHttp.4
            }.getType());
            if (arrayList != null && arrayList.size() > 0) {
                saveAddressJson(data.getAreaVersion(), string);
                mProvinceListData = getAddressList(string);
            }
        }
        rearCallBack(i2, i3, z, myPicker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void successRequest() {
        notNeedRequest = true;
    }

    private void updateDay() {
        p1.a(p1.f20900j, y1.d("yyyy-MM-dd"));
    }

    public ArrayList<k> getPickData() {
        ArrayList<k> arrayList = mProvinceListData;
        return (arrayList == null || arrayList.size() <= 0) ? getAddressList(getAddressJson()) : mProvinceListData;
    }

    public void regionPick(MyPicker myPicker) {
        regionHttp(1, 10, true, myPicker);
    }

    public void regionPickNoClear(MyPicker myPicker) {
        regionHttp(1, 10, false, myPicker);
    }

    private void regionPick(boolean z, final MyPicker myPicker) {
        Activity activity = mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        final a aVar = new a(mActivity, mProvinceListData);
        aVar.p(false);
        aVar.o(false);
        TextView textView = new TextView(aVar.d());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        if (z) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        textView.setText("清空");
        textView.setGravity(17);
        textView.setTextColor(mActivity.getResources().getColor(R.color.black));
        textView.setOnClickListener(new View.OnClickListener() { // from class: network.http.AddressHttp.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.a();
                myPicker.onClear();
            }
        });
        aVar.e(textView);
        aVar.A(mActivity.getResources().getColor(R.color.colorGray));
        aVar.k(mActivity.getResources().getColor(R.color.black));
        aVar.g(mActivity.getResources().getColor(R.color.colorGray));
        aVar.u(mActivity.getResources().getColor(R.color.colorGray));
        aVar.a(0.25f, 0.5f, 0.25f);
        aVar.setOnAddressPickListener(new a.e() { // from class: network.http.AddressHttp.6
            @Override // b.a.a.e.a.e
            public void onAddressPicked(k kVar, d dVar, e eVar) {
                if (myPicker == null || kVar == null || dVar == null || eVar == null || TextUtils.isEmpty(kVar.getAreaId()) || TextUtils.isEmpty(dVar.getAreaId()) || TextUtils.isEmpty(eVar.getAreaId())) {
                    return;
                }
                myPicker.onAddressPicked(kVar, dVar, eVar);
            }
        });
        aVar.m();
    }

    public void getPickData(MyPicker myPicker) {
        ArrayList<k> arrayList = mProvinceListData;
        if (arrayList != null && arrayList.size() > 0) {
            myPicker.onData(mProvinceListData);
        } else {
            regionHttp(2, 11, false, myPicker);
        }
    }
}
