package network;

/* loaded from: classes2.dex */
public interface IRequest<T> {
    void onErrorMiddle();

    void onNextMiddle(T t);

    void onStartMiddle();
}
