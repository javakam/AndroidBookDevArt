package com.art.exploration.Chapter2.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by machangbao on 2018/4/11.
 */
public class User implements Parcelable {

    public int userId;
    public String userName;
    public boolean isMale;

    public Book book;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.userId);
        dest.writeString(this.userName);
        dest.writeByte(this.isMale ? (byte) 1 : (byte) 0);
        dest.writeParcelable(this.book, flags);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.userId = in.readInt();
        this.userName = in.readString();
        this.isMale = in.readByte() != 0;
        this.book = in.readParcelable(Book.class.getClassLoader());
        // or
//        this.book = in.readParcelable(Thread.currentThread().getContextClassLoader());
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
