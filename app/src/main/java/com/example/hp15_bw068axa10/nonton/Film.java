package com.example.hp15_bw068axa10.nonton;

import android.os.Parcel;
import android.os.Parcelable;

public class Film implements Parcelable {
    private int photo;
    private String name;
    private  String description;

    private Film(Parcel in) {
        photo = in.readInt();
        name = in.readString();
        description = in.readString();
    }

    public static final Creator<Film> CREATOR = new Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel in) {
            return new Film(in);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };

    public Film() {

    }

    public int getPhoto() { return photo; }

    public void setPhoto(int photo) { this.photo = photo; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(photo);
        dest.writeString(name);
        dest.writeString(description);
    }
}
