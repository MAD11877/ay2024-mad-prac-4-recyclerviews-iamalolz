package sg.edu.np.mad.madpractical4;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {

    TextView nameTextView;
    TextView descriptionTextView;
    ImageView imageView;

    ImageView squareImageView;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.textView_name);
        descriptionTextView = itemView.findViewById(R.id.textView_description);
        imageView = itemView.findViewById(R.id.imageView_user);
        squareImageView = itemView.findViewById(R.id.squareImageView);
    }
}