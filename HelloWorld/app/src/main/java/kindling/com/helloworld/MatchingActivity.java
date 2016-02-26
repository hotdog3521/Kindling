package kindling.com.helloworld;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.graphics.drawable.ColorDrawable;
import com.andtinder.model.CardModel;
import com.andtinder.view.CardContainer;
import com.andtinder.view.SimpleCardStackAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class MatchingActivity extends ActionBarActivity {

    boolean imageChanger = true;
    boolean imageChanger1 = false;
    int stopAnimation = 0;
    ImageView img;
    Thread animation;
    ImageView image;
    private CardContainer cardContainer;
    private int numSwipes;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching);
        setTitle("Matching");

        //Hiding grey title bar at the top of the screen.
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        ImageView noNewMatches = (ImageView) findViewById(R.id.no_new_matches);
        noNewMatches.setVisibility(View.INVISIBLE);

        img = (ImageView) findViewById(R.id.leftButton);

        ImageButton matchingBtn = (ImageButton) findViewById(R.id.machingOwl);
        matchingBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MathGameActivity.class);
                startActivity(intent);
            }
        });

        ImageButton msgBtn;
        msgBtn = (ImageButton) findViewById(R.id.messageButton);
        msgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainMessagesActivity.class);
                startActivity(intent);
            }
        });

        ImageButton settingsBtn;
        settingsBtn = (ImageButton) findViewById(R.id.settingButton);
        settingsBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SettingsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton acceptbtn;
        acceptbtn = (ImageButton) findViewById(R.id.rightButton);
        acceptbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //put boolean variable
                popUp(false);
                animation();
            }

        });
        //When information Button clicked
        ImageButton information;
        information = (ImageButton) findViewById(R.id.informationButton);
        information.setOnClickListener(new OnClickListener() {
           @Override
            public void onClick(View v) {
                    popUp(true);
           }
        });
        setupCards();

    }

    private void animation() {

        animation = new Thread() {
            public void run() {
                while (true) {
                    try {
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {

                                if(imageChanger)
                                {
                                    image.setImageResource(R.drawable.its_a_match_nowink);
                                    if(imageChanger1)
                                    {
                                        image.setImageResource(R.drawable.its_a_match);
                                        stopAnimation++;
                                    }
                                    imageChanger=false;
                                }
                                else if((!imageChanger) && (stopAnimation == 0))
                                {
                                    image.setImageResource(R.drawable.its_a_match_mid);

                                    imageChanger=true;
                                    imageChanger1 = true;

                                }
                            }
                        });
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(stopAnimation == 1)
                    {
                        stopAnimation = 0;
                        imageChanger = true;
                        imageChanger1 = false;
                        break;
                    }

                }
            }
        };
        animation.start();
    }

    private void setupCards() {
        cardContainer = (CardContainer) findViewById(R.id.cardContainer);
        Resources r = getResources();

        SimpleCardStackAdapter adapter = new SimpleCardStackAdapter(this);

        ArrayList<String> names = new ArrayList<>(Arrays.asList("Ford Filer", "Mark Redekopp", "Aaron Cote", "Max Nikias", "David Kempe"));
        ArrayList<Integer> resources = new ArrayList<>(Arrays.asList(R.drawable.ford_filer, R.drawable.mark_redekopp, R.drawable.aaron_cote, R.drawable.max_nikias, R.drawable.david_kempe));

        for (int i=0; i<5; i++) {
            numSwipes = 0;

            CardModel cardModel = new CardModel(names.get(i), null, r.getDrawable(resources.get(i)));
            cardModel.setOnClickListener(new CardModel.OnClickListener() {
                @Override
                public void OnClickListener() {
                    System.out.println("I am pressing the card");
                }
            });
            cardModel.setOnCardDimissedListener(new CardModel.OnCardDimissedListener() {
                @Override
                public void onLike() {
                    System.out.println("I like the card");
                    checkIfEmpty(numSwipes);
                }

                @Override
                public void onDislike() {
                    // for some reason this is what's called when you swipe right...
                    System.out.println("I dislike the card");
                    if(numSwipes >= 3) {
                        popUp(false);
                        animation();
                    }
                    checkIfEmpty(numSwipes);
                }
            });
            adapter.add(cardModel);
        }

        cardContainer.setAdapter(adapter);
    }

    private void checkIfEmpty(int ns) {
        numSwipes++;
        if (numSwipes == 5) {
            ImageView noNewMatches = (ImageView) findViewById(R.id.no_new_matches);
            noNewMatches.setVisibility(View.VISIBLE);

            ImageView infoButton = (ImageView) findViewById(R.id.informationButton);
            infoButton.setVisibility(View.INVISIBLE);

            ImageView rBtn = (ImageView) findViewById(R.id.rightButton);
            rBtn.setVisibility(View.INVISIBLE);

            ImageView lBtn = (ImageView) findViewById(R.id.leftButton);
            lBtn.setVisibility(View.INVISIBLE);

            ImageView matchBtn = (ImageView) findViewById(R.id.matching_button);
            matchBtn.setVisibility(View.INVISIBLE);
        }
    }

    private void popUp(boolean information) {

            if(!information)
            {
                //matching animation pops up
                mp = MediaPlayer.create(getApplicationContext(), R.raw.match_sound);
                mp.start();
                image = new ImageView(this);
                image.setImageResource(R.drawable.its_a_match);

            }else {
                //information image pops up
                image = new ImageView(this);
                image.setImageResource(R.drawable.how_to_play);
            }

            AlertDialog.Builder picturePopUp = new AlertDialog.Builder(this);
            picturePopUp.setView(image);

            AlertDialog helpDialog = picturePopUp.create();
            helpDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            helpDialog.show();
    }


}
