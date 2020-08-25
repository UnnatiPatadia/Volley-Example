package app.unnati.volleyexample.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ad implements Parcelable
{

    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("text")
    @Expose
    private String text;
    public final static Parcelable.Creator<Ad> CREATOR = new Creator<Ad>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Ad createFromParcel(Parcel in) {
            return new Ad(in);
        }

        public Ad[] newArray(int size) {
            return (new Ad[size]);
        }

    }
            ;

    protected Ad(Parcel in) {
        this.company = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.text = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Ad() {
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(company);
        dest.writeValue(url);
        dest.writeValue(text);
    }

    public int describeContents() {
        return 0;
    }

}
