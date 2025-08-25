package com.tencent.bugly.beta.upgrade;

import androidx.core.app.NotificationCompat;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.global.d;
import com.tencent.bugly.beta.utils.e;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.ah;
import com.tencent.bugly.proguard.aj;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.bi;
import com.tencent.bugly.proguard.bk;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.q;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import java.util.ArrayList;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class a implements aj {

    /* renamed from: a, reason: collision with root package name */
    public final int f8855a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8856b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f8857c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8858d = false;

    public a(int i2, int i3, Object... objArr) {
        this.f8855a = i2;
        this.f8856b = i3;
        this.f8857c = objArr;
    }

    @Override // com.tencent.bugly.proguard.aj
    public void a(int i2) {
    }

    @Override // com.tencent.bugly.proguard.aj
    public synchronized void a(int i2, bi biVar, long j2, long j3, boolean z, String str) {
        y yVar;
        bk bkVar;
        aa aaVar;
        aa aaVar2;
        try {
            if (!this.f8858d && i2 == this.f8856b) {
                Object[] objArr = new Object[4];
                objArr[0] = z ? "succ" : NotificationCompat.CATEGORY_ERROR;
                objArr[1] = Integer.valueOf(i2);
                objArr[2] = Long.valueOf(j2);
                objArr[3] = Long.valueOf(j3);
                an.a("upload %s:[%d] [sended %d] [recevied %d]", objArr);
                int i3 = this.f8855a;
                if (i3 == 1) {
                    boolean zBooleanValue = ((Boolean) this.f8857c[0]).booleanValue();
                    boolean zBooleanValue2 = ((Boolean) this.f8857c[1]).booleanValue();
                    if (this.f8856b != 804) {
                        return;
                    }
                    y yVar2 = null;
                    if (!z || biVar == null || (aaVar = (aa) ah.a(biVar.f9339c, aa.class)) == null) {
                        yVar = null;
                        bkVar = null;
                    } else {
                        bkVar = aaVar.f9163a;
                        yVar = aaVar.f9164b;
                    }
                    c.f8860a.a(bkVar);
                    BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) this.f8857c[2];
                    if (yVar != null) {
                        yVar2 = yVar;
                    } else if (betaGrayStrategy != null) {
                        yVar2 = betaGrayStrategy.f8848a;
                    }
                    if (yVar2 != null) {
                        int i4 = yVar2.p;
                        if (i4 == 1) {
                            c.f8860a.a(zBooleanValue, zBooleanValue2, z ? 0 : -1, yVar, str);
                        } else if (i4 != 2) {
                            if (i4 != 3) {
                                an.a("unexpected updatetype", new Object[0]);
                            } else {
                                q.f9424a.a(z ? 0 : -1, yVar, false);
                                if (c.f8860a.f8865f != null) {
                                    e.a(new d(18, c.f8860a.f8865f, 1, Boolean.valueOf(zBooleanValue)));
                                } else if (zBooleanValue && !zBooleanValue2) {
                                    e.a(new d(5, Beta.strToastYourAreTheLatestVersion));
                                }
                            }
                        }
                    } else if (c.f8860a.f8865f != null) {
                        e.a(new d(18, c.f8860a.f8865f, 1, Boolean.valueOf(zBooleanValue)));
                    } else if (zBooleanValue && !zBooleanValue2) {
                        e.a(new d(5, Beta.strToastYourAreTheLatestVersion));
                    }
                } else if (i3 == 2) {
                    x xVar = (x) this.f8857c[0];
                    if (this.f8856b == 803 && xVar != null && xVar.a() != null) {
                        if (z) {
                            if (biVar != null && (aaVar2 = (aa) ah.a(biVar.f9339c, aa.class)) != null) {
                                c.f8860a.a(aaVar2.f9163a);
                            }
                            ArrayList<w> arrayListA = xVar.a();
                            if (arrayListA.size() > 1) {
                                p.f9423a.b();
                            } else if (arrayListA.size() == 1) {
                                p.f9423a.a(arrayListA.get(0).f9465b);
                            }
                        }
                    }
                    return;
                }
                this.f8858d = true;
            }
        } catch (Exception e2) {
            if (!an.b(e2)) {
                e2.printStackTrace();
            }
        }
    }
}
