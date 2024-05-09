package sg.edu.np.mad.madpractical4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        int Id = intent.getIntExtra("id", 0);
        User user = ListActivity.users.stream()
            .filter(u -> u.id == Id)
            .findFirst()
            .orElse(new User("John Doe", "MAD Developer", 0, false));
        TextView tvDescription = findViewById(R.id.tvDescription);
        TextView tvName = findViewById(R.id.tvName);
        Button btnFollow = findViewById(R.id.btnFollow);
        Button btnMessage = findViewById(R.id.button2);
        tvName.setText(user.name);
        tvDescription.setText(user.description);

        btnFollow.setText("Follow");
        btnFollow.setOnClickListener(v -> {
            if (user.followed) {
                btnFollow.setText("Follow");
                user.followed = false;
                Toast toast = Toast.makeText(this, "Unfollowed", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                btnFollow.setText("Unfollow");
                user.followed = true;
                Toast toast = Toast.makeText(this, "Followed", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}