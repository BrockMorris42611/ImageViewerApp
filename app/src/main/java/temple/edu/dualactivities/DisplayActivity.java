package temple.edu.dualactivities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class DisplayActivity extends AppCompatActivity {

    ImageView display;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        display = findViewById(R.id.sec_act_display); //get the image display ready
        description = findViewById(R.id.description_text_view);


        Bundle incoming_data = getIntent().getExtras(); // get the image we passed over from the extras of the intent that was given to this activity

        if(incoming_data != null){ //make sure we at least have something because we cant set null pictures or that givves exception

            int taken_image = incoming_data.getInt("image"); // get our value from incoming_data based on our shared key "image"
            String taken_string = incoming_data.getString("description");

            display.setImageResource(taken_image);// set the imageView to the picture we just extracted
            description.setText(taken_string);
            description.setTextSize(60);
        }
    }

}
