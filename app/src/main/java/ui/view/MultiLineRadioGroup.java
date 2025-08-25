package ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class MultiLineRadioGroup extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private int f20368a;

    /* renamed from: b, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f20369b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f20370c;

    /* renamed from: d, reason: collision with root package name */
    private d f20371d;

    /* renamed from: e, reason: collision with root package name */
    private e f20372e;

    private class b implements CompoundButton.OnCheckedChangeListener {
        private b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (MultiLineRadioGroup.this.f20370c) {
                return;
            }
            MultiLineRadioGroup.this.f20370c = true;
            if (MultiLineRadioGroup.this.f20368a != -1) {
                MultiLineRadioGroup multiLineRadioGroup = MultiLineRadioGroup.this;
                multiLineRadioGroup.a(multiLineRadioGroup.f20368a, false);
            }
            MultiLineRadioGroup.this.f20370c = false;
            MultiLineRadioGroup.this.setCheckedId(compoundButton.getId());
        }
    }

    public static class c extends LinearLayout.LayoutParams {
        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.view.ViewGroup.LayoutParams
        protected void setBaseAttributes(TypedArray typedArray, int i2, int i3) {
            if (typedArray.hasValue(i2)) {
                ((LinearLayout.LayoutParams) this).width = typedArray.getLayoutDimension(i2, "layout_width");
            } else {
                ((LinearLayout.LayoutParams) this).width = -2;
            }
            if (typedArray.hasValue(i3)) {
                ((LinearLayout.LayoutParams) this).height = typedArray.getLayoutDimension(i3, "layout_height");
            } else {
                ((LinearLayout.LayoutParams) this).height = -2;
            }
        }

        public c(int i2, int i3) {
            super(i2, i3);
        }

        public c(int i2, int i3, float f2) {
            super(i2, i3, f2);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public interface d {
        void a(MultiLineRadioGroup multiLineRadioGroup, int i2);
    }

    private class e implements ViewGroup.OnHierarchyChangeListener {

        /* renamed from: a, reason: collision with root package name */
        private ViewGroup.OnHierarchyChangeListener f20374a;

        private e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        @SuppressLint({"NewApi"})
        public void onChildViewAdded(View view, View view2) {
            List<RadioButton> listA;
            MultiLineRadioGroup multiLineRadioGroup = MultiLineRadioGroup.this;
            if (view == multiLineRadioGroup && (listA = multiLineRadioGroup.a(view2)) != null && listA.size() > 0) {
                for (RadioButton radioButton : listA) {
                    if (radioButton.getId() == -1 && Build.VERSION.SDK_INT >= 17) {
                        radioButton.setId(View.generateViewId());
                    }
                    radioButton.setOnCheckedChangeListener(MultiLineRadioGroup.this.f20369b);
                }
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f20374a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            List listA;
            MultiLineRadioGroup multiLineRadioGroup = MultiLineRadioGroup.this;
            if (view == multiLineRadioGroup && (listA = multiLineRadioGroup.a(view2)) != null && listA.size() > 0) {
                Iterator it = listA.iterator();
                while (it.hasNext()) {
                    ((RadioButton) it.next()).setOnCheckedChangeListener(null);
                }
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f20374a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public MultiLineRadioGroup(Context context) {
        super(context);
        this.f20368a = -1;
        this.f20370c = false;
        setOrientation(1);
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedId(int i2) {
        this.f20368a = i2;
        d dVar = this.f20371d;
        if (dVar != null) {
            dVar.a(this, this.f20368a);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        List<RadioButton> listA = a(view);
        if (listA != null && listA.size() > 0) {
            for (RadioButton radioButton : listA) {
                if (radioButton.isChecked()) {
                    this.f20370c = true;
                    int i3 = this.f20368a;
                    if (i3 != -1) {
                        a(i3, false);
                    }
                    this.f20370c = false;
                    setCheckedId(radioButton.getId());
                }
            }
        }
        super.addView(view, i2, layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    public int getCheckedRadioButtonId() {
        return this.f20368a;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(MultiLineRadioGroup.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(MultiLineRadioGroup.class.getName());
    }

    public void setCheckWithoutNotif(int i2) {
        if (i2 == -1 || i2 != this.f20368a) {
            this.f20370c = true;
            int i3 = this.f20368a;
            if (i3 != -1) {
                a(i3, false);
            }
            if (i2 != -1) {
                a(i2, true);
            }
            this.f20368a = i2;
            this.f20370c = false;
        }
    }

    public void setOnCheckedChangeListener(d dVar) {
        this.f20371d = dVar;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f20372e.f20374a = onHierarchyChangeListener;
    }

    private void b() {
        this.f20369b = new b();
        this.f20372e = new e();
        super.setOnHierarchyChangeListener(this.f20372e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new c(-2, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public MultiLineRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20368a = -1;
        this.f20370c = false;
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<RadioButton> a(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof RadioButton) {
            arrayList.add((RadioButton) view);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                arrayList.addAll(a(viewGroup.getChildAt(i2)));
            }
        }
        return arrayList;
    }

    public void a(int i2) {
        if (i2 == -1 || i2 != this.f20368a) {
            int i3 = this.f20368a;
            if (i3 != -1) {
                a(i3, false);
            }
            if (i2 != -1) {
                a(i2, true);
            }
            setCheckedId(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, boolean z) {
        View viewFindViewById = findViewById(i2);
        if (viewFindViewById == null || !(viewFindViewById instanceof RadioButton)) {
            return;
        }
        ((RadioButton) viewFindViewById).setChecked(z);
    }

    public void a() {
        a(-1);
    }
}
