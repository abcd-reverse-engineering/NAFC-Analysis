package androidx.collection;

/* loaded from: classes.dex */
public final class CircularArray<E> {
    private int mCapacityBitmask;
    private E[] mElements;
    private int mHead;
    private int mTail;

    public CircularArray() {
        this(8);
    }

    private void doubleCapacity() {
        E[] eArr = this.mElements;
        int length = eArr.length;
        int i2 = this.mHead;
        int i3 = length - i2;
        int i4 = length << 1;
        if (i4 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        E[] eArr2 = (E[]) new Object[i4];
        System.arraycopy(eArr, i2, eArr2, 0, i3);
        System.arraycopy(this.mElements, 0, eArr2, i3, this.mHead);
        this.mElements = eArr2;
        this.mHead = 0;
        this.mTail = length;
        this.mCapacityBitmask = i4 - 1;
    }

    public void addFirst(E e2) {
        this.mHead = (this.mHead - 1) & this.mCapacityBitmask;
        E[] eArr = this.mElements;
        int i2 = this.mHead;
        eArr[i2] = e2;
        if (i2 == this.mTail) {
            doubleCapacity();
        }
    }

    public void addLast(E e2) {
        E[] eArr = this.mElements;
        int i2 = this.mTail;
        eArr[i2] = e2;
        this.mTail = this.mCapacityBitmask & (i2 + 1);
        if (this.mTail == this.mHead) {
            doubleCapacity();
        }
    }

    public void clear() {
        removeFromStart(size());
    }

    public E get(int i2) {
        if (i2 < 0 || i2 >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.mElements[this.mCapacityBitmask & (this.mHead + i2)];
    }

    public E getFirst() {
        int i2 = this.mHead;
        if (i2 != this.mTail) {
            return this.mElements[i2];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E getLast() {
        int i2 = this.mHead;
        int i3 = this.mTail;
        if (i2 != i3) {
            return this.mElements[(i3 - 1) & this.mCapacityBitmask];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean isEmpty() {
        return this.mHead == this.mTail;
    }

    public E popFirst() {
        int i2 = this.mHead;
        if (i2 == this.mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E[] eArr = this.mElements;
        E e2 = eArr[i2];
        eArr[i2] = null;
        this.mHead = (i2 + 1) & this.mCapacityBitmask;
        return e2;
    }

    public E popLast() {
        int i2 = this.mHead;
        int i3 = this.mTail;
        if (i2 == i3) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i4 = this.mCapacityBitmask & (i3 - 1);
        E[] eArr = this.mElements;
        E e2 = eArr[i4];
        eArr[i4] = null;
        this.mTail = i4;
        return e2;
    }

    public void removeFromEnd(int i2) {
        int i3;
        if (i2 <= 0) {
            return;
        }
        if (i2 > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i4 = this.mTail;
        int i5 = i2 < i4 ? i4 - i2 : 0;
        int i6 = i5;
        while (true) {
            i3 = this.mTail;
            if (i6 >= i3) {
                break;
            }
            this.mElements[i6] = null;
            i6++;
        }
        int i7 = i3 - i5;
        int i8 = i2 - i7;
        this.mTail = i3 - i7;
        if (i8 > 0) {
            this.mTail = this.mElements.length;
            int i9 = this.mTail - i8;
            for (int i10 = i9; i10 < this.mTail; i10++) {
                this.mElements[i10] = null;
            }
            this.mTail = i9;
        }
    }

    public void removeFromStart(int i2) {
        if (i2 <= 0) {
            return;
        }
        if (i2 > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int length = this.mElements.length;
        int i3 = this.mHead;
        if (i2 < length - i3) {
            length = i3 + i2;
        }
        for (int i4 = this.mHead; i4 < length; i4++) {
            this.mElements[i4] = null;
        }
        int i5 = this.mHead;
        int i6 = length - i5;
        int i7 = i2 - i6;
        this.mHead = this.mCapacityBitmask & (i5 + i6);
        if (i7 > 0) {
            for (int i8 = 0; i8 < i7; i8++) {
                this.mElements[i8] = null;
            }
            this.mHead = i7;
        }
    }

    public int size() {
        return (this.mTail - this.mHead) & this.mCapacityBitmask;
    }

    public CircularArray(int i2) {
        if (i2 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i2 > 1073741824) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        i2 = Integer.bitCount(i2) != 1 ? Integer.highestOneBit(i2 - 1) << 1 : i2;
        this.mCapacityBitmask = i2 - 1;
        this.mElements = (E[]) new Object[i2];
    }
}
