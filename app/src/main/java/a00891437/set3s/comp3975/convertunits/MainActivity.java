package a00891437.set3s.comp3975.convertunits;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

/*User can choose if they want to convert KM to M or M to KM
 * depending on which button is chosen an edit text is disabled. */
    public void onRadioButtonClicked(final View view){

        EditText mText = (EditText) findViewById(R.id.MilesText);
        EditText kmText = (EditText) findViewById(R.id.KilometersText);
        mText.setText("");
        kmText.setText("");

        if(view.getId()== R.id.KmToMButton) {
            mText.setEnabled(false);
            kmText.setEnabled(true);

        }
        if(view.getId() == R.id.MToKmButton){
            kmText.setEnabled(false);
            mText.setEnabled(true);

        }
    }
    /*When the convert button is clicked this method checks which edittext is enabled
    * and then calculates*/
    public void onClickedText (final View view){
        EditText kilometers = (EditText) findViewById(R.id.KilometersText);
        EditText miles = (EditText) findViewById(R.id.MilesText);
        double km=  0;
        double m = 0;
        if(kilometers.isEnabled() == true){
            km = Double.parseDouble(kilometers.getText().toString());
            m = km * 0.621371;
            miles.setText(Double.toString(m));
        }

        if(miles.isEnabled() == true){
            m = Double.parseDouble(miles.getText().toString());
            km = m * 1.60934;
            kilometers.setText(Double.toString(km));
        }
    }
}
