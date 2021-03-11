package temple.edu.dualactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import static android.graphics.Color.CYAN;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;

public class SelectionActivity extends AppCompatActivity {

    ImageAdapter AdapterForCats;
    GridView menu;
    TextView instructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.activity_one_name);

        menu = findViewById(R.id.menu_gridView);

        menu.setNumColumns(3);

        instructions = findViewById(R.id.instruct_text_view);

        instructions.setText(R.string.instructions);
        instructions.setTextSize(20);

        Resources stringRes = getResources();
        String[] cat_pic_names = stringRes.getStringArray(R.array.cat_picture_names);

        ArrayList<Image> listToAdapter = new ArrayList<Image>(); //Create the array list to hold all the Image objects
        //In this part below i am setting up a new Image object for each image
        listToAdapter.add(new Image(cat_pic_names[0], R.drawable.black_kit));
        listToAdapter.add(new Image(cat_pic_names[1], R.drawable.gray_kit));
        listToAdapter.add(new Image(cat_pic_names[2], R.drawable.red_kit));
        listToAdapter.add(new Image(cat_pic_names[3], R.drawable.tigre));
        listToAdapter.add(new Image(cat_pic_names[4], R.drawable.white_kit));
        listToAdapter.add(new Image(cat_pic_names[5], R.drawable.cup_kits));


        AdapterForCats = new ImageAdapter(this ,listToAdapter); // set up the new adapter

        menu.setAdapter(AdapterForCats); // PASS THE ADAPTER THE DATA SET WE MADE ABOVE

        menu.setOnItemClickListener((parent, view, position, id) -> { //setOnItemClickListener is for the grid view as opp to spinner

            int passableImage = ((Image)parent.getItemAtPosition(position)).getPicture(); //get the immage at the position ready as an int
            String passableDescription = ((Image)parent.getItemAtPosition(position)).getName();

            Intent intent = new Intent(SelectionActivity.this, DisplayActivity.class); //set up the intent
            intent.putExtra("image", passableImage); //add image to intent
            intent.putExtra("description", passableDescription);
            startActivity(intent); //start the new activity
        });
    }
}