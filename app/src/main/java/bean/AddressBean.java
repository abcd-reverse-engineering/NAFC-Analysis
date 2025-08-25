package bean;

import b.a.a.d.d;
import b.a.a.d.e;
import b.a.a.d.k;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class AddressBean {
    private List<AddressBean> cityList;
    private String code;
    private String name;
    private List<AddressBean> townList;

    public static ArrayList<k> gainRegionData(List<AddressBean> list) {
        ArrayList<k> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < list.size(); i2++) {
            k kVar = new k();
            kVar.setAreaName(list.get(i2).getName());
            kVar.setAreaId(list.get(i2).getCode());
            ArrayList arrayList2 = new ArrayList();
            List<AddressBean> cityList = list.get(i2).getCityList();
            if (cityList == null || cityList.size() <= 0) {
                e eVar = new e();
                eVar.setAreaName(list.get(i2).getName());
                eVar.setAreaId(list.get(i2).getCode());
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(eVar);
                d dVar = new d();
                dVar.setAreaName(list.get(i2).getName());
                dVar.setAreaId(list.get(i2).getCode());
                dVar.setCounties(arrayList3);
                arrayList2.add(dVar);
            } else {
                for (int i3 = 0; i3 < cityList.size(); i3++) {
                    d dVar2 = new d();
                    dVar2.setAreaName(cityList.get(i3).getName());
                    dVar2.setAreaId(cityList.get(i3).getCode());
                    ArrayList arrayList4 = new ArrayList();
                    List<AddressBean> townList = cityList.get(i3).getTownList();
                    if (townList == null || townList.size() <= 0) {
                        e eVar2 = new e();
                        eVar2.setAreaName(cityList.get(i3).getName());
                        eVar2.setAreaId(cityList.get(i3).getCode());
                        arrayList4.add(eVar2);
                    } else {
                        for (int i4 = 0; i4 < townList.size(); i4++) {
                            e eVar3 = new e();
                            eVar3.setAreaName(townList.get(i4).getName());
                            eVar3.setAreaId(townList.get(i4).getCode());
                            arrayList4.add(eVar3);
                        }
                    }
                    dVar2.setCounties(arrayList4);
                    arrayList2.add(dVar2);
                }
            }
            kVar.setCities(arrayList2);
            arrayList.add(kVar);
        }
        e eVar4 = new e();
        eVar4.setAreaName("请选择");
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add(eVar4);
        d dVar3 = new d();
        dVar3.setAreaName("请选择");
        dVar3.setCounties(arrayList5);
        ArrayList arrayList6 = new ArrayList();
        arrayList6.add(dVar3);
        k kVar2 = new k();
        kVar2.setAreaName("请选择");
        kVar2.setCities(arrayList6);
        arrayList.add(0, kVar2);
        return arrayList;
    }

    public List<AddressBean> getCityList() {
        return this.cityList;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public List<AddressBean> getTownList() {
        return this.townList;
    }

    public void setCityList(List<AddressBean> list) {
        this.cityList = list;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setTownList(List<AddressBean> list) {
        this.townList = list;
    }
}
