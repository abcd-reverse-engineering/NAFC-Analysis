package ui.view;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import b.a.a.e.a;
import b.a.a.e.f;
import bean.PcodeRegionBean;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.List;
import network.http.AddressHttp;
import util.n1;
import util.w1;

/* loaded from: classes2.dex */
public class RegionWheelView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    protected b.a.a.d.k f20388a;

    /* renamed from: b, reason: collision with root package name */
    protected b.a.a.d.d f20389b;

    /* renamed from: c, reason: collision with root package name */
    protected b.a.a.d.e f20390c;

    /* renamed from: d, reason: collision with root package name */
    protected int f20391d;

    /* renamed from: e, reason: collision with root package name */
    protected int f20392e;

    /* renamed from: f, reason: collision with root package name */
    protected int f20393f;

    /* renamed from: g, reason: collision with root package name */
    protected f.k f20394g;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<b.a.a.d.k> f20395h;

    /* renamed from: i, reason: collision with root package name */
    private WheelView.c f20396i;

    /* renamed from: j, reason: collision with root package name */
    private WheelView f20397j;

    /* renamed from: k, reason: collision with root package name */
    private WheelView f20398k;

    /* renamed from: l, reason: collision with root package name */
    private WheelView f20399l;

    class a implements a.f {
        a() {
        }

        @Override // b.a.a.e.a.f
        public void a(int i2, b.a.a.d.k kVar) {
            if (kVar != null) {
                n1.a("province-->" + kVar.getAreaName());
            }
        }

        @Override // b.a.a.e.a.f
        public void a(int i2, b.a.a.d.d dVar) {
            if (dVar != null) {
                n1.a("city-->" + dVar.getAreaName());
            }
        }

        @Override // b.a.a.e.a.f
        public void a(int i2, b.a.a.d.e eVar) {
            if (eVar != null) {
                n1.a("county-->" + eVar.getAreaName());
            }
        }
    }

    class b implements WheelView.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a.f f20401a;

        b(a.f fVar) {
            this.f20401a = fVar;
        }

        @Override // cn.qqtheme.framework.widget.WheelView.g
        public void a(int i2) {
            RegionWheelView regionWheelView = RegionWheelView.this;
            regionWheelView.f20391d = i2;
            regionWheelView.f20388a = regionWheelView.getSelectedProvince();
            a.f fVar = this.f20401a;
            if (fVar != null) {
                RegionWheelView regionWheelView2 = RegionWheelView.this;
                fVar.a(regionWheelView2.f20391d, regionWheelView2.f20388a);
            }
            b.a.a.g.d.c(this, "change cities after province wheeled: index=" + i2);
            RegionWheelView regionWheelView3 = RegionWheelView.this;
            regionWheelView3.f20392e = 0;
            regionWheelView3.f20393f = 0;
            List<?> listA = regionWheelView3.f20394g.a(regionWheelView3.f20391d);
            if (listA.size() > 0) {
                RegionWheelView regionWheelView4 = RegionWheelView.this;
                regionWheelView4.f20389b = (b.a.a.d.d) listA.get(regionWheelView4.f20392e);
                RegionWheelView.this.f20398k.a(listA, RegionWheelView.this.f20392e);
            } else {
                RegionWheelView regionWheelView5 = RegionWheelView.this;
                regionWheelView5.f20389b = null;
                regionWheelView5.f20398k.setItems(new ArrayList());
            }
            RegionWheelView regionWheelView6 = RegionWheelView.this;
            List<?> listA2 = regionWheelView6.f20394g.a(regionWheelView6.f20391d, regionWheelView6.f20392e);
            if (listA2.size() > 0) {
                RegionWheelView regionWheelView7 = RegionWheelView.this;
                regionWheelView7.f20390c = (b.a.a.d.e) listA2.get(regionWheelView7.f20393f);
                RegionWheelView.this.f20399l.a(listA2, RegionWheelView.this.f20393f);
            } else {
                RegionWheelView regionWheelView8 = RegionWheelView.this;
                regionWheelView8.f20390c = null;
                regionWheelView8.f20399l.setItems(new ArrayList());
            }
        }
    }

    class c implements WheelView.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a.f f20403a;

        c(a.f fVar) {
            this.f20403a = fVar;
        }

        @Override // cn.qqtheme.framework.widget.WheelView.g
        public void a(int i2) {
            RegionWheelView regionWheelView = RegionWheelView.this;
            regionWheelView.f20392e = i2;
            regionWheelView.f20389b = regionWheelView.getSelectedCity();
            a.f fVar = this.f20403a;
            if (fVar != null) {
                RegionWheelView regionWheelView2 = RegionWheelView.this;
                fVar.a(regionWheelView2.f20392e, regionWheelView2.f20389b);
            }
            b.a.a.g.d.c(this, "change counties after city wheeled: index=" + i2);
            RegionWheelView regionWheelView3 = RegionWheelView.this;
            regionWheelView3.f20393f = 0;
            List<?> listA = regionWheelView3.f20394g.a(regionWheelView3.f20391d, regionWheelView3.f20392e);
            if (listA.size() > 0) {
                RegionWheelView regionWheelView4 = RegionWheelView.this;
                regionWheelView4.f20390c = (b.a.a.d.e) listA.get(regionWheelView4.f20393f);
                RegionWheelView.this.f20399l.a(listA, RegionWheelView.this.f20393f);
            } else {
                RegionWheelView regionWheelView5 = RegionWheelView.this;
                regionWheelView5.f20390c = null;
                regionWheelView5.f20399l.setItems(new ArrayList());
            }
        }
    }

    class d implements WheelView.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a.f f20405a;

        d(a.f fVar) {
            this.f20405a = fVar;
        }

        @Override // cn.qqtheme.framework.widget.WheelView.g
        public void a(int i2) {
            RegionWheelView regionWheelView = RegionWheelView.this;
            regionWheelView.f20393f = i2;
            regionWheelView.f20390c = regionWheelView.getSelectedCounty();
            a.f fVar = this.f20405a;
            if (fVar != null) {
                RegionWheelView regionWheelView2 = RegionWheelView.this;
                fVar.a(regionWheelView2.f20393f, regionWheelView2.f20390c);
            }
        }
    }

    private static class e implements f.k<b.a.a.d.k, b.a.a.d.d, b.a.a.d.e> {

        /* renamed from: a, reason: collision with root package name */
        private List<b.a.a.d.k> f20407a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        private List<List<b.a.a.d.d>> f20408b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        private List<List<List<b.a.a.d.e>>> f20409c = new ArrayList();

        e(List<b.a.a.d.k> list) {
            a(list);
        }

        @Override // b.a.a.e.f.k
        @NonNull
        public List<b.a.a.d.k> a() {
            return this.f20407a;
        }

        @Override // b.a.a.e.f.k
        public boolean b() {
            return false;
        }

        @Override // b.a.a.e.f.k
        @NonNull
        public List<b.a.a.d.d> a(int i2) {
            return this.f20408b.size() <= i2 ? new ArrayList() : this.f20408b.get(i2);
        }

        @Override // b.a.a.e.f.k
        @NonNull
        public List<b.a.a.d.e> a(int i2, int i3) {
            if (this.f20409c.size() <= i2) {
                return new ArrayList();
            }
            List<List<b.a.a.d.e>> list = this.f20409c.get(i2);
            if (list.size() <= i3) {
                return new ArrayList();
            }
            return list.get(i3);
        }

        private void a(List<b.a.a.d.k> list) {
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                b.a.a.d.k kVar = list.get(i2);
                this.f20407a.add(kVar);
                List<b.a.a.d.d> cities = kVar.getCities();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int size2 = cities.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    b.a.a.d.d dVar = cities.get(i3);
                    dVar.setProvinceId(kVar.getAreaId());
                    arrayList.add(dVar);
                    List<b.a.a.d.e> counties = dVar.getCounties();
                    ArrayList arrayList3 = new ArrayList();
                    int size3 = counties.size();
                    int i4 = 0;
                    while (i4 < size3) {
                        b.a.a.d.e eVar = counties.get(i4);
                        eVar.setCityId(dVar.getAreaId());
                        arrayList3.add(eVar);
                        i4++;
                        size = size;
                    }
                    arrayList2.add(arrayList3);
                }
                this.f20408b.add(arrayList);
                this.f20409c.add(arrayList2);
                i2++;
                size = size;
            }
        }
    }

    public RegionWheelView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b.a.a.d.d getSelectedCity() {
        List<b.a.a.d.d> cities = getSelectedProvince().getCities();
        if (cities.size() == 0) {
            return null;
        }
        try {
            return cities.get(this.f20392e);
        } catch (Exception unused) {
            return cities.get(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b.a.a.d.e getSelectedCounty() {
        b.a.a.d.d selectedCity = getSelectedCity();
        if (selectedCity == null) {
            return null;
        }
        List<b.a.a.d.e> counties = selectedCity.getCounties();
        if (counties.size() == 0) {
            return null;
        }
        try {
            return counties.get(this.f20393f);
        } catch (Exception unused) {
            return counties.get(0);
        }
    }

    public b.a.a.d.d getCity() {
        return this.f20389b;
    }

    public b.a.a.d.e getCounty() {
        return this.f20390c;
    }

    public b.a.a.d.k getProvince() {
        return this.f20388a;
    }

    public b.a.a.d.k getSelectedProvince() {
        try {
            return this.f20395h.get(this.f20391d);
        } catch (Exception unused) {
            return new b.a.a.d.k();
        }
    }

    public void setSelectIndex(PcodeRegionBean pcodeRegionBean) {
        ArrayList<b.a.a.d.k> arrayList;
        if (pcodeRegionBean == null || this.f20394g == null || (arrayList = this.f20395h) == null || arrayList.size() <= 0) {
            return;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f20395h.size(); i3++) {
            if (TextUtils.equals(this.f20395h.get(i3).getAreaId(), pcodeRegionBean.getProvinceId())) {
                this.f20391d = i3;
                WheelView wheelView = this.f20397j;
                if (wheelView != null) {
                    wheelView.a(this.f20394g.a(), this.f20391d);
                }
                List listA = this.f20394g.a(i3);
                if (listA == null || listA.size() <= 0) {
                    return;
                }
                String cityId = pcodeRegionBean.getCityId();
                for (int i4 = 0; i4 < listA.size(); i4++) {
                    if (TextUtils.equals(((b.a.a.d.d) listA.get(i4)).getAreaId(), cityId)) {
                        this.f20392e = i4;
                        WheelView wheelView2 = this.f20398k;
                        if (wheelView2 != null) {
                            wheelView2.a(this.f20394g.a(this.f20391d), this.f20392e);
                        }
                        List listA2 = this.f20394g.a(i3, i4);
                        if (listA2 == null || listA2.size() <= 0) {
                            return;
                        }
                        String districtId = pcodeRegionBean.getDistrictId();
                        while (true) {
                            if (i2 >= listA2.size()) {
                                break;
                            }
                            if (TextUtils.equals(((b.a.a.d.e) listA2.get(i2)).getAreaId(), districtId)) {
                                this.f20393f = i2;
                                this.f20390c = (b.a.a.d.e) listA2.get(i2);
                                break;
                            }
                            i2++;
                        }
                        WheelView wheelView3 = this.f20399l;
                        if (wheelView3 != null) {
                            wheelView3.a(this.f20394g.a(this.f20391d, this.f20392e), this.f20393f);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
    }

    public RegionWheelView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20388a = null;
        this.f20389b = null;
        this.f20390c = null;
        this.f20391d = 0;
        this.f20392e = 0;
        this.f20393f = 0;
        this.f20395h = new ArrayList<>();
        this.f20396i = new WheelView.c();
        b(context);
    }

    private void b(Context context) {
        this.f20395h = AddressHttp.getAddSint(null).getPickData();
        this.f20394g = new e(this.f20395h);
        addView(a(context, new a()));
    }

    public void a() {
        a(AddressHttp.getAddSint(null).getPickData());
    }

    public void a(ArrayList<b.a.a.d.k> arrayList) {
        String areaName;
        String areaId = "";
        if (arrayList != null || arrayList.size() > 0) {
            b.a.a.d.e county = getCounty();
            this.f20395h = arrayList;
            this.f20394g = new e(this.f20395h);
            if (this.f20397j == null || this.f20398k == null || this.f20399l == null) {
                return;
            }
            try {
                areaName = this.f20395h.get(this.f20391d).getCities().get(this.f20392e).getCounties().get(this.f20393f).getAreaName();
                try {
                    areaId = this.f20395h.get(this.f20391d).getCities().get(this.f20392e).getCounties().get(this.f20393f).getAreaId();
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (county != null) {
                        this.f20391d = 0;
                        this.f20392e = 0;
                        this.f20393f = 0;
                        w1.a("请重新选择");
                    }
                    this.f20397j.a(this.f20394g.a(), this.f20391d);
                    this.f20398k.a(this.f20394g.a(this.f20391d), this.f20392e);
                    this.f20399l.a(this.f20394g.a(this.f20391d, this.f20392e), this.f20393f);
                }
            } catch (Exception e3) {
                e = e3;
                areaName = "";
            }
            if (county != null && (!TextUtils.equals(county.getAreaName(), areaName) || !TextUtils.equals(county.getAreaId(), areaId))) {
                this.f20391d = 0;
                this.f20392e = 0;
                this.f20393f = 0;
                w1.a("请重新选择");
            }
            this.f20397j.a(this.f20394g.a(), this.f20391d);
            this.f20398k.a(this.f20394g.a(this.f20391d), this.f20392e);
            this.f20399l.a(this.f20394g.a(this.f20391d, this.f20392e), this.f20393f);
        }
    }

    private void b() {
        this.f20396i.a(true);
        this.f20396i.d(-1);
        this.f20396i.c(100);
        this.f20396i.b(true);
        this.f20396i.a(0.0f);
    }

    protected WheelView a(Context context) {
        WheelView wheelView = new WheelView(context);
        wheelView.setLineSpaceMultiplier(2.0f);
        wheelView.setTextPadding(-1);
        wheelView.setTextSize(16.0f);
        wheelView.setTypeface(Typeface.DEFAULT);
        wheelView.a(WheelView.i0, ViewCompat.MEASURED_STATE_MASK);
        wheelView.setDividerConfig(this.f20396i);
        wheelView.setOffset(4);
        wheelView.setCycleDisable(true);
        wheelView.setUseWeight(true);
        wheelView.setTextSizeAutoFit(true);
        return wheelView;
    }

    public void setSelectIndex(String str) {
        try {
            if (str.length() == 6) {
                PcodeRegionBean pcodeRegionBean = new PcodeRegionBean();
                pcodeRegionBean.setProvinceId(str.substring(0, 2));
                pcodeRegionBean.setCityId(str.substring(0, 4));
                pcodeRegionBean.setDistrictId(str);
                setSelectIndex(pcodeRegionBean);
            }
        } catch (Exception unused) {
        }
    }

    protected View a(Context context, a.f fVar) {
        b();
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        this.f20397j = a(context);
        this.f20397j.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(this.f20397j);
        this.f20398k = a(context);
        this.f20398k.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(this.f20398k);
        this.f20399l = a(context);
        this.f20399l.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(this.f20399l);
        this.f20397j.a(this.f20394g.a(), this.f20391d);
        this.f20397j.setOnItemSelectListener(new b(fVar));
        this.f20398k.a(this.f20394g.a(this.f20391d), this.f20392e);
        this.f20398k.setOnItemSelectListener(new c(fVar));
        this.f20399l.a(this.f20394g.a(this.f20391d, this.f20392e), this.f20393f);
        this.f20399l.setOnItemSelectListener(new d(fVar));
        if (this.f20389b == null && this.f20394g.a(0).size() > 0) {
            this.f20389b = (b.a.a.d.d) this.f20394g.a(0).get(0);
        }
        if (this.f20390c == null && this.f20394g.a(0, 0).size() > 0) {
            this.f20390c = (b.a.a.d.e) this.f20394g.a(0, 0).get(0);
        }
        return linearLayout;
    }
}
