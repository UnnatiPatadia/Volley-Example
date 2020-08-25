package app.unnati.volleyexample.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserList implements Parcelable
{

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("per_page")
    @Expose
    private Integer perPage;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("ad")
    @Expose
    private Ad ad;
    public final static Parcelable.Creator<UserList> CREATOR = new Creator<UserList>() {


        @SuppressWarnings({
                "unchecked"
        })
        public UserList createFromParcel(Parcel in) {
            return new UserList(in);
        }

        public UserList[] newArray(int size) {
            return (new UserList[size]);
        }

    }
            ;

    protected UserList(Parcel in) {
        this.page = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.perPage = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.total = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalPages = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.data, (app.unnati.volleyexample.model.Datum.class.getClassLoader()));
        this.ad = ((Ad) in.readValue((Ad.class.getClassLoader())));
    }

    public UserList() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(page);
        dest.writeValue(perPage);
        dest.writeValue(total);
        dest.writeValue(totalPages);
        dest.writeList(data);
        dest.writeValue(ad);
    }

    public int describeContents() {
        return 0;
    }

}
