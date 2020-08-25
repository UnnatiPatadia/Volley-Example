package app.unnati.volleyexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import app.unnati.volleyexample.R;
import app.unnati.volleyexample.model.Datum;
import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Datum> listItems;
    private Context context;

    public MyAdapter(List<Datum> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.raw_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Datum listitem = listItems.get(position);

        String name = listitem.getFirstName() + " " + listitem.getLastName();

        holder.txtName.setText(name);
        holder.txtEmail.setText(listitem.getEmail());
        Glide.with(context)
                .load(listitem.getAvatar())
                .placeholder(R.drawable.profile)
                .into(holder.img_user);;
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView img_user;
        TextView txtName,txtEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_user = itemView.findViewById(R.id.img_user);
            txtName = itemView.findViewById(R.id.txtName);
            txtEmail = itemView.findViewById(R.id.txtEmail);
        }
    }
}
