package com.example.aidlservicetest;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable{
    private String name;//名字
    private int sex;//性别

    public Person(){}

    //从Parcel解析出Person
    protected Person(Parcel in) {
        readFromParcel(in);
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        //注意读取变量和写入变量的顺序应该一致 不然得不到正确的结果
        parcel.writeString(name);
        parcel.writeInt(sex);
    }

    //注意读取变量和写入变量的顺序应该一致 不然得不到正确的结果
    public void readFromParcel(Parcel source) {
        name = source.readString();
        sex = source.readInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "name=" + name +", sex=" + sex;
    }
}
