package sg.edu.np.mad.madpractical4;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private ArrayList<User> users;

    public UserAdapter(ArrayList<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_activity_list, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = users.get(position);
        holder.nameTextView.setText(user.name);
        holder.descriptionTextView.setText(user.description);
        holder.imageView.setOnClickListener(v -> {
            AlertDialog alertDialog = new AlertDialog.Builder(v.getContext())
                    .setTitle("Profile")
                    .setMessage(user.name)
                    .setPositiveButton("CLOSE", (dialog, which) -> {
                        dialog.dismiss();
                    })
                    .setNegativeButton("VIEW", (dialog, which) -> {
                        Intent intent = new Intent(v.getContext(), MainActivity.class);
                        intent.putExtra("id", user.id);
                        v.getContext().startActivity(intent);
                    })
                    .create();

            alertDialog.show();
        });
        if (user.name.endsWith("7")) {
            holder.squareImageView.setVisibility(View.VISIBLE);
            // Get the width of the screen
            int screenWidth = holder.itemView.getContext().getResources().getDisplayMetrics().widthPixels;
            // Set the width and height of squareImageView to match the width of the screen
            ViewGroup.LayoutParams params = holder.squareImageView.getLayoutParams();
            params.width = screenWidth;
            params.height = screenWidth;
            holder.squareImageView.setLayoutParams(params);
        } else {
            holder.squareImageView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount () {
        return users.size();
    }
}
