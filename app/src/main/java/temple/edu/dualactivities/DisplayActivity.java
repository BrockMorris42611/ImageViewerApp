package temple.edu.dualactivities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class DisplayActivity extends AppCompatActivity {

    ImageView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        display = findViewById(R.id.sec_act_display); //get the image display ready


        Bundle bundle = getIntent().getExtras(); // get the image we passed over from the extras of the intent that was given to this activity

        if(bundle != null){ //make sure we at least have something because we cant set null pictures or that givves exception

            int taken = bundle.getInt("image"); // get our value from bundle based on our shared key "image"

            display.setImageResource(taken);// set the imageView to the picture we just extracted
        }
    }

}
