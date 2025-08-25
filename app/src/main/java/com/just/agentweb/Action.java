package com.just.agentweb;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public class Action implements Parcelable {
    public static final transient int ACTION_CAMERA = 3;
    public static final transient int ACTION_FILE = 2;
    public static final transient int ACTION_PERMISSION = 1;
    public static final transient int ACTION_VIDEO = 4;
    public static final Parcelable.Creator<Action> CREATOR = new Parcelable.Creator<Action>() { // from class: com.just.agentweb.Action.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Action createFromParcel(Parcel parcel) {
            return new Action(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Action[] newArray(int i2) {
            return new Action[i2];
        }
    };
    private int mAction;
    private int mFromIntention;
    private ArrayList<String> mPermissions;

    public Action() {
        this.mPermissions = new ArrayList<>();
    }

    public static Action createPermissionsAction(String[] strArr) {
        Action action = new Action();
        action.setAction(1);
        action.setPermissions(new ArrayList<>(Arrays.asList(strArr)));
        return action;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAction() {
        return this.mAction;
    }

    public int getFromIntention() {
        return this.mFromIntention;
    }

    public ArrayList<String> getPermissions() {
        return this.mPermissions;
    }

    public void setAction(int i2) {
        this.mAction = i2;
    }

    public Action setFromIntention(int i2) {
        this.mFromIntention = i2;
        return this;
    }

    public void setPermissions(ArrayList<String> arrayList) {
        this.mPermissions = arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStringList(this.mPermissions);
        parcel.writeInt(this.mAction);
        parcel.writeInt(this.mFromIntention);
    }

    public void setPermissions(String[] strArr) {
        this.mPermissions = new ArrayList<>(Arrays.asList(strArr));
    }

    protected Action(Parcel parcel) {
        this.mPermissions = new ArrayList<>();
        this.mPermissions = parcel.createStringArrayList();
        this.mAction = parcel.readInt();
        this.mFromIntention = parcel.readInt();
    }
}
