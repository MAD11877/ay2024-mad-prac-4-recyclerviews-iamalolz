package sg.edu.np.mad.madpractical4;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    public static ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);

        users = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Random random = new Random();
            int randomw = random.nextInt(100000000);
            String randomInt = Integer.toString(randomw);
            String randomInt2 = Integer.toString(randomw);
            User useri = new User("NAME", "DESCRIPTION", i, random.nextBoolean());
            useri.name += randomInt;
            useri.description += randomInt2;
            users.add(useri);
        }

        RecyclerView recyclerView = findViewById(R.id.recycler_main);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        UserAdapter userAdapter = new UserAdapter(users, this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(userAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
