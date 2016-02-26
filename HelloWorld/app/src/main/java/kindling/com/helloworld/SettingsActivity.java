package kindling.com.helloworld;

import model.kindling.Application;
import model.kindling.Range;
import model.kindling.User;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import helper.RangeSeekBar;

public class SettingsActivity extends ActionBarActivity {

    private RangeSeekBar<Integer> ageSeekBar;
    private RangeSeekBar<Integer> intelligenceSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setTitle("Settings");

        //Hiding grey title bar at the top of the screen.
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        setupSeekbars();
    }

    private void setupSeekbars() {

        // set up age range seek bar
        ageSeekBar = new RangeSeekBar<Integer>(this);
        ageSeekBar.setRangeValues(18, 60);

        // initial values
        Range ageRange = Application.getUser().getAgeRange();
        if (ageRange == null) {
            Range newRange = new Range(Application.getUser().getAge(), Application.getUser().getAge() + 2);
            Application.getUser().setAgeRange(newRange);
            ageRange = newRange;
        }
        ageSeekBar.setSelectedMinValue(ageRange.getStart());
        ageSeekBar.setSelectedMaxValue(ageRange.getFinish());

        // listener
        RelativeLayout ageLayout = (RelativeLayout) findViewById(R.id.ageRelativeLayout);
        ageLayout.addView(ageSeekBar);
        ageSeekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                Range ageRange = new Range(minValue, maxValue);
                Application.getUser().setAgeRange(ageRange);
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
            }
        });

        // set up intelligence range seek bar
        intelligenceSeekBar = new RangeSeekBar<Integer>(this);
        intelligenceSeekBar.setRangeValues(0, 100);

        // setup initial values
        Range intelligenceRange = Application.getUser().getIntelRange();
        if (intelligenceRange == null) {
            Range newRange = new Range(80, 100);
            Application.getUser().setAgeRange(newRange);
            intelligenceRange = newRange;
        }
        intelligenceSeekBar.setSelectedMinValue(intelligenceRange.getStart());
        intelligenceSeekBar.setSelectedMaxValue(intelligenceRange.getFinish());

        // update listener
        RelativeLayout intelligenceLayout = (RelativeLayout) findViewById(R.id.intelligenceRelativeLayout);
        intelligenceLayout.addView(intelligenceSeekBar);
        intelligenceSeekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                Range intelligenceRange = new Range(minValue, maxValue);
                Application.getUser().setIntelRange(intelligenceRange);
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_settings, menu);
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
}
