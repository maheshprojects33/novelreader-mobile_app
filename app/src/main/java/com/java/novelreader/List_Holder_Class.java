package com.java.novelreader;


import android.os.Parcel;
import android.os.Parcelable;

public class List_Holder_Class implements Parcelable {
    int icon;
    String title, author, shortDescription, longDescription, pgNo;
    boolean isExpanded;

    public List_Holder_Class(int icon, String title, String author, String shortDescription, String longDescription, String pgNo) {
        this.icon = icon;
        this.title = title;
        this.author = author;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.pgNo = pgNo;
        isExpanded = false;
    }


    protected List_Holder_Class(Parcel in) {
        icon = in.readInt();
        title = in.readString();
        author = in.readString();
        shortDescription = in.readString();
        longDescription = in.readString();
        pgNo = in.readString();
        isExpanded = in.readByte() != 0;
    }

    public static final Creator<List_Holder_Class> CREATOR = new Creator<List_Holder_Class>() {
        @Override
        public List_Holder_Class createFromParcel(Parcel in) {
            return new List_Holder_Class(in);
        }

        @Override
        public List_Holder_Class[] newArray(int size) {
            return new List_Holder_Class[size];
        }
    };

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getPgNo() {
        return pgNo;
    }

    public int getIcon() {
        return icon;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(icon);
        dest.writeString(title);
        dest.writeString(author);
        dest.writeString(shortDescription);
        dest.writeString(longDescription);
        dest.writeString(pgNo);
        dest.writeByte((byte) (isExpanded ? 1 : 0));
    }
}
