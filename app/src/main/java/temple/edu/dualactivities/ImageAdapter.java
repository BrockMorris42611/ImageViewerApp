package temple.edu.dualactivities;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.graphics.Color.CYAN;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;

public class ImageAdapter extends BaseAdapter {

        Context context;
        ArrayList<Image> Cat_List; // this is the array list we made for our data set

        ImageAdapter(Context context, ArrayList<Image> Cat_List){
            this.context = context;
            this.Cat_List = Cat_List;
        }
        @Override
        public int getCount() {
            return Cat_List.size()-1;
        } // get the size of the array list
        @Override
        public Object getItem(int position) {
            return Cat_List.get(position);
        } // simply return the item at the specific position in the array list but return the name of that item
        @Override
        public long getItemId(int position) { return 0; }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            TextView nameTextView; LinearLayout catLinearLayout; // this is the view to be displayed at the when the drop down menu isnt clicked or basically when something has been clicked and is set to be seen

            if(convertView == null){ //first use and not yet recycled
                catLinearLayout = new LinearLayout(context); // set up the layout based on the context
                catLinearLayout.setOrientation(LinearLayout.VERTICAL); // give it the vertical layout to appear like a standard list
                catLinearLayout.setBackgroundColor(CYAN); //stand out with that nice cyan blue
                nameTextView = new TextView(context); // hold the given name of the cat or the item that we select
                catLinearLayout.addView(nameTextView); // add the textView to the layout to be displayed
            }else{
                catLinearLayout = (LinearLayout) convertView; // this si for when we are recycling to save resources
                nameTextView = (TextView) catLinearLayout.getChildAt(0); // since layouts are basically singular trees with the views as the nodes we do this
            }


            nameTextView.setGravity(Gravity.CENTER_HORIZONTAL);
            nameTextView.setText(Cat_List.get(position).getName()); //set the textView to display correct cat

            return catLinearLayout; //return the layout
        }
        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) { // this is used when we actually drop down the menu with the default arrow click

            TextView nameTextView; // this drop down is doing to store an image(ImageView) to the right of the name of the picture(TextView)
            LinearLayout catLinearLayout;
            ImageView cat_pic_holder;

            if (convertView == null) { //first use and not yet recycled
                catLinearLayout = new LinearLayout(context); //set up the view linearly as we did above but now give a red color to distinguish visibly
                catLinearLayout.setOrientation(LinearLayout.VERTICAL);

                if (position % 2 == 0) //BARBER POLE CAT SCREEN
                    catLinearLayout.setBackgroundColor(RED);
                else
                    catLinearLayout.setBackgroundColor(WHITE);

                nameTextView = new TextView(context); //get the new name and picture views set up
                cat_pic_holder = new ImageView(context);

                cat_pic_holder.setAdjustViewBounds(true); // need to use this to

                cat_pic_holder.setMaxHeight(100);

                catLinearLayout.addView(nameTextView); //add the two new vies to the new layout
                catLinearLayout.addView(cat_pic_holder);
            } else {
                catLinearLayout = (LinearLayout) convertView; // do this when the view is ready to be recycled
                nameTextView = (TextView) catLinearLayout.getChildAt(0);
                cat_pic_holder = (ImageView) catLinearLayout.getChildAt(1);
            }
            if(position == 0) // dont show the chooser option
                catLinearLayout.setVisibility(View.INVISIBLE);
            else {
                nameTextView.setText(Cat_List.get(position).getName()); //post the name
                cat_pic_holder.setImageResource(Cat_List.get(position).getPicture()); //post the picture
            }
            return catLinearLayout; //return the dropdown
        }
}
class Image{ //just to make having one array easier if not just eliminating need for 2 arrays which could become asymmetrical
    private final String name;
    private final int picture;

    Image(String name, int picture){
        this.name = name;
        this.picture = picture;
    }
    public String getName() {
            return name;
        }public int getPicture() {
            return picture;
        }
}
