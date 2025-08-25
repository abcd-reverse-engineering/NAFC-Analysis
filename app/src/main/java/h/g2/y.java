package h.g2;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Collections.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a@\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u00072\u0006\u0010\f\u001a\u00020\u00062!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\u00070\u000eH\u0087\b\u001a@\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\b\u0000\u0010\u00072\u0006\u0010\f\u001a\u00020\u00062!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\u00070\u000eH\u0087\b\u001a\u001f\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u0002H\u00070\u0015j\b\u0012\u0004\u0012\u0002H\u0007`\u0016\"\u0004\b\u0000\u0010\u0007H\u0087\b\u001a5\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u0002H\u00070\u0015j\b\u0012\u0004\u0012\u0002H\u0007`\u0016\"\u0004\b\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010\u0019\u001aK\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001b0\b\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u001f\b\u0001\u0010\u001d\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u0013\u0012\u0004\u0012\u00020\u001e0\u000e¢\u0006\u0002\b\u001fH\u0087\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001aC\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001b0\b\"\u0004\b\u0000\u0010\u001b2\u001f\b\u0001\u0010\u001d\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u0013\u0012\u0004\u0012\u00020\u001e0\u000e¢\u0006\u0002\b\u001fH\u0087\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\u0012\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007\u001a\u0015\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007H\u0087\b\u001a+\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010\"\u001a%\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\b\b\u0000\u0010\u0007*\u00020$2\b\u0010%\u001a\u0004\u0018\u0001H\u0007¢\u0006\u0002\u0010&\u001a3\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\b\b\u0000\u0010\u0007*\u00020$2\u0016\u0010\u0017\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00070\u0018\"\u0004\u0018\u0001H\u0007¢\u0006\u0002\u0010\"\u001a\u0015\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\b\u0000\u0010\u0007H\u0087\b\u001a+\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\b\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010\"\u001a%\u0010(\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0006H\u0002¢\u0006\u0002\b+\u001a\b\u0010,\u001a\u00020\u001eH\u0001\u001a\b\u0010-\u001a\u00020\u001eH\u0001\u001a%\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0002\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018H\u0000¢\u0006\u0002\u0010/\u001aS\u00100\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b2\u0006\u0010%\u001a\u0002H\u00072\u001a\u00101\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000702j\n\u0012\u0006\b\u0000\u0012\u0002H\u0007`32\b\b\u0002\u0010)\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u0006¢\u0006\u0002\u00104\u001a>\u00100\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b2\b\b\u0002\u0010)\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u00062\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00060\u000e\u001aE\u00100\u001a\u00020\u0006\"\u000e\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u000706*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00070\b2\b\u0010%\u001a\u0004\u0018\u0001H\u00072\b\b\u0002\u0010)\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u0006¢\u0006\u0002\u00107\u001ad\u00108\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\u000e\b\u0001\u00109*\b\u0012\u0004\u0012\u0002H906*\b\u0012\u0004\u0012\u0002H\u00070\b2\b\u0010:\u001a\u0004\u0018\u0001H92\b\b\u0002\u0010)\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u00062\u0016\b\u0004\u0010;\u001a\u0010\u0012\u0004\u0012\u0002H\u0007\u0012\u0006\u0012\u0004\u0018\u0001H90\u000eH\u0086\b¢\u0006\u0002\u0010<\u001a,\u0010=\u001a\u00020>\"\t\b\u0000\u0010\u0007¢\u0006\u0002\b?*\b\u0012\u0004\u0012\u0002H\u00070\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0002H\u0087\b\u001a8\u0010@\u001a\u0002HA\"\u0010\b\u0000\u0010B*\u0006\u0012\u0002\b\u00030\u0002*\u0002HA\"\u0004\b\u0001\u0010A*\u0002HB2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002HA0DH\u0087\b¢\u0006\u0002\u0010E\u001a\u0019\u0010F\u001a\u00020>\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0002H\u0087\b\u001a,\u0010G\u001a\u00020>\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\u001e\u0010H\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\bH\u0000\u001a!\u0010I\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0002\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0002H\u0087\b\u001a!\u0010I\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\bH\u0087\b\"\u0019\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"!\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006J"}, d2 = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/util/Collection;)Lkotlin/ranges/IntRange;", "lastIndex", "", ExifInterface.GPS_DIRECTION_TRUE, "", "getLastIndex", "(Ljava/util/List;)I", "List", "size", "init", "Lkotlin/Function1;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "index", "MutableList", "", "arrayListOf", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "elements", "", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "buildList", ExifInterface.LONGITUDE_EAST, "capacity", "builderAction", "", "Lkotlin/ExtensionFunctionType;", "emptyList", "listOf", "([Ljava/lang/Object;)Ljava/util/List;", "listOfNotNull", "", "element", "(Ljava/lang/Object;)Ljava/util/List;", "mutableListOf", "rangeCheck", "fromIndex", "toIndex", "rangeCheck$CollectionsKt__CollectionsKt", "throwCountOverflow", "throwIndexOverflow", "asCollection", "([Ljava/lang/Object;)Ljava/util/Collection;", "binarySearch", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;II)I", "comparison", "", "(Ljava/util/List;Ljava/lang/Comparable;II)I", "binarySearchBy", "K", "key", "selector", "(Ljava/util/List;Ljava/lang/Comparable;IILkotlin/jvm/functions/Function1;)I", "containsAll", "", "Lkotlin/internal/OnlyInputTypes;", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "isNullOrEmpty", "optimizeReadOnlyList", "orEmpty", "kotlin-stdlib"}, k = 5, mv = {1, 1, 16}, xi = 1, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes2.dex */
public class y extends x {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Collections.kt */
    public static final class a<T> extends h.q2.t.j0 implements h.q2.s.l<T, Integer> {
        final /* synthetic */ Comparable $key;
        final /* synthetic */ h.q2.s.l $selector;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h.q2.s.l lVar, Comparable comparable) {
            super(1);
            this.$selector = lVar;
            this.$key = comparable;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2(T t) {
            return h.h2.b.a((Comparable) this.$selector.invoke(t), this.$key);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.q2.s.l
        public /* bridge */ /* synthetic */ Integer invoke(Object obj) {
            return Integer.valueOf(invoke2((a<T>) obj));
        }
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final <T> ArrayList<T> a() {
        return new ArrayList<>();
    }

    @i.c.a.d
    public static final <T> Collection<T> b(@i.c.a.d T[] tArr) {
        h.q2.t.i0.f(tArr, "$this$asCollection");
        return new k(tArr, false);
    }

    @i.c.a.d
    public static <T> List<T> c(@i.c.a.d T... tArr) {
        h.q2.t.i0.f(tArr, "elements");
        return tArr.length > 0 ? q.d((Object[]) tArr) : b();
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final <T> List<T> d() {
        return new ArrayList();
    }

    @i.c.a.d
    public static <T> List<T> e(@i.c.a.d T... tArr) {
        h.q2.t.i0.f(tArr, "elements");
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new k(tArr, true));
    }

    @h.t0(version = "1.3")
    @h.n0
    public static void f() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    @i.c.a.d
    public static final <T> ArrayList<T> a(@i.c.a.d T... tArr) {
        h.q2.t.i0.f(tArr, "elements");
        return tArr.length == 0 ? new ArrayList<>() : new ArrayList<>(new k(tArr, true));
    }

    @i.c.a.d
    public static <T> List<T> b() {
        return j0.INSTANCE;
    }

    @h.m2.f
    private static final <T> List<T> c() {
        return b();
    }

    @i.c.a.d
    public static final <T> List<T> d(@i.c.a.d T... tArr) {
        h.q2.t.i0.f(tArr, "elements");
        return r.q(tArr);
    }

    @h.t0(version = "1.3")
    @h.n0
    public static void e() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final <T> List<T> a(int i2, h.q2.s.l<? super Integer, ? extends T> lVar) {
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(lVar.invoke(Integer.valueOf(i3)));
        }
        return arrayList;
    }

    @i.c.a.d
    public static final <T> List<T> b(@i.c.a.e T t) {
        return t != null ? x.a(t) : b();
    }

    @h.m2.f
    @h.t0(version = "1.3")
    @h.j
    private static final <E> List<E> c(int i2, @h.b h.q2.s.l<? super List<E>, h.y1> lVar) {
        ArrayList arrayList = new ArrayList(i2);
        lVar.invoke(arrayList);
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.m2.f
    private static final <T> Collection<T> d(@i.c.a.e Collection<? extends T> collection) {
        return collection != 0 ? collection : b();
    }

    @h.m2.f
    @h.t0(version = "1.3")
    @h.j
    private static final <E> List<E> a(@h.b h.q2.s.l<? super List<E>, h.y1> lVar) {
        ArrayList arrayList = new ArrayList();
        lVar.invoke(arrayList);
        return arrayList;
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final <T> List<T> b(int i2, h.q2.s.l<? super Integer, ? extends T> lVar) {
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(lVar.invoke(Integer.valueOf(i3)));
        }
        return arrayList;
    }

    @h.m2.f
    @h.t0(version = "1.3")
    private static final <T> boolean c(@i.c.a.e Collection<? extends T> collection) {
        return collection == null || collection.isEmpty();
    }

    @i.c.a.d
    public static h.v2.k a(@i.c.a.d Collection<?> collection) {
        h.q2.t.i0.f(collection, "$this$indices");
        return new h.v2.k(0, collection.size() - 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.m2.f
    private static final <T> List<T> c(@i.c.a.e List<? extends T> list) {
        return list != 0 ? list : b();
    }

    public static <T> int a(@i.c.a.d List<? extends T> list) {
        h.q2.t.i0.f(list, "$this$lastIndex");
        return list.size() - 1;
    }

    @h.m2.f
    private static final <T> boolean b(@i.c.a.d Collection<? extends T> collection) {
        return !collection.isEmpty();
    }

    /* JADX WARN: Incorrect types in method signature: <C::Ljava/util/Collection<*>;:TR;R:Ljava/lang/Object;>(TC;Lh/q2/s/a<+TR;>;)TR; */
    @h.m2.f
    @h.t0(version = "1.3")
    private static final Object a(Collection collection, h.q2.s.a aVar) {
        return collection.isEmpty() ? aVar.invoke() : collection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @i.c.a.d
    public static <T> List<T> b(@i.c.a.d List<? extends T> list) {
        h.q2.t.i0.f(list, "$this$optimizeReadOnlyList");
        int size = list.size();
        if (size != 0) {
            return size != 1 ? list : x.a(list.get(0));
        }
        return b();
    }

    @h.m2.f
    private static final <T> boolean a(@i.c.a.d Collection<? extends T> collection, Collection<? extends T> collection2) {
        return collection.containsAll(collection2);
    }

    public static /* synthetic */ int a(List list, Comparable comparable, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = list.size();
        }
        return a((List<? extends Comparable>) list, comparable, i2, i3);
    }

    public static final <T extends Comparable<? super T>> int a(@i.c.a.d List<? extends T> list, @i.c.a.e T t, int i2, int i3) {
        h.q2.t.i0.f(list, "$this$binarySearch");
        a(list.size(), i2, i3);
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int iA = h.h2.b.a(list.get(i5), t);
            if (iA < 0) {
                i2 = i5 + 1;
            } else {
                if (iA <= 0) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static /* synthetic */ int a(List list, Object obj, Comparator comparator, int i2, int i3, int i4, Object obj2) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = list.size();
        }
        return a((List<? extends Object>) list, obj, (Comparator<? super Object>) comparator, i2, i3);
    }

    public static final <T> int a(@i.c.a.d List<? extends T> list, T t, @i.c.a.d Comparator<? super T> comparator, int i2, int i3) {
        h.q2.t.i0.f(list, "$this$binarySearch");
        h.q2.t.i0.f(comparator, "comparator");
        a(list.size(), i2, i3);
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int iCompare = comparator.compare(list.get(i5), t);
            if (iCompare < 0) {
                i2 = i5 + 1;
            } else {
                if (iCompare <= 0) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static /* synthetic */ int a(List list, Comparable comparable, int i2, int i3, h.q2.s.l lVar, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = list.size();
        }
        h.q2.t.i0.f(list, "$this$binarySearchBy");
        h.q2.t.i0.f(lVar, "selector");
        return a(list, i2, i3, new a(lVar, comparable));
    }

    public static final <T, K extends Comparable<? super K>> int a(@i.c.a.d List<? extends T> list, @i.c.a.e K k2, int i2, int i3, @i.c.a.d h.q2.s.l<? super T, ? extends K> lVar) {
        h.q2.t.i0.f(list, "$this$binarySearchBy");
        h.q2.t.i0.f(lVar, "selector");
        return a(list, i2, i3, new a(lVar, k2));
    }

    public static /* synthetic */ int a(List list, int i2, int i3, h.q2.s.l lVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = list.size();
        }
        return a(list, i2, i3, lVar);
    }

    public static final <T> int a(@i.c.a.d List<? extends T> list, int i2, int i3, @i.c.a.d h.q2.s.l<? super T, Integer> lVar) {
        h.q2.t.i0.f(list, "$this$binarySearch");
        h.q2.t.i0.f(lVar, "comparison");
        a(list.size(), i2, i3);
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int iIntValue = lVar.invoke(list.get(i5)).intValue();
            if (iIntValue < 0) {
                i2 = i5 + 1;
            } else {
                if (iIntValue <= 0) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    private static final void a(int i2, int i3, int i4) {
        if (i3 > i4) {
            throw new IllegalArgumentException("fromIndex (" + i3 + ") is greater than toIndex (" + i4 + ").");
        }
        if (i3 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i3 + ") is less than zero.");
        }
        if (i4 <= i2) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i4 + ") is greater than size (" + i2 + ").");
    }
}
